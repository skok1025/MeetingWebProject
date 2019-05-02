package com.meeting.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meeting.love.model.TestDTO;
import com.meeting.main.model.PlanDTO;
import com.meeting.mypage.model.CustomerDTO;
import com.meeting.mypage.model.CustomerDetailDTO;
import com.meeting.util.DBUtil;

/**
 * 회원가입 DB 작업관련 DAO 클래스
 * @author 김석현
 *
 */
public class JoinDAO {
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;
	
	public JoinDAO() {
		this.conn = DBUtil.getConnection();
	}

	/**
	 * 러브테스트 문제리스트를 반환하는 메소드
	 * @return
	 */
	public ArrayList<TestDTO> getTestList() {
		ArrayList<TestDTO> list = new ArrayList<TestDTO>();
		
		try {
			
			String sql = "select * from tblTest";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			while(rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setPnumber(rs.getString("pnumber"));
				dto.setContent(rs.getString("content"));
				dto.setScore(rs.getString("score"));
				
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * PlanTest 리스트를 반환하는 메소드
	 * @return
	 */
	public ArrayList<ExamDTO> getTestList(String exam) {
		ArrayList<ExamDTO> list = new ArrayList<ExamDTO>();
		
		try {
			String sql = "select * from tbl"+exam+" where kind = '회원'";
			stat = conn.prepareStatement(sql);
			rs =stat.executeQuery();
			
			while(rs.next()) {
				ExamDTO dto = new ExamDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setPnumber(rs.getString("pnumber"));
				dto.setScore(rs.getString("score"));
				dto.setContent(rs.getString("content"));
				dto.setPanswer(rs.getString("panswer"));
				dto.setKind(rs.getString("kind"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return null;
	}

	public ArrayList<ExamDTO> getAlacrityTestList() {
		ArrayList<ExamDTO> list = new ArrayList<>();
		
		try {
			
			String sql = "select * from tblAlacrity";
			stat = conn.prepareStatement(sql);
			rs =stat.executeQuery();
			
			while(rs.next()) {
				ExamDTO dto = new ExamDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setPnumber(rs.getString("pnumber"));
				dto.setScore(rs.getString("score"));
				dto.setContent(rs.getString("content"));
				dto.setPanswer(rs.getString("panswer"));
				dto.setKind(rs.getString("kind"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		JoinDAO dao = new JoinDAO();
		
		System.out.println(dao.getAlacrityTestList());
	}

	/**
	 * 유저 생성 첫번째 tblCustomer insert
	 * @param cdto
	 * @return 성공유무
	 */
	public int addUserfirst(CustomerDTO cdto) {

		try {
			String sql = "insert into tblCustomer values(customer_seq.nextval,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, cdto.getId());
			stat.setString(2, cdto.getName());
			stat.setString(3, cdto.getNick());
			stat.setString(4, cdto.getGender());
			stat.setString(5, cdto.getMseq());
			
			int result = stat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getMaxCseq() {

		try {
			
			String sql = "select max(seq) as maxseq from tblCustomer";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("maxseq");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addUserSecond(CustomerDetailDTO dto) {

		try {
			
			String sql = "insert into tblCustomerDetail values(CustomerDetail_seq.nextval,?,sysdate,'null',?,'50',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getPw());
			stat.setString(2, dto.getTel());
			stat.setString(3, dto.getAge());
			stat.setString(4, dto.getAbility());
			stat.setString(5, dto.getHeight());
			stat.setString(6, dto.getJob());
			stat.setInt(7, dto.getPlan());
			stat.setInt(8, dto.getHumor());
			stat.setInt(9, dto.getAlacrity());
			stat.setInt(10, dto.getSense());
			stat.setInt(11, dto.getExtrovert());
			stat.setInt(12,dto.getStyle());
			stat.setString(13, dto.getCseq());
			stat.setString(14, dto.getLtseq());
			stat.setString(15, dto.getSaseq());
			stat.setString(16, dto.getPseq());
			stat.setString(17, dto.getIntroduce());
			
			
			int result = stat.executeUpdate();
			stat.close();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	// 이상형 채우기용...
	public void addUsserThird(int cseq) {

		try {
			
			String sql = "insert into tblTypeDetail values(TypeDetail_seq.nextval,'20','빈칸',170,160,'빈칸',5,5,5,5,5,5,1,?,1)";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cseq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// 최근에 넣은 CustomerDetail Seq
	public int getMaxCdseq() {

		try {
			
			String sql = "select max(seq) as cdseq from tblCustomerDetail";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cdseq");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	// tblHobby 채우기용
	public void addUserFirth(int cdseq) {

		try {
			String sql = "insert into tblHobby values(Hobby_seq.nextval,1,?)";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cdseq);
			stat.executeUpdate();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 특정 cseq 의 image 속성을 수정하는 메소드
	 * 네이버 회원가입 시.
	 * @param cseq 특정 회원번호
	 * @param img 수정할 이미지
	 */
	public void updateImage(int cseq, String img) {
		try {
			
			String sql = "update tblCustomerDetail set image=? where cseq = ?";
			stat=  conn.prepareStatement(sql);
			stat.setString(1, img);
			stat.setInt(2, cseq);
			
			stat.executeUpdate();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 네이버 아이디가 기존에 회원가입 처리가 되어있으면 true 반환하는 메소드
	 * @param naverId 네이버 아이디
	 * @return 존재유무
	 */
	public boolean isExistId(String naverId) {

		try {
			String sql = "select count(*) as cnt from tblCustomer where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, naverId);
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

	
	
	
}
