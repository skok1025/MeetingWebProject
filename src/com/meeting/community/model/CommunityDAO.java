package com.meeting.community.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.meeting.mypage.model.CustomerDTO;
import com.meeting.util.DBUtil;

public class CommunityDAO {

	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	public CommunityDAO() {
		this.conn = DBUtil.getConnection();
	}
	

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * 게시물 수 총 갯수
	 * 
	 * @param category 카테고리 번호
	 * @param kind 회원 관리자?
	 * @param map 검색어 및 카테고리
	 * @param isSearch 검색어 유무
	 * @return 갯수 반환
	 */
	public int getTotalCountDate(String category, String kind, HashMap<String, String> map, boolean isSearch) {

		try {
			String sql = String.format("select count(*) as cnt from tblCommunity c inner join tblCustomer ct on ct.seq = c.cseq where kind=?");
			String where = "";

			if(category.equals("1") || category.equals("2") || category.equals("3")) {
				where = String.format(" and ccseq = ? ");
			}
			
			String search = "";
			
			if(isSearch) {
				if(map.get("column").equals("title")) {
					search = String.format(" and title like '%%%s%%'", map.get("word"));
				} else {
					search = String.format(" and ct.id = '%s'", map.get("word"));
				}
			}
			
			sql = sql + where + search;
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, kind);
			
			if(category.equals("1") || category.equals("2") || category.equals("3")) {
				stat.setString(2, category);
			}
			
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
	 * 커뮤니티 카테고리
	 * 
	 * @return 카테고리 반환
	 */
	public ArrayList<CommunityCategoryDTO> communitycategory() {

		try {

			String sql = "select * from tblCommunityCategory";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();

			ArrayList<CommunityCategoryDTO> list = new ArrayList<CommunityCategoryDTO>();

			while (rs.next()) {
				CommunityCategoryDTO dto = new CommunityCategoryDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setCategory(rs.getString("category"));

				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 커뮤니티 리스트 반환
	 * 
	 * @param kind 관리자 일반?
	 * @param map 시작 페이지 마지막 페이지 검색어
	 * @param category 카테고리 번호
	 * @param isSearch 검색 유무
	 * @return 커뮤니티 리스트 반환
	 */
	public ArrayList<CommunityDTO> community(String kind, HashMap<String, String> map, String category, boolean isSearch) {

		try {
			
			ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>();
			
			//카테고리
			String where = "";
			
			//검색
			String search = "";
			
			if(isSearch) {
				if(map.get("column").equals("title")) {
					search = String.format(" and title like '%%%s%%'", map.get("word"));
				} else {
					search = String.format(" and c.id = '%s'", map.get("word"));
				}
			}
			
			if(category.equals("1") || category.equals("2") || category.equals("3")) {
				where = String.format(" and cr.ccseq = ?");
			}
			
			String sql = String.format("select * from (select cr.*, rownum as rnum from tblCommunity cr" +
					"             inner join tblCustomer c on cr.seq = c.seq " +
					" where cr.kind=? %s %s order by cr.seq desc) c " + 
					"    inner join tblCommunityCategory tc " + 
					"        on tc.seq = c.ccseq" +
					"             where c.rnum between %s and %s",
					where,search,map.get("begin"),map.get("end"));
			
			System.out.println(sql);
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, kind);
			
			if(category.equals("1") || category.equals("2") || category.equals("3")) {
				stat.setString(2, category);
			}
			
			rs = stat.executeQuery();

			while (rs.next()) {

				CommunityDTO dto = new CommunityDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setImage(rs.getString("image"));
				dto.setKind(rs.getString("kind"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setWarning(rs.getString("warning"));
				dto.setCseq(rs.getString("cseq"));
				dto.setCcseq(rs.getString("ccseq"));
				dto.setRnum(rs.getString("rnum"));
				dto.setOrgfilename(rs.getString("orgfilename"));
				
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 회원 번호로 정보 가져오기
	 * 
	 * @param cseq 회원번호
	 * @return
	 */
	public CustomerDTO customerSeq(String cseq) {
		
		try {

			String sql = "select * from tblCustomer where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, cseq);
			
			rs = stat.executeQuery();
			
			CustomerDTO dto = new CustomerDTO();
			
			if(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				
				return dto;
			}

		} catch (Exception e) {
			System.out.println("BoardDAO.add :" + e.toString());
		}
		
		return null;
	}
	
	/**
	 * 회원 이름으로 정보 가져오기
	 * 
	 * @param cseq 회원번호
	 * @return
	 */
	public CustomerDTO customerName(String name) {
		
		try {

			String sql = "select * from tblCustomer where id = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			
			rs = stat.executeQuery();
			
			CustomerDTO dto = new CustomerDTO();
			
			if(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				
				return dto;
			}

		} catch (Exception e) {
			System.out.println("BoardDAO.add :" + e.toString());
		}
		
		return null;
	}

	/**
	 * 게시글 클릭시 나오는 정보 가져오기
	 * 
	 * @param seq 게시글 번호
	 * @return 게시글 정보
	 */
	public CommunityDTO communityGet(String seq) {

		try {

			String sql = "select c.*, (select id from tblCustomer where seq = c.cseq) as name from tblCommunity c where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);

			rs = stat.executeQuery();

			if (rs.next()) {

				CommunityDTO dto = new CommunityDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setImage(rs.getString("image"));
				dto.setKind(rs.getString("kind"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCseq(rs.getString("cseq"));
				dto.setCcseq(rs.getString("ccseq"));
				dto.setWarning(rs.getString("warning"));
				dto.setReadCount(rs.getString("readcount"));
				dto.setId(rs.getString("name"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 커뮤니티 댓글 가져오기 
	 * 
	 * @param seq 부모글 번호
	 * @return 커뮤니티 댓글 정보
	 */
	public ArrayList<CommunityCommentDTO> communityComment(String seq) {

		try {

			String sql = "select c.*, (select id from tblCustomer where seq = c.cseq) as name from tblCommunityComment c where cmseq = ? order by seq desc";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);

			rs = stat.executeQuery();

			ArrayList<CommunityCommentDTO> list = new ArrayList<CommunityCommentDTO>();

			while (rs.next()) {

				CommunityCommentDTO dto = new CommunityCommentDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCseq(rs.getString("cseq"));
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
	 * 답글쓰기
	 * 
	 * @param dto 답변 관련 정보
	 * @return 성공 여부
	 */
	public int addComment(CommunityCommentDTO dto) {

		try {

			String sql = "insert into tblcommunitycomment values (COMMUNITYCOMMENT_SEQ.nextval, ?,default,?,?)";

			stat = conn.prepareStatement(sql);

			stat.setString(1, dto.getContent());
			stat.setString(2, dto.getCseq());
			stat.setString(3, dto.getCmseq());

			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * 최근 답글 가져오기
	 * 
	 * @return 최근 답글 정보
	 */
	public CommunityCommentDTO getCommunityComment() {
		try {

			String sql = "select c.*, (select id from tblCustomer where seq = c.cseq) as name from tblCommunityComment c where seq = (select max(seq) from tblCommunityComment)";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();

			CommunityCommentDTO dto = new CommunityCommentDTO();

			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCseq(rs.getString("cseq"));
				dto.setCmseq(rs.getString("cmseq"));
				
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 커뮤니티 글쓰기
	 * 
	 * @param dto 커뮤니티 글쓰기 위한 정보 
	 * @return 성공 여부
	 */
	public int communityAdd(CommunityDTO dto) {
		
		try {

			String sql = "insert into tblCommunity (seq, title, content, attach, image, kind, regdate, cseq, ccseq,orgfilename) " + 
					"values (community_seq.nextval,?,?,?,?,?,default,?,?,?)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getAttach());
			stat.setString(4, dto.getImage());
			stat.setString(5, dto.getKind());
			stat.setString(6, dto.getCseq());
			stat.setString(7, dto.getCcseq());
			stat.setString(8, dto.getOrgfilename());
			
			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 자신이 작성한 리스트 가져오기
	 * 
	 * @param seq 회원 번호
	 * @return 회원 리스트 반환
	 */
	public ArrayList<CommunityDTO> getMyList(String seq) {
		
		try {
			ArrayList<CommunityDTO> list = new ArrayList<>();
			
			String sql = "select * from tblCommunity where cseq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);

			rs = stat.executeQuery();
			
			while(rs.next()) {
				CommunityDTO dto = new CommunityDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setImage(rs.getString("image"));
				dto.setKind(rs.getString("kind"));
				dto.setCseq(rs.getString("cseq"));
				dto.setCcseq(rs.getString("ccseq"));
				dto.setWarning(rs.getString("warning"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return null;
	}

	/**
	 * 카테고리 삭제
	 * 
	 * @param seq 카테고리 번호
	 * @return 카테고리 삭제 성공 여부
	 */
	public int communityDel(String seq) {
		
		try {

			String sql = "delete from tblCommunity where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 카테고리 댓글 삭제
	 * 
	 * @param seq 카테고리 번호
	 * @return 카테고리 댓글 삭제 성공 여부
	 */
	public int communitCommentDel(String seq) {
		
		try {

			String sql = "delete from tblCommunityComment where cmseq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 커뮤니티 수정
	 * 
	 * @param dto 커뮤니티 수정한 정보
	 * @return 성공 여부
	 */
	public int communityEdit(CommunityDTO dto) {
		
		try {

			String sql = "update tblCommunity set " + 
					"    title = ?, " + 
					"    content = ?, " + 
					"    attach = ?, " + 
					"    image = ?, " + 
					"    kind = ?, " + 
					"    ccseq = ?  " + 
					"where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getAttach());
			stat.setString(4, dto.getImage());
			stat.setString(5, dto.getKind());
			stat.setString(6, dto.getCcseq());
			stat.setString(7, dto.getSeq());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return 0;
	}

	/**
	 * 전체 리스트 가져오기
	 * 
	 * @return 리스트 반환
	 */
	public ArrayList<CommunityDTO> getMyList() {
		
		try {
			ArrayList<CommunityDTO> list = new ArrayList<>();
			
			String sql = "select * from tblCommunity";

			stat = conn.prepareStatement(sql);

			rs = stat.executeQuery();
			
			while(rs.next()) {
				CommunityDTO dto = new CommunityDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setImage(rs.getString("image"));
				dto.setKind(rs.getString("kind"));
				dto.setCseq(rs.getString("cseq"));
				dto.setCcseq(rs.getString("ccseq"));
				dto.setWarning(rs.getString("warning"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return null;
	}
	
	/**
	 * 경고 주기
	 * 
	 * @param seq 커뮤니티 번호
	 * @param warning 경고
	 * @return 경고 성공 여부
	 */
	public int communityWarning(String seq, String warning) {
		
		try {

			String sql = "update tblCommunity set " + 
					"    warning = ? " +  
					"where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, warning);
			stat.setString(2, seq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CommunityDAO.add :" + e.toString());
		}
		
		return 0;
	}
	
	
	/**
	 * 
	 * 추천 데이트 코스 카테고리 입력
	 * @return
	 */
	public ArrayList<CommunityCategoryDTO> category() {

		try {

			String sql = "select * from tblDateCategory";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();

			ArrayList<CommunityCategoryDTO> list = new ArrayList<CommunityCategoryDTO>();

			while (rs.next()) {
				CommunityCategoryDTO dto = new CommunityCategoryDTO();

				dto.setCategory(rs.getString("category"));

				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	/**
	 * 
	 * 페이징
	 * 총 게시물 수 가져오기
	 * @return
	 */
	
	public int getTotalCount() {

		try {
			String sql = String.format("select count(*) as cnt from tblDateRecommend");

			stat = conn.prepareStatement(sql);
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
	 * 
	 * 추천 데이트 코스 list출력
	 * @param isSearch
	 * @param map
	 * @return
	 */
	
	
	public ArrayList<DateRecommendDTO> list(boolean isSearch, HashMap<String, String> map) {

		try {
			
			ArrayList<DateRecommendDTO> list = new ArrayList<DateRecommendDTO>();


			String where = "";
			String where2 = "";
			
			if (isSearch) {
				// where  like '%%'
				where = String.format(" and category='%s' and title like '%%%s%%'"
										, map.get("column")
										, map.get("word"));
				System.out.println(where);
				
				where2 = String.format(" where category='%s' and title like '%%%s%%'"
										, map.get("column")
										, map.get("word"));
			}
			
			/*String sql = String.format("select * from (select d.*, rownum as rnum from vwDateList d) where rnum between %s and %s %s",map.get("begin"),map.get("end"), where);*/
			
			String sql = String.format("select * from (select d.*, rownum as rnum from vwDateList d %s) where rnum between %s and %s %s",where2,map.get("begin"),map.get("end"), where);
			
			System.out.println(sql);
			
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();

			while (rs.next()) {

				DateRecommendDTO dto = new DateRecommendDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setArea(rs.getString("area"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setCategorynum(rs.getString("categorynum"));
				dto.setManagernum(rs.getString("managernum"));
				dto.setLng(rs.getString("lng"));
				dto.setLat(rs.getString("lat"));
				dto.setManagername(rs.getString("managername"));
				dto.setId(rs.getString("id"));
				
				
				
				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	/**
	 * 
	 * 추천 데이트 코스 상세보기
	 * 
	 * @param seq
	 * @return
	 * 
	 */
	
	public DateRecommendDTO detail(String seq) {

		try {

			String sql = "select * from vwDateList where seq=?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				
				DateRecommendDTO dto = new DateRecommendDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setArea(rs.getString("area"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setCategorynum(rs.getString("categorynum"));
				dto.setManagernum(rs.getString("managernum"));
				dto.setId(rs.getString("id"));
				dto.setLng(rs.getString("lng"));
				dto.setLat(rs.getString("lat"));
				dto.setManagername(rs.getString("managername"));
				
				
				
				return dto;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * 
	 * 매니저 권한 - 추천 데이트 코스 등록
	 * @param dto
	 * @return
	 */
	
	
	public int add(DateRecommendDTO dto) {

		try {

			String sql = "insert into tblDateRecommend (seq, area, title, content, dcseq, mseq, lat, lng) values ( daterecommend_seq.nextval,?,?,?,?,?,?,?)";

			stat = conn.prepareStatement(sql);
			
			System.out.println(dto);
			
			stat.setString(1, dto.getArea());
			stat.setString(2, dto.getTitle());
			stat.setString(3, dto.getContent());
			stat.setString(4, dto.getCategory());
			stat.setString(5, dto.getManagernum());
			stat.setString(6, dto.getLat());
			stat.setString(7, dto.getLng());
			
			return stat.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public String getSeq() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 사용자 찾기
	 * @param seq
	 * @param id
	 * @return
	 */
	public boolean isOwner(String seq, String id) {

		try {

			String sql = "select count(*) as cnt from vwDateList where seq = ? and id=?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			stat.setString(2, id);
			
			rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
						
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 추천 데이트 코스 삭제
	 * @param seq
	 * @return
	 */
	public int del(String seq) {

		try {

			String sql = "delete from tblDateRecommend where seq=?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 댓글 목록 가져오기
	 * @param drseq
	 * @return
	 */

	public ArrayList<DateRecommendCommentDTO> listComment(String drseq) {

		try {

			String sql = "select drc.*, (select name from tblCustomer where seq=drc.cseq) as name from tblDateRecommendComment drc where drseq=? order by seq desc";

			stat = conn.prepareStatement(sql);
			stat.setString(1, drseq);
			
			rs = stat.executeQuery();
			
			ArrayList<DateRecommendCommentDTO> list = new ArrayList<DateRecommendCommentDTO>();
			
			while(rs.next()) {
				
				DateRecommendCommentDTO dto = new DateRecommendCommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setCseq(rs.getString("cseq"));
				dto.setDrseq(rs.getString("drseq"));
				dto.setRegdate(rs.getString("regdate"));
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
	 * 댓글 등록
	 * @param dto
	 * @return
	 */

	public int addComment(DateRecommendCommentDTO dto) {

		try {

			String sql = "insert into tblDateRecommendComment (seq,content,regdate,drseq,cseq) values (daterecommendcomment_seq.nextval, ?,default,?,?)";

			stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getContent());
			stat.setString(2, dto.getDrseq());
			stat.setString(3, dto.getCseq());
			
			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 최근에 작성한 댓글 가져오기
	 * @return
	 */
	public DateRecommendCommentDTO getContent() {

		try {

			String sql = "select drc.*, (select name from tblCustomer where seq=drc.cseq) as name from tblDateRecommendComment drc where seq = (select max(seq) from tblDateRecommendComment)";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			DateRecommendCommentDTO dto = new DateRecommendCommentDTO();
			
			if(rs.next()) {
				dto.setContent(rs.getString("content"));
				dto.setCseq(rs.getString("cseq"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setDrseq(rs.getString("drseq"));
				dto.setSeq(rs.getString("seq"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 댓글 삭제
	 * @param seq
	 * @return
	 */
	public int delComment(String seq) {

		try {

			String sql = "delete from tblDateRecommendComment where seq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 
	 *  추천 데이트 코스 글 삭제 전 댓글 삭제
	 * @param drseq
	 * @return
	 */
	public int delRecommendComment(String seq) {

		try {

			String sql = "delete from tblDateRecommendComment where drseq = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			return stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 매니저 아이디 리스트로 가져오기
	 * @return
	 */

	public ArrayList<DateRecommendDTO> getmanager() {

		try {

			String sql = "select * from tblManager";

			stat = conn.prepareStatement(sql);
			
			rs = stat .executeQuery();
			
			ArrayList<DateRecommendDTO> list = new ArrayList<DateRecommendDTO>();
			
			while(rs.next()) {
				
				DateRecommendDTO dto = new DateRecommendDTO();
				
				dto.setId(rs.getString("id"));
				
				list.add(dto);
			}

			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}




















