package com.meeting.matching.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.meeting.courtship.model.CustomerAllDetailDTO;
import com.meeting.util.DBUtil;

import oracle.jdbc.OracleTypes;

/**
 * Matching DAO
 * 
 * @author 한상민
 *
 */
public class MatchingDAO {
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	/**
	 *
	 */
	public MatchingDAO() {
		this.conn = DBUtil.getConnection();
	}

	/**
	 * 회원 정보 반환 메소드(나이)
	 * 
	 * @param min 최소 나이
	 * @param max 최대 나이
	 * @return 회원 정보
	 */
	public JSONArray getAgeCustomer(String min, String max) {
		JSONArray array = new JSONArray();
		try {

			String sql = "select * from vwSelectCustomer where age between ? and ? ";

			stat = conn.prepareStatement(sql);
			stat.setString(1, min);
			stat.setString(2, max);

			rs = stat.executeQuery();

			while (rs.next()) {

				JSONObject obj = new JSONObject();

				obj.put("seq", rs.getString("seq"));

				/*
				 * CustomerDetailDTO dto = new CustomerDetailDTO();
				 * dto.setHeight(rs.getString("height")); dto.setPw(rs.getString("pw"));
				 * dto.setAge(rs.getString("age")); dto.setTel(rs.getString("tel"));
				 * dto.setSeq(rs.getString("seq"));
				 */

				array.add(obj);

				// System.out.println(dto.getSeq());

			}

			return array;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 회원 정보 반환 메소드(지역구)
	 * 
	 * @param bigarea 지역구
	 * @return 회원 정보
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getAreaBig(String bigarea) {
		JSONArray array = new JSONArray();
		try {

			String sql = "select * from vwSelectArea where bigarea = ? ";

			stat = conn.prepareStatement(sql);
			stat.setString(1, bigarea);

			rs = stat.executeQuery();

			while (rs.next()) {
				JSONObject obj = new JSONObject();

				obj.put("bigarea", rs.getString("bigarea"));
				obj.put("smallarea", rs.getString("smallarea"));
				obj.put("seq", rs.getString("seq"));

				array.add(obj);
			}

			return array;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 회원 정보 반환 클래스
	 * 
	 * @param ppseq           로그인 회원 번호
	 * @param min             최소 나이
	 * @param max             최대 나이
	 * @param choiceBigArea   지역구
	 * @param choiceSmallArea 지역동
	 * @param gender          성별
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getChartList(String ppseq, String min, String max, String choiceBigArea, String choiceSmallArea,
			String gender) {
		JSONArray array = new JSONArray();
		try {

			String sql = "{call procSelectMatchingCustomer(?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement stat = conn.prepareCall(sql);
			stat.setString(1, ppseq);
			stat.setString(2, choiceBigArea);
			stat.setString(3, choiceSmallArea);
			stat.setString(4, min);
			stat.setString(5, max);
			stat.setString(6, gender);
			stat.registerOutParameter(7, OracleTypes.CURSOR);

			stat.executeQuery();

			rs = (ResultSet) stat.getObject(7);

			if (rs.next()) {

				JSONObject obj = new JSONObject();

				obj.put("seq", rs.getString("seq"));
				obj.put("id", rs.getString("id"));
				obj.put("name", rs.getString("name"));

				array.add(obj);
			}

			return array;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 매칭 결과 저장 메소드
	 * 
	 * @param cseq 회원 번호(매칭 보낸 사람)
	 * @param pseq 회원 번호(매칭 받는 사람)
	 * @return 매칭 성공/실패(1,0)
	 */
	public int setMatchingResult(String cseq, String pseq) {

		try {

			String sql = "insert into tblMatchResult(seq,accept,cseq,pcseq,regdate,confirm,sendseq, content) values (matchresult_seq.nextval,default, ?, ?, sysdate, default, ?, default)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, cseq);
			stat.setString(2, pseq);
			stat.setString(3, cseq);

			int result = stat.executeUpdate();

			if (result == 1) {
				sql = "insert into tblMatchResult(seq,accept,cseq,pcseq,regdate,confirm,sendseq, content) values (matchresult_seq.nextval,default, ?, ?, sysdate, default, ?, default)";

				stat = conn.prepareStatement(sql);
				stat.setString(1, pseq);
				stat.setString(2, cseq);
				stat.setString(3, cseq);

				result = stat.executeUpdate();
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 회원 정보 반환 클래스(랜덤 회원 번호)
	 * 
	 * @param randomCustomer 랜덤 회원 번호
	 * @return 회원 정보
	 */
	public ArrayList<CustomerAllDetailDTO> getManagerMatching(ArrayList<Integer> randomCustomer) {

		ArrayList<CustomerAllDetailDTO> list = new ArrayList<CustomerAllDetailDTO>();

		try {

			String sql = "select * from vwSelectCustomer where seq in(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stat = conn.prepareStatement(sql);
			stat.setInt(1, randomCustomer.get(0));
			stat.setInt(2, randomCustomer.get(1));
			stat.setInt(3, randomCustomer.get(2));
			stat.setInt(4, randomCustomer.get(3));
			stat.setInt(5, randomCustomer.get(4));
			stat.setInt(6, randomCustomer.get(5));
			stat.setInt(7, randomCustomer.get(6));
			stat.setInt(8, randomCustomer.get(7));
			stat.setInt(9, randomCustomer.get(8));

			rs = stat.executeQuery();

			int i = 0;

			while (rs.next()) {

				CustomerAllDetailDTO dto = new CustomerAllDetailDTO();
				dto.setAge(rs.getString("age"));
				dto.setBigarea(rs.getString("bigarea"));
				dto.setSmallarea(rs.getString("smallarea"));
				dto.setName(rs.getString("name"));
				dto.setHeight(rs.getString("height"));
				dto.setJob(rs.getString("job"));
				dto.setNick(rs.getString("nick"));
				dto.setSeq(rs.getString("seq"));
				dto.setManagerImage(rs.getString("managerImage"));
				dto.setManagerName(rs.getString("managerName"));
				list.add(i, dto);

				i++;

			}

			return list;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}
