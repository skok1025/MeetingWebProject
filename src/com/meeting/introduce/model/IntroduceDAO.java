package com.meeting.introduce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meeting.util.DBUtil;

public class IntroduceDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;
	
	public IntroduceDAO() {
		this.conn = DBUtil.getConnection();
	}

	public IntroduceDTO list() {
		
		String convert = "";
		String age ="";
		int convertAge = 0;
		
		//매니저 정보 반환
		try {
			String sql = "select * from tblManager";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if(rs.next()) {
				IntroduceDTO dto =  new IntroduceDTO();
				
				dto.setName(rs.getString("name"));
				dto.setSeq(rs.getString("seq"));
				
				
				//dto.setManagerInfo(rs.getString("managerInfo"));
				convert = rs.getString("managerInfo");
				convert = convert.replace("\\r\\n","<br>");
				dto.setManagerInfo(convert);
				
				age = rs.getString("ssn");
				convertAge = 2018 - (Integer.parseInt(age.substring(0, 2)) + 1900);
				//System.out.println("age : " + age);
				//System.out.println("covAge : " + convertAge);
				dto.setAge(convertAge);
				
				//System.out.println(dto.getManagerInfo());				
				//System.out.println(dto.getName());
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return null;
	}

	public ArrayList<IntroduceDTO> managerList() {
		
		String convert = "";
		String age ="";
		int convertAge = 0;
		
		//managerList
		try {
			String sql = "select *from tblManager";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			ArrayList<IntroduceDTO> ilist = new ArrayList<IntroduceDTO>();
			
			while(rs.next()) {
				IntroduceDTO dto =  new IntroduceDTO();
				
				dto.setName(rs.getString("name"));
				dto.setSeq(rs.getString("seq"));
				
				
				//dto.setManagerInfo(rs.getString("managerInfo"));
				convert = rs.getString("managerInfo");
				convert = convert.replace("\\r\\n","<br>");
				dto.setManagerInfo(convert);
				
				age = rs.getString("ssn");
				convertAge = 2018 - (Integer.parseInt(age.substring(0, 2)) + 1900);
				//System.out.println("age : " + age);
				//System.out.println("covAge : " + convertAge);
				dto.setAge(convertAge);
				
				//System.out.println(dto.getManagerInfo());				
				//System.out.println(dto.getName());
				ilist.add(dto);
				//System.out.println("ilist : " + ilist);
				dto.setImage(rs.getString("image"));
				
			}
			return ilist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CustomerDTO> customerList() {
		
		//좋아요 수 상위 세 명의 정보 반환
		try {
			String sql = "select rownum, customerSeq, customername, cntGood, image, nickname, age, job from " + 
					"    (select customerSeq, count(customerSeq) as cntGood, customername, image, nickname, age, job from vwSelectMaxProfileCnt " + 
					"        group by customerSeq, customername, image, nickname, age, job " + 
					"            order by count(customerseq) desc) where rownum <=3 ";
			
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			ArrayList<CustomerDTO> clist = new ArrayList<CustomerDTO>();
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				
				dto.setRownum(rs.getString("rownum"));
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setCustomerName(rs.getString("customerName"));
				dto.setCntGood(rs.getString("cntGood"));
				dto.setImage(rs.getString("image"));
				
				dto.setNickname(rs.getString("nickname"));
				dto.setAge(rs.getString("age"));
				dto.setJob(rs.getString("job"));
				
				clist.add(dto);
			}
			
			return clist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
