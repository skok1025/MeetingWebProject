package com.meeting.love.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meeting.util.DBUtil;

/**
 * LoveTest기능 DAO
 * 
 * @author 임광민
 *
 */

public class LoveDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	public LoveDAO() {
		this.conn = DBUtil.getConnection();
	}

	/**
	 * LoveTest 문제 반환 메소드
	 * 
	 * @return 문제 내용
	 */
	public ArrayList<TestDTO> question() {
		
		ArrayList<TestDTO> list = new ArrayList<>();
		
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
			System.out.println("BoardDAO.add :" + e.toString());
		}
		
		return null;
	}
	
	/**
	 * 테스트 결과 반환 메소드
	 * 
	 * @param finalresult 테스트 결과 seq
	 * @return 내용 반환
	 */
	public TestResultDTO testResult(int finalresult) {
		
		try {

			String sql = "select * from tblTestResult where seq = ?";
			
			stat = conn.prepareStatement(sql);
			stat.setInt(1, finalresult);

			rs = stat.executeQuery();
			
			TestResultDTO dto = new TestResultDTO();
			
			if(rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.add :" + e.toString());
		}
		
		return null;
	}
}
















