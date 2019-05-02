package com.meeting.mypage.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.meeting.main.LoginDTO;
import com.meeting.matching.model.MatchResultDTO;
import com.meeting.util.DBUtil;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class MypageDAO {
	
	private Connection conn;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public MypageDAO() {
		this.conn = DBUtil.getConnection();
	}

	/**
	 * 회원 아이디를 넘겨주면 탈퇴하는 메소드
	 * @param id 회원 아이디
	 * @return 성공 유무
	 */
	public int withdraw(String id,String reason) {

		
		try {
		
			String sql = "{ call procDelCustomer(?,?,?)}";
			cstat = conn.prepareCall(sql);
			cstat.setString(1, id);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			cstat.setString(3, reason);
			cstat.executeQuery();
			
			int result = cstat.getInt(2);
			
			cstat.close();
			
			return result;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 지역 대분류 리스트를 반환하는 메소드
	 * @return 지역 대분류 리스트
	 */
	public ArrayList<String> getBigAreaList() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {

			String sql = "select bigarea from tblbigarea";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("bigarea"));
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 지역 대분류를 넘겨주면 해당하는 지역소분류 JSONArray 를 반환하는 메소드
	 * @param bigArea 지역 대분류
	 * @return 지역 소분류 JSONArray
	 */
	public JSONArray getSmallAreaList(String bigArea) {
		JSONArray list = new JSONArray();
		
		try {

			String sql = "select seq,smallarea from vwselectarea where bigarea = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, bigArea);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("seq", rs.getString("seq"));
				obj.put("smallarea", rs.getString("smallarea"));
				
				list.add(obj);
			}
			
			

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 회원상세정보 DTO 를 넘기면 그 정보에 맞춰서 회원상세정보 수정하는 메소드
	 * @param dto 수정할 회원정보 DTO
	 * @return 회원정보 수정 성공유무
	 */
	public int updateCustomerDetail(LoginDTO dto) {

		try {

			String sql = "update tblCustomerDetail set pw=?,tel=?,age=?,height=?,ability=?,job=?,introduce=?,saseq = (select seq from tblSmallArea where smallarea= ?) where cseq = (select seq from tblCustomer where id = ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getPw());
			pstat.setString(2, dto.getTel());
			pstat.setInt(3, dto.getAge());
			pstat.setInt(4, dto.getHeight());
			pstat.setString(5, dto.getAbility());
			pstat.setString(6, dto.getJob());
			pstat.setString(7, dto.getIntroduce());
			pstat.setString(8, dto.getSmallarea());
			pstat.setString(9, dto.getId());
			
			int result = pstat.executeUpdate();
			pstat.close();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원명, 닉네임 을 수정하는 메소드
	 * @param dto 수정후 DTO
	 * @return 수정 성공유무
	 */
	public int updateCustomer(LoginDTO dto) {

		try {

			String sql = "update tblCustomer set name=?, nick=? where id = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getNick());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원 정보 수정 메소드
	 * @param dto 수정 후 DTO
	 * @return 성공유무 (성공- 2)
	 */
	public int updateInfo(LoginDTO dto) {
		try {
			
			int result1 = updateCustomer(dto);
			int result2 = updateCustomerDetail(dto);
			
			int result = result1+result2;
			
			if(result == 2) {
				return 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 회원 아이디를 넘겨주면 해당회원의 지역 소분류을 반환하는 메소드
	 * @param id 회원아이디
	 * @return 해당회원의 지역 소분류
	 */
	public String getSmallarea(String id) {

		try {
			String sql = "select smallarea from tblSmallArea where seq = (select saseq from tblCustomerDetail where cseq = (select seq from tblCustomer where id = ?))";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("smallarea");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 회원 아이디를 넘겨주면 해당회원의 지역 대분류를 반환하는 메소드
	 * @param id 회원아이디
	 * @return 해당회원의 지역 대분류
	 */
	public String getBigarea(String id) {
		try {
			
			String sql = "select bigarea from tblbigarea where seq=(select baseq from tblSmallArea where seq = (select saseq from tblCustomerDetail where cseq = (select seq from tblCustomer where id = ?)))";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs= pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("bigarea");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 회원 아이디를 넘겨주면 프로필 사진명을 반환하는 메소드
	 * @param id 회원 아이디
	 * @return 프로필 사진명
	 */
	public String getImage(String id) {

		try {
			String sql = "select image from tblCustomerDetail where cseq=(select seq from tblCustomer where id = ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			if(rs.next()) {
				return rs.getString("image");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 해당 회원의 프로필을 교체하는 메소드
	 * @param profileName 교체할 프로필 사진명
	 * @param id 회원 아이디
	 * @return 성공유무
	 */
	public int updateProfileImage(String profileName, String id) {

		try {
			
			String sql = "update tblCustomerDetail set image = ? where cseq=(select seq from tblCustomer where id=?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, profileName);
			pstat.setString(2, id);
			
			
			int result = pstat.executeUpdate();
			pstat.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	

	
	/**
	 * 해당 회원의 점수 정보를 담은 DTO 를 반환하는 메소드
	 * @param id 회원 아이디
	 * @return 해당회원의 점수 정보
	 */
	public ScoreDTO getScoreDTO(String id) {
		ScoreDTO dto = new ScoreDTO();
		try {
			
			String sql = "select plan,humor,alacrity,sense,extrovert,style from tblCustomerDetail where cseq=(select seq from tblCustomer where id=?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setAlacrity(rs.getInt("alacrity"));
				dto.setExtrovert(rs.getInt("extrovert"));
				dto.setHumor(rs.getInt("humor"));
				dto.setPlan(rs.getInt("plan"));
				dto.setSense(rs.getInt("sense"));
				dto.setStyle(rs.getInt("style"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 회원 아이디를 넘겨주면 담당 매니저의 이름,아이디 반환해주는 메소드
	 * @param id 회원의 아이디
	 * @return 담당 매니저 정보
	 */
	public ManagerDTO getManagerInfo(String id) {
		
		ManagerDTO dto = new ManagerDTO();
		try {
			
			String sql = "select * from tblManager where seq=(select mseq from tblCustomer where id=?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setSsn(rs.getString("ssn"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setRegdate(rs.getString("regdate"));
			
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원 아이디를 넘겨주면 회원의 seq를 반환
	 * @param id 회원 아이디
	 * @return 회원의 SEQ
	 */
	public String getCseq(String id) {
		
		try {
			
			String sql = "select seq from tblCustomer where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("seq");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 매니저 SOS 등록 메소드
	 * @param dto 등록할 매니저 SOS DTO
	 * @return 성공 유무
	 */
	public int addManagerSOS(ManagerSOSDTO dto) {

		try {
			
			String sql = "insert into tblManagerSOS values(MANAGERSOS_SEQ.nextval,?,'처리중',null,sysdate,null,?,?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getCseq());
			pstat.setString(3, dto.getMseq());
			
			int result = pstat.executeUpdate();
			pstat.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원 id 를 넘겨주면 그 회원에 해당하는 매니저 sos 리스트 반환
	 * @param id 회원 아이디
	 * @return 매니저 SOS 리스트
	 */
	public ArrayList<ManagerSOSDTO> getManagerSOSList(String id) {
		
		ArrayList<ManagerSOSDTO> list = new ArrayList<ManagerSOSDTO>();
		try {
			
			String sql = "select * from tblManagerSOS where cseq = (select seq from tblCustomer where id=?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				ManagerSOSDTO dto = new ManagerSOSDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setStatus(rs.getString("status"));
				dto.setStatuscontent(rs.getString("statuscontent"));
				dto.setRegdate(rs.getString("regdate").substring(0, 19));
				dto.setStatusregdate(rs.getString("statusregdate"));
				dto.setCseq(rs.getString("cseq"));
				dto.setMseq(rs.getString("mseq"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 매니저 id 를 넘기면 담당 회원들이 작성한 managerSOS 중 처리안한 리스트 반환
	 * @param id 매니저 아이디
	 * @return ManagerSOS 중 처리가 안된 리스트
	 */

	public ArrayList<ManagerSOSDTO> getManagerSOSListMnodone(String id,String whereUserId) {
		ArrayList<ManagerSOSDTO> list = new ArrayList<ManagerSOSDTO>();
		
		try {
			String sql;
			if(whereUserId != "") {
			 sql = "select ms.seq as seq,c.nick as nick,c.gender as gender,cd.pw as pw,cd.regdate as userregdate,cd.image as image,cd.tel,cd.grade,(select grade from tblGrade where cd.grade between minscore and maxscore) as badge,cd.age as age,cd.ability as ability,cd.height as height, cd.plan,cd.humor,cd.alacrity,cd.sense,cd.extrovert,cd.style,cd.introduce,c.id as id,td.maxHeight,td.minHeight,td.job as pjob, ms.content as content,ms.status as status,ms.statuscontent as statuscontent, ms.regdate as regdate,c.name as name, ms.mseq, m.name as mname, m.id as mid from tblManagerSOS ms inner join tblCustomer c on c.seq = ms.cseq inner join tblmanager m on m.seq = c.mseq inner join tblCustomerDetail cd on c.seq = cd.cseq inner join tblTypeDetail td on td.cseq = c.seq where m.id = ? and ms.status='처리중'"+whereUserId;
			} else {
				sql = "select ms.seq as seq,c.nick as nick,c.gender as gender,cd.pw as pw,cd.regdate as userregdate,cd.image as image,cd.tel,cd.grade,(select grade from tblGrade where cd.grade between minscore and maxscore) as badge,cd.age as age,cd.ability as ability,cd.height as height, cd.plan,cd.humor,cd.alacrity,cd.sense,cd.extrovert,cd.style,cd.introduce,c.id as id,td.maxHeight,td.minHeight,td.job as pjob, ms.content as content,ms.status as status,ms.statuscontent as statuscontent, ms.regdate as regdate,c.name as name, ms.mseq, m.name as mname, m.id as mid from tblManagerSOS ms inner join tblCustomer c on c.seq = ms.cseq inner join tblmanager m on m.seq = c.mseq inner join tblCustomerDetail cd on c.seq = cd.cseq inner join tblTypeDetail td on td.cseq = c.seq where m.id = ? and ms.status='처리중'";
			}
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				ManagerSOSDTO dto = new ManagerSOSDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setStatus(rs.getString("status"));
				dto.setStatuscontent(rs.getString("statuscontent"));
				dto.setRegdate(rs.getString("regdate").substring(0, 19));
				dto.setName(rs.getString("name"));
				dto.setMseq(rs.getString("mseq"));
				dto.setMname(rs.getString("mname"));
				dto.setMid(rs.getString("mid"));
				dto.setImage(rs.getString("image"));
				dto.setNick(rs.getString("nick"));
				dto.setGender(rs.getString("gender"));
				dto.setPw(rs.getString("pw"));
				dto.setUserregdate(rs.getString("userregdate"));
				dto.setTel(rs.getString("tel"));
				dto.setGrade(rs.getString("grade"));
				dto.setBadge(rs.getString("badge"));
				dto.setAge(rs.getString("age"));
				dto.setAbility(rs.getString("ability"));
				dto.setHeight(rs.getString("height"));
				dto.setPlan(rs.getInt("plan"));
				dto.setHumor(rs.getInt("humor"));
				dto.setAlacrity(rs.getInt("alacrity"));
				dto.setSense(rs.getInt("sense"));
				dto.setExtrovert(rs.getInt("extrovert"));
				dto.setStyle(rs.getInt("style"));
				
				dto.setIntroduce(rs.getString("introduce"));
				dto.setMaxheight(rs.getString("maxheight"));
				dto.setMinheight(rs.getString("minheight"));
				dto.setPjob(rs.getString("pjob"));
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 처리가 된 매니저 SOS 리스트를 반환하는 메소드
	 * @param id 회원 아이디
	 * @param whereUserId 조건으로 상대방의 아이디
	 * @return ManagerSOS 리스트
	 */
	public ArrayList<ManagerSOSDTO> getManagerSOSListMdone(String id, String whereUserId) {
ArrayList<ManagerSOSDTO> list = new ArrayList<ManagerSOSDTO>();
		
		try {
			String sql;
			if(whereUserId != "") {
			 sql = "select ms.seq as seq,c.id as id, ms.content as content,ms.status as status,ms.statuscontent as statuscontent, ms.regdate as regdate,c.name as name, ms.mseq, m.name as mname, m.id as mid from tblManagerSOS ms inner join tblCustomer c on c.seq = ms.cseq inner join tblmanager m on m.seq = c.mseq where m.id = ? and ms.status='done'"+whereUserId;
			} else {
				sql = "select ms.seq as seq,c.id as id, ms.content as content,ms.status as status,ms.statuscontent as statuscontent, ms.regdate as regdate,c.name as name, ms.mseq, m.name as mname, m.id as mid from tblManagerSOS ms inner join tblCustomer c on c.seq = ms.cseq inner join tblmanager m on m.seq = c.mseq where m.id = ? and ms.status='done'";
			}
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				ManagerSOSDTO dto = new ManagerSOSDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setStatus(rs.getString("status"));
				dto.setStatuscontent(rs.getString("statuscontent"));
				dto.setRegdate(rs.getString("regdate").substring(0, 19));
				dto.setName(rs.getString("name"));
				dto.setMseq(rs.getString("mseq"));
				dto.setMname(rs.getString("mname"));
				dto.setMid(rs.getString("mid"));
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 성별을 넘겨주면 해당성별의 평균점수 DTO 를 반환하는 메소드
	 * @param gender 성별
	 * @return 해당성별 평균점수 DTO
	 */
	public ScoreAvgDTO getScoreAvgDTO(String gender) {
		ScoreAvgDTO dto = new ScoreAvgDTO();
		try {
			String sql = "select avg(plan) as plan,avg(alacrity) as alacrity,avg(sense) as sense,avg(extrovert) as extrovert,avg(style) as style,avg(humor) as humor  from tblCustomerDetail where cseq in (select seq from tblCustomer where gender = ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, gender);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setAlacrity(rs.getDouble("alacrity"));
				dto.setExtrovert(rs.getDouble("extrovert"));
				dto.setHumor(rs.getDouble("humor"));
				dto.setPlan(rs.getDouble("plan"));
				dto.setSense(rs.getDouble("sense"));
				dto.setStyle(rs.getDouble("style"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 매니저 SOS 에 대한 답변 처리
	 * @param seq 매니저 SOS 글번호
	 * @param statuscontent 답변 내용
	 * @return 성공 유무
	 */
	public int doneManagerSOS(String seq, String statuscontent) {
		
		try {
			String sql = "update tblManagerSOS set status='done', statuscontent=?, statusregdate = sysdate where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, statuscontent);
			pstat.setString(2, seq);
			
			int result  = pstat.executeUpdate();
			pstat.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	

	/**
	 * 탈퇴한 회원 리스트 반환 메소드
	 * @return 탈퇴한 회원 리스트
	 */
	public ArrayList<OutCustomerDTO> outCustomerList() {

		ArrayList<OutCustomerDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from tblOutCustomer";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				OutCustomerDTO dto = new OutCustomerDTO();
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setTel(rs.getString("tel"));
				dto.setRegdate(rs.getString("regdate").substring(0, 10));
				dto.setReason(rs.getString("reason"));
				
				list.add(dto);
				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 매니저 아이디를 넘겨주면 담당 회원들의 이름 아이디를 담은 리스트 반환
	 * @param mid 매니저 아이디
	 * @return 매니저 담당 회원 리스트
	 */
	public ArrayList<CustomerDTO> getCustomerList(String mid) {
		ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
		
		try {
			String sql = "select * from tblCustomer where mseq = (select seq from tblManager where id = ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, mid);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 회원 아이디를 넘기면 미팅결과 리스트 반환 메소드
	 * @param id 회원아이디
	 * @return 미팅 결과 리스트
	 */
	public ArrayList<MyMeetingDTO> getMeetingList(String id) {

		ArrayList<MyMeetingDTO> list = new ArrayList<MyMeetingDTO>();
		
		try {
			
			String sql = "select * from vwSelectMeetingInfo where  cseq = (select seq from tblCustomer where id = ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MyMeetingDTO dto = new MyMeetingDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setMyname(rs.getString("myname"));
				dto.setMyid(rs.getString("myid"));
				dto.setPname(rs.getString("pname"));
				dto.setPid(rs.getString("pid"));
				dto.setAccept(rs.getString("accept"));
				dto.setMycontent(rs.getString("mycontent"));
				dto.setPcontent(rs.getString("pcontent"));
				dto.setCategory(rs.getString("category"));
				dto.setMyscore(rs.getString("myscore"));
				dto.setPscore(rs.getString("pscore"));
				dto.setMyimg(rs.getString("myimg"));
				dto.setPimg(rs.getString("pimg"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 성별 사람수 반환
	 * @param gender 성별
	 * @return 해당 성별의 사람수
	 */
	public int getManCnt(String gender) {

		try {
			String sql = "select count(*) as cnt from tblCustomer where gender=?";
			pstat= conn.prepareStatement(sql);
			pstat.setString(1, gender);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 카테고리, 카운트 JSONArray 반환
	 * @return 데이트 카테고리, 횟수 JSONArray 
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getDateCategoryCntArray() {

		JSONArray array = new JSONArray();
		
		try {
			
			String sql = "select category,count(*) as cnt from tblDateGrade dg inner join tblDateCategory dc on dg.dcseq = dc.seq group by category";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("name", rs.getString("category"));
				obj.put("y", rs.getInt("cnt"));
				array.add(obj);
			}
			pstat.close();
			rs.close();
			
			return array;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 매니저 sos seq 를 통해 삭제
	 * @param seq 매니저 sos seq
	 * @return 성공 유무
	 */
	public int delManagerSOS(String seq) {

		try {
			
			String sql = "delete from tblManagerSOS where seq = ?";
			pstat= conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			pstat.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/**
	 * 담당 매니저 id 를 넘기면 담당 회원 리스트 반환
	 * @param mid 매니저 id
	 * @return 해당 매니저 담당회원 리스트
	 */
	public ArrayList<CustomerDetailDTO> getCustomerDetailList(String mid) {

		ArrayList<CustomerDetailDTO> list = new ArrayList<CustomerDetailDTO>();
		
		try {
			
			String sql = "select * from vwselectcustomer where mid = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, mid);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				CustomerDetailDTO dto = new CustomerDetailDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setMid(rs.getString("mid"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setGender(rs.getString("gender"));
				dto.setPw(rs.getString("pw"));
				dto.setRegdate(rs.getString("regdate").substring(0, 10));
				dto.setImage(rs.getString("image"));
				dto.setTel(rs.getString("tel"));
				dto.setGrade(rs.getString("grade"));
				dto.setAge(rs.getString("age"));
				dto.setAbility(rs.getString("ability"));
				dto.setJob(rs.getString("job"));
				dto.setPlan(rs.getInt("plan"));
				dto.setHumor(rs.getInt("humor"));
				dto.setAlacrity(rs.getInt("alacrity"));
				dto.setSense(rs.getInt("sense"));
				dto.setExtrovert(rs.getInt("extrovert"));
				dto.setStyle(rs.getInt("style"));
				dto.setContent(rs.getString("content"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setPtype(rs.getString("ptype"));
				dto.setMaxHeight(rs.getString("maxHeight"));
				dto.setMinHeight(rs.getString("minHeight"));
				dto.setSmallhobby(rs.getString("smallhobby"));
				dto.setBigarea(rs.getString("bigarea"));
				dto.setSmallarea(rs.getString("smallarea"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 회원 아이디를 넘겨주면 해당하는 상세정보를 담은 dto 반환하는 메소드
	 * @param cseq 회원 번호
	 * @return 해당 CustomerDetailDTO
	 */
	public CustomerDetailDTO getCustomerDetailByCseq(String cseq) {

		CustomerDetailDTO dto = new CustomerDetailDTO();
		
		try {
			String sql = "select * from vwselectcustomer where cseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, cseq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setMid(rs.getString("mid"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setGender(rs.getString("gender"));
				dto.setPw(rs.getString("pw"));
				dto.setRegdate(rs.getString("regdate").substring(0, 10));
				dto.setImage(rs.getString("image"));
				dto.setTel(rs.getString("tel"));
				dto.setGrade(rs.getString("grade"));
				dto.setAge(rs.getString("age"));
				dto.setAbility(rs.getString("ability"));
				dto.setJob(rs.getString("job"));
				dto.setPlan(rs.getInt("plan"));
				dto.setHumor(rs.getInt("humor"));
				dto.setAlacrity(rs.getInt("alacrity"));
				dto.setSense(rs.getInt("sense"));
				dto.setExtrovert(rs.getInt("extrovert"));
				dto.setStyle(rs.getInt("style"));
				dto.setContent(rs.getString("content"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setPtype(rs.getString("ptype"));
				dto.setMaxHeight(rs.getString("maxHeight"));
				dto.setMinHeight(rs.getString("minHeight"));
				dto.setSmallhobby(rs.getString("smallhobby"));
				dto.setBigarea(rs.getString("bigarea"));
				dto.setSmallarea(rs.getString("smallarea"));
				dto.setHeight(rs.getString("height"));
				dto.setBigarea(rs.getString("bigarea"));
			}
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 회원 아이디를 넘겨주면 해당하는 상세정보를 담은 dto 반환하는 메소드
	 * @param id 회원 아이디
	 * @return 회원 상세정보 dto
	 */
	public CustomerDetailDTO getCustomerDetail(String id) {

		CustomerDetailDTO dto = new CustomerDetailDTO();
		
		try {
			String sql = "select * from vwselectcustomer where id = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setMid(rs.getString("mid"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setGender(rs.getString("gender"));
				dto.setPw(rs.getString("pw"));
				dto.setRegdate(rs.getString("regdate").substring(0, 10));
				dto.setImage(rs.getString("image"));
				dto.setTel(rs.getString("tel"));
				dto.setGrade(rs.getString("grade"));
				dto.setAge(rs.getString("age"));
				dto.setAbility(rs.getString("ability"));
				dto.setJob(rs.getString("job"));
				dto.setPlan(rs.getInt("plan"));
				dto.setHumor(rs.getInt("humor"));
				dto.setAlacrity(rs.getInt("alacrity"));
				dto.setSense(rs.getInt("sense"));
				dto.setExtrovert(rs.getInt("extrovert"));
				dto.setStyle(rs.getInt("style"));
				dto.setContent(rs.getString("content"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setPtype(rs.getString("ptype"));
				dto.setMaxHeight(rs.getString("maxHeight"));
				dto.setMinHeight(rs.getString("minHeight"));
				dto.setSmallhobby(rs.getString("smallhobby"));
				dto.setBigarea(rs.getString("bigarea"));
				dto.setSmallarea(rs.getString("smallarea"));
				dto.setHeight(rs.getString("height"));
				dto.setBigarea(rs.getString("bigarea"));
			}
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 *  성격 유형 가져오기
	 * @return 성격 유형 리스트
	 */
	public ArrayList<PersonalityDTO> getPersonalityList() {

		ArrayList<PersonalityDTO> list = new ArrayList<PersonalityDTO>();
		
		try {
			
			String sql = "select seq,type from tblPersonality";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				PersonalityDTO dto = new PersonalityDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setType(rs.getString("type"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 회원의 cseq 를 넘기면 매칭결과 중 확인하지 않은 리스트 반환하는 메소드
	 * @param cseq 회원 번호
	 * @return 매칭 결과중 확인하지 않은 리스트
	 */
	public ArrayList<MatchOpponentDTO> getMatchResultNotConfirm(String cseq) {

		ArrayList<MatchOpponentDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from vwselectMatchOpponent where cseq=? and accept is null and confirm is null and sendseq != cseq and sendseq is not null";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, cseq);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MatchOpponentDTO dto = new MatchOpponentDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setCseq(rs.getString("cseq"));
				dto.setPcseq(rs.getString("pcseq"));
				dto.setAccept(rs.getString("accept"));
				dto.setConfirm(rs.getString("confirm"));
				dto.setSendseq(rs.getString("sendseq"));
				dto.setPid(rs.getString("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setPnick(rs.getString("pnick"));
				dto.setPgender(rs.getString("pgender"));
				dto.setPsmallarea(rs.getString("smallarea"));
				dto.setPimage(rs.getString("pimage"));
				dto.setPgrade(rs.getString("pgrade"));
				dto.setPbadge(rs.getString("pbadge"));
				dto.setPability(rs.getString("pability"));
				dto.setPjob(rs.getString("pjob"));
				dto.setPage(rs.getString("page"));
				dto.setPheight(rs.getString("pheight"));
				dto.setPintroduce(rs.getString("pintroduce"));
				dto.setContent(rs.getString("content"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}


	/**
	 * 매칭결과에 수락 또는 거절을 하면 이를 적용하는 메소드
	 * @param seq 매칭결과 seq
	 * @param accept 수락여부 y/n
	 * @param confirm 중간처리 middle
	 * @return 성공유무
	 */
	public int accepttblMatchResult(String seq, String accept, String confirm) {

		try {
			
			String sql = "update tblMatchResult set accept=?, confirm=? where seq=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, accept);
			pstat.setString(2, confirm);
			pstat.setString(3, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MypageDAO.accepttblMatchResult(): " + e.toString());
		}
		
		
		return 0;
	}

	
	/**
	 * 나의 cseq를 pcseq 에 넣어 상대방 확인 후 수락/ 거절 리스트 반환해주는 메소드 
	 * @param pcseq 내 seq
	 * @return 오늘의 인연 상대방의 수락/거절 리스트
	 */
	public ArrayList<MatchOpponentDTO> getMyCofirmMiddleList(String pcseq) {
		
		ArrayList<MatchOpponentDTO> list  = new ArrayList<MatchOpponentDTO>();
		
		try {
			
			String sql = "select * from VWSELECTMATCHOPPONENT where pcseq = ? and confirm = 'middle'";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pcseq);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				MatchOpponentDTO dto = new MatchOpponentDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setAccept(rs.getString("accept"));
				dto.setCseq(rs.getString("cseq"));
				dto.setPcseq(rs.getString("pcseq"));
				dto.setMyname(rs.getString("myname"));
				dto.setMyid(rs.getString("myid"));
				dto.setMyimage(rs.getString("myimage"));
				dto.setMytel(rs.getString("mytel"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("MypageDAO.getMyCofirmMiddleList(): " + e.toString());
		}
		
		return null;
	}

	/**
	 * MatchResult 에서 해당 결과의 확인 여부를 'confirm' 으로 수정하는 메소드
	 * @param seq 나의 seq
	 */
	public void updateConfirm(String seq) {

		try {
			String sql = "update tblMatchResult set confirm = 'confirm' where pcseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			System.out.println("MypageDAO.updateConfirm(): " + e.toString());
		}
	}
	

	/*public static void main(String[] args) {
	LoginDTO dto = new LoginDTO();
	dto.setId("deaelj89");
	dto.setName("김똑현");
	dto.setNick("떡현");
	 
	
	MypageDAO dao = new MypageDAO();
	//System.out.println(dao.getSmallarea("deaelj89"));
	
	//System.out.println(dao.getImage("deaelj89"));
	//System.out.println(dao.getScoreAvgDTO("남자"));
	
	ArrayList<MyMeetingDTO> list = dao.getMeetingList("uealda64");
	System.out.println(list.size());
	for(MyMeetingDTO item:list) {
		System.out.println(item.getSeq());
	}
}*/
}
