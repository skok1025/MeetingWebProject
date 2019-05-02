package com.meeting.courtship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meeting.matching.model.MatchResultDTO;
import com.meeting.util.DBUtil;

/**
 * 프로필 DAO
 * 
 * @author 이인열
 *
 */

public class CourtshipDAO {

	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	public CourtshipDAO() {
		this.conn = DBUtil.getConnection();
	}

	/**
	 * 회원 간단 정보 출력 Profile
	 * 
	 * @return 간단정보 반환
	 */
	public ArrayList<CustomerProfileDTO> list() {

		try {

			ArrayList<CustomerProfileDTO> list = new ArrayList<CustomerProfileDTO>();

			String sql = "select * from tblCustomer c " + "    inner join tblCustomerDetail cd "
					+ "        on c.seq = cd.seq";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();

			while (rs.next()) {

				CustomerProfileDTO dto = new CustomerProfileDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setGender(rs.getString("gender"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setAge(rs.getString("age"));
				dto.setImage(rs.getString("image"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	    * 회원번호를 입력하면 프로필 사진들 리스트 반환
	    * @param seq
	    * @return
	    */
	   public ArrayList<ProfileImagesDTO> getProfileImg(String seq) {
	      ArrayList<ProfileImagesDTO> list = new ArrayList<>();
	      try {
	         
	         String sql = "select * from tblProfileImages where cseq = ?";
	         stat = conn.prepareStatement(sql);
	         stat.setString(1, seq);
	         
	         rs = stat.executeQuery();
	         
	         while(rs.next()) {
	            ProfileImagesDTO dto = new ProfileImagesDTO();
	            dto.setCseq(rs.getString("cseq"));
	            dto.setSeq(rs.getString("seq"));
	            dto.setImg1(rs.getString("img1"));
	            dto.setImg2(rs.getString("img2"));
	            dto.setImg3(rs.getString("img3"));
	            dto.setImg4(rs.getString("img4"));
	            dto.setImg5(rs.getString("img5"));
	            list.add(dto);
	         }
	         return list;
	      } catch (Exception e) {
	         System.out.println("CourtshipDAO.getProfileImg(): " + e.toString());
	      }
	      
	      return null;
	   }
	/**
	 * 회원 홈페이지 출력 정보
	 * 
	 * @return 회원 홈페이지 출력 정보 반환
	 */
	public CustomerAllDetailDTO detail(String seq) {

		try {

			CustomerAllDetailDTO dto = new CustomerAllDetailDTO();

			String sql = "select " + "  tr.content,  c.seq," + "    c.id," + "    c.name," + "    c.nick,"
					+ "    cd.image," + "    cd.grade," + "    cd.age," + "    cd.ability," + "    cd.height,"
					+ "    cd.job," + "    cd.introduce," + "    cd.plan as cplan," + "    cd.humor as chumor,"
					+ "    cd.alacrity as calacrity," + "    cd.sense as csense," + "    cd.extrovert as cextrovert,"
					+ "    cd.style as cstyle," + "    td.plan as lplan," + "    td.humor as lhumor,"
					+ "    td.alacrity as lalacrity," + "    td.sense as lsense," + "    td.extrovert as lextrovert,"
					+ "    td.style as lstyle " + " from tblCustomer c" + "    inner join tblCustomerDetail cd"
					+ "        on c.seq = cd.seq" + "            inner join tbltypedetail td"
					+ "                on c.seq = td.cseq inner join tblTestResult tr on cd.ltseq = tr.seq"
					+ "               where c.seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);

			rs = stat.executeQuery();

			if (rs.next()) {
				dto.setContent(rs.getString("content"));
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setImage(rs.getString("image"));
				dto.setGrade(rs.getString("grade"));
				dto.setAge(rs.getString("age"));
				dto.setAbility(rs.getString("ability"));
				dto.setHeight(rs.getString("height"));
				dto.setJob(rs.getString("job"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setCplan(rs.getString("cplan"));
				dto.setChumor(rs.getString("chumor"));
				dto.setCalacrity(rs.getString("calacrity"));
				dto.setCsense(rs.getString("csense"));
				dto.setCextrovert(rs.getString("cextrovert"));
				dto.setCstyle(rs.getString("cstyle"));
				dto.setLplan(rs.getString("lplan"));
				dto.setLhumor(rs.getString("lhumor"));
				dto.setLalacrity(rs.getString("lalacrity"));
				dto.setLsense(rs.getString("lsense"));
				dto.setLextrovert(rs.getString("lextrovert"));
				dto.setLstyle(rs.getString("lstyle"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 프로필 좋아요 중복 방지 메소드
	 * 
	 * @param cseq 회원 번호
	 * @param pseq 프로필 번호
	 * @return 좋아요 숫자 반환
	 */
	public int getGood(String cseq, String pseq) {

		try {

			String sql = "select count(*) as cnt from tblProfileGood where cseq = ? and  pseq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, cseq);
			stat.setString(2, pseq);
			rs = stat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 좋아요 누르기
	 *  
	 * @param cseq 회원 번호
	 * @param pseq 프로필 번호
	 * @return 성공 여부
	 */
	public int addGood(String cseq, String pseq) {

		try {

			String sql = "insert into tblProfileGood (seq, good, cseq, pseq) values(good_seq.nextval, 1, ?, ?)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, cseq);
			stat.setString(2, pseq);

			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 좋아요 수 가져오는 메소드
	 * 
	 * @param seq 프로필 번호
	 * @return 좋아요 수
	 */
	public int getLoveCnt(int seq) {

		try {

			String sql = "select count(*) as cnt from tblProfileGood where pseq = ?";

			stat = conn.prepareStatement(sql);
			stat.setInt(1, seq);

			rs = stat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 쪽지로 매칭 하는 메소드
	 * 
	 * @param dto 매칭 정보
	 * @return 결과 반환
	 */
	public int profileMatchResult(MatchResultDTO dto) {

		try {

			String sql = "insert into tblMatchResult  " + "(seq, cseq, pcseq, regdate, content,accept,sendseq,confirm) "
					+ "values " + "(matchresult_seq.nextval, ?,?,sysdate,?,default,?,default)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getPcseq());
			stat.setString(2, dto.getCseq());
			stat.setString(3, dto.getContent());
			stat.setString(4, dto.getCseq());

			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 쪽지로 매칭 하는 메소드
	 * 
	 * @param dto 매칭 정보
	 * @return 결과 반환
	 */
	public int pprofileMatchResult(MatchResultDTO dto) {

		try {

			String sql = "insert into tblMatchResult  " + "(seq, cseq, pcseq, regdate, content,accept,sendseq,confirm) "
					+ "values " + "(matchresult_seq.nextval, ?,?,sysdate,?,default,?,default)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getCseq());
			stat.setString(2, dto.getPcseq());
			stat.setString(3, dto.getContent());
			stat.setString(4, dto.getCseq());

			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
