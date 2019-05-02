package com.meeting.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.community.model.CommunityCategoryDTO;
import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.CommunityDTO;
import com.meeting.mypage.model.CustomerDTO;

/**
 * 관리자/회원 게시판
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/allcommunity.do")
public class AllCommunity extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CommunityDAO dao = new CommunityDAO();
		
		ArrayList<CommunityCategoryDTO> clist = dao.communitycategory(); 
		
		HashMap<String, String> map = new HashMap<String, String>();// 임시 dto
		
		// 페이징 관련 변수
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지 출력 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // where rnum between 시작
		int end = 0; // where rnum between 끝
		int n = 0; // 페이지바 제작(페이지네이션)
		int loop = 0;
		int blockSize = 10;
		
		boolean isSearch = false;
		
		//검색어
		String word = req.getParameter("word");
		//검색컬럼
		String column = req.getParameter("column");
		//page받기
		String page = req.getParameter("page");
		//카테고리 받기
		String category = req.getParameter("category");
		//종류 받기
		String kind = req.getParameter("kind");

		//검색어 map에 넣기
		if (word != null && column != null && word!="" && column!="") {
			isSearch = true;
			
			map.put("word", word);
			map.put("column", column);
		}
		
		//page가 null이면 1페이지 처음...
		if (page == null || page == "")
			nowPage = 1;
		else
			nowPage = Integer.parseInt(page);
		
		if (category == null || category == "")
			category = "0";
		
		if (kind == null || kind == "")
			kind = "0";
		
		//시작과 끝 페이지 지정
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		//map에 시작과 끝 페이지 넣기
		map.put("begin", begin + "");
		map.put("end", end + "");
				
		//총 게시물 수
		if(category.equals("1")) {
			totalCount = dao.getTotalCountDate(category,kind,map,isSearch);
			System.out.println("총게시물수 : " + totalCount);
		} else if(category.equals("2")) {
			totalCount = dao.getTotalCountDate(category,kind,map,isSearch);
			System.out.println("총게시물수 : " + totalCount);
		} else if(category.equals("3")) {
			totalCount = dao.getTotalCountDate(category,kind,map,isSearch);
			System.out.println("총게시물수 : " + totalCount);
		} else if(category.equals("0")){
			totalCount = dao.getTotalCountDate(category,kind,map,isSearch);
			System.out.println("총게시물수 : " + totalCount);
		}
		
		//총 페이지 수
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		System.out.println("총페이지수 : " + totalPage);

		// 페이지바 제작
		String pagebar = "<nav><ul class=\"pagination\">";

		loop = 1; // 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 페이지 바의 페이지 번호 변수

		if (n == 1) {
			pagebar += String.format("<li class='disabled'>\r\n"
					+ "<a href=\"#\" onclick='event.preventDefault();' aria-label=\"Previous\">"
					+ "<span aria-hidden=\"true\">&laquo;</span>\r\n" 
					+ "</a>\r\n"
					+ "</li>");
		} else {
			pagebar += String.format("<li>\r\n" 
					+ "<a href='/Meeting/community/allcommunity.do?kind=%s&category=%s&page=%d' aria-label=\"Previous\">\r\n"
					+ "<span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "</a>\r\n"
					+ "</li>",
					kind, category, n - 1);
		}
		
		System.out.println("word = " + word);
		
		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				pagebar += String.format("<li class='active'><a href='#' onclick='event.preventDefault();'>%d</a></li>",n);
			} else if(n != nowPage && word == null) {
				pagebar += String.format("<li><a href='/Meeting/community/allcommunity.do?kind=%s&category=%s&page=%d'>%d</a></li>",kind ,category ,n ,n);
			} else if(n != nowPage && word != null) {
				pagebar += String.format("<li><a href='/Meeting/community/allcommunity.do?column=%s&word=%s&page=%d'>%d</a></li>",column ,word ,n ,n);
			}

			loop++;
			n++;
		}

		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>\r\n"
					+ "<a href=\"#\" onclick='event.preventDefault();' aria-label=\"Next\">\r\n"
					+ "<span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "</a>\r\n"
					+ "</li>");
		} else {
			pagebar += String.format("<li>\r\n"
					+ "<a href='/Meeting/community/allcommunity.do?kind=%s&category=%s&page=%d' aria-label=\"Next\">\r\n"
					+ "<span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "</a>\r\n"
					+ "</li>", kind, category, n);
		}

		pagebar += "</ul></nav>";
		

		//리스트 값 수정!!!
		
		//전체 카테고리 내용
		//날짜 수정
		ArrayList<CommunityDTO> alist = dao.community(kind,map,category,isSearch);

		for(int i=0; i<alist.size(); i++) {
			String cseq = alist.get(i).getCseq();

			String regdate = alist.get(i).getRegdate().substring(0, 10);
			
			alist.get(i).setRegdate(regdate);

			if(isSearch && column.equals("title")) {
				String rword = alist.get(i).getTitle().replace(word, "<b style='color:red;'>" + word + "</b>");
				
				alist.get(i).setTitle(rword);
			}
			
			if(isSearch && column.equals("name")) {
				String rword = alist.get(i).getId().replace(word, "<b style='color:red;'>" + word + "</b>");
				System.out.println(rword);
				alist.get(i).setId(rword);				
			}
		}
		
		//종류
		req.setAttribute("kind", kind);
		//현재 페이지
		req.setAttribute("nowPage", nowPage);
		//총 게시물수
		req.setAttribute("totalCount", totalCount);
		//총 페이지수
		req.setAttribute("totalPage", totalPage);
		//페이지 바 
		req.setAttribute("pagebar", pagebar);
		//카테고리 리스트
		req.setAttribute("clist", clist);
		//페이지 수만큼의 데이트 코스 추천 리스트
		req.setAttribute("alist", alist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/allcommunity.jsp");
		dispatcher.forward(req, resp);
	}
}
