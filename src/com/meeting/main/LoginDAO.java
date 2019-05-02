package com.meeting.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.meeting.util.DBUtil;

import java.sql.Connection;


/**
 * 로그인 관련 DB 작업 Servlet 클래스
 * @author 김석현
 *
 */
public class LoginDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;
	
	public LoginDAO() {
		this.conn = DBUtil.getConnection();
	}

	
	/**
	 * 로그인 DTO 를 넘겨주면 로그인 성공시, 상세정보를 담은 DTO 를 반환하는 메소드
	 * @param dto 로그인 DTO
	 * @return 로그인 후 상세정보를 담은 DTO
	 */
	public LoginDTO login(LoginDTO dto) {

		LoginDTO user = new LoginDTO();
		
		try {

			String sql = "select * from vwselectcustomer where id=? and pw=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				user.setCseq(rs.getString("cseq"));
				user.setMseq(rs.getString("mseq"));
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setNick(rs.getString("nick"));
				user.setGrade(rs.getString("grade"));
				user.setPw(rs.getString("pw"));
				user.setImage(rs.getString("image"));
				user.setTel(rs.getString("tel"));
				user.setAge(rs.getInt("age"));
				user.setAbility(rs.getString("ability"));
				user.setHeight(rs.getInt("height"));
				user.setJob(rs.getString("job"));
				user.setSmallhobby(rs.getString("smallhobby"));
				user.setSmallarea(rs.getString("smallarea"));
				user.setBigarea(rs.getString("bigarea"));
				user.setContent(rs.getString("content"));
				user.setIntroduce(rs.getString("introduce"));
				user.setGender(rs.getString("gender"));
				
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/**
	 * 매니저 로그인 DTO 를 넘겨주면 성공여부에 따라 로그인 상세정보를 담은 DTO를 반환해주는 메소드
	 * @param dto 매니저 로그인 DTO
	 * @return 매니저 로그인 상세정보 DTO 
	 */
	public LoginDTO managerLogin(LoginDTO dto) {
		LoginDTO manager = new LoginDTO();

		try {
			String sql = "select * from tblManager where id=? and pw=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			
			rs= stat.executeQuery();
			
			if(rs.next()) {
				manager.setSeq(rs.getString("seq"));
				manager.setId(rs.getString("id"));
				manager.setPw(rs.getString("pw"));
				manager.setSsn(rs.getString("ssn"));
				manager.setName(rs.getString("name"));
				manager.setAge(rs.getInt("age"));
				manager.setRegdate(rs.getString("regdate"));
				manager.setImage(rs.getString("image"));
				
				return manager;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 관리자 로그인 DTO 넘겨주면 성공에 따라 로그인 DTO를 다시 넘겨주는 메소드
	 * @param dto 관리자 로그인 DTO
	 * @return 관리자 로그인 DTO
	 */
	public LoginDTO adminLogin(LoginDTO dto) {
		LoginDTO admin = new LoginDTO();
		
		try {
			
			String sql = "select * from tblAdmin where id =? and pw=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				admin.setId(rs.getString("id"));
				admin.setPw(rs.getString("pw"));
				
				return admin;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 로그인 ID 를 넘겨주면 회원인지 아닌지 반환하는 메소드
	 * @param id 회원 로그인 ID
	 * @return 회원 여부
	 */
	public boolean isUser(String id) {

		try {
			
			String sql = "select count(*) as cnt from tblCustomer where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("cnt") == 1) {
					return true;
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 로그인 ID 를 넘겨주면 매니저인지 아닌지 반환하는 메소드
	 * @param id 로그인 ID
	 * @return 매니저 여부
	 */
	public boolean isManager(String id) {

		try {
			
			String sql = "select count(*) as cnt from tblManager where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("cnt") == 1) {
					return true;
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 로그인 ID 를 넘겨주면 관리자인지 아닌지 반환하는 메소드
	 * @param id 로그인 ID
	 * @return 관리자 여부
	 */
	public boolean isAdmin(String id) {

		try {
			
			String sql = "select count(*) as cnt from tblAdmin where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("cnt") == 1) {
					return true;
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 유저 id 입력하면 프로필 사진 반환해주는 메소드
	 * @param id 유저 아이디
	 * @return 프로필 사진 명 
	 */
	public String getProfileIm(String id) {

		try {
			
			String sql = "select image from tblCustomerDetail where cseq = (select seq from tblcustomer where id= ?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			
			rs = stat.executeQuery();
			if(rs.next()) {
				return rs.getString("image");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 매니저 ID 를 넘겨주면 해당 매니저의 프로필 사진을 반환하는 메소드
	 * @param id 매니저 ID
	 * @return 매니저 프로필 사진명
	 */
	public String getProfileImManager(String id) {

		try {
			
			String sql = "select image from tblManager where id= ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			
			rs = stat.executeQuery();
			if(rs.next()) {
				return rs.getString("image");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	/**
	 * 회원의 점수(grade) 를 넘겨주면 점수에 맞는 뱃지를 반환하는 메소드
	 * @param grade 회원의 점수
	 * @return 뱃지 파일이름명
	 */
	public String getBadge(String grade) {

		try {
			String sql = "select grade from tblGrade where ? between minscore and maxscore";
			stat = conn.prepareStatement(sql);
			stat.setString(1, grade);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("grade");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 입력한 id 가 현재 존재하는 아이디인지 확인하는 메소드
	 * @param id 입력 id
	 * @return 존재유무 (0 없음, 1 있음)
	 */
	public int idcheck(String id) {

		try {
			String sql = "select count(*) as cnt from tblCustomer where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/**
	 * 로그인 성공 유무를 반환하는 메소드
	 * @param dto 로그인 dto
	 * @return 로그인 성공유무
	 */
	public int loginOk(LoginDTO dto) {

		try {
			
			String sql = "select count(*) as cnt from tblcustomer c inner join tblcustomerdetail cd on c.seq = cd.cseq where id = ? and pw = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	

	
	
	

}
