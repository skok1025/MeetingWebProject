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
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityCategoryDTO;
import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.DateRecommendDTO;

@WebServlet("/community/daterecommend.do")
public class DateRecommend extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");

		CommunityDAO dao = new CommunityDAO();

		ArrayList<CommunityCategoryDTO> clist = dao.category();

		String word = req.getParameter("word");  //검색어
		String column = req.getParameter("column");  //검색컬럼
		boolean isSearch = false;
		
		
		/*ArrayList<DateRecommendDTO> dlist = dao.daterecommend();*/
		
		HashMap<String, String> map = new HashMap<String, String>();// 임시 dto
		
		
		if (word != null && column != null && word!="" && column!="") {
			isSearch = true;
			map.put("word", word);
			map.put("column", column);
			
			//if (column.equals("음식점")) map.put("column", "음식점");
			//else if (column.equals("산책로")) map.put("column", "산책로");
			//else if (column.equals("카페")) map.put("column", "카페");
			//else if (column.equals("이색데이트")) map.put("column", "이색데이트");
			
			System.out.println(column);
		}
		
		
		// 페이징 관련 변수
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 9; // 한 페이지 출력 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // where rnum between 시작
		int end = 0; // where rnum between 끝
		int n = 0; // 페이지바 제작(페이지네이션)
		int loop = 0;
		int blockSize = 10;

		//page받기
		String page = req.getParameter("page");

		//page가 null이면 1페이지 처음...
		if (page == null || page == "")
			nowPage = 1;
		else
			nowPage = Integer.parseInt(page);

		
		//시작과 끝 페이지 지정
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		//map에 시작과 끝 페이지 넣기
		map.put("begin", begin + "");
		map.put("end", end + "");

		//총 게시물 수
		totalCount = dao.getTotalCount();
		System.out.println("총게시물수 : " + totalCount);
		
		//총 페이지 수
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		System.out.println("총페이지수 : " + totalPage);

		// 페이지바 제작
		String pagebar = "<nav>\r\n" + "  <ul class=\"pagination\">";

		loop = 1; // 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 페이지 바의 페이지 번호 변수

		if (n == 1) {
			pagebar += String.format("<li class='disabled'>\r\n"
					+ "      <a href=\"#\" onclick='event.preventDefault();' aria-label=\"Previous\">\r\n"
					+ "        <span aria-hidden=\"true\">&laquo;</span>\r\n" + "      </a>\r\n" + "    </li>");
		} else {
			pagebar += String.format(
					"<li>\r\n" + "      <a href='/Meeting/community/daterecommend.do?page=%d' aria-label=\"Previous\">\r\n"
							+ "        <span aria-hidden=\"true\">&laquo;</span>\r\n" + "      </a>\r\n" + "    </li>",
					n - 1);
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				pagebar += String.format("<li class='active'><a href='#' onclick='event.preventDefault();'>%d</a></li>",
						n);
			} else {
				pagebar += String.format("<li><a href='/Meeting/community/daterecommend.do?page=%d'>%d</a></li>", n, n);
			}

			loop++;
			n++;
		}

		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>\r\n"
					+ "      <a href=\"#\" onclick='event.preventDefault();' aria-label=\"Next\">\r\n"
					+ "        <span aria-hidden=\"true\">&raquo;</span>\r\n" + "      </a>\r\n" + "    </li>");
		} else {
			pagebar += String.format(
					"<li>\r\n" + "      <a href='/Meeting/community/daterecommend.do?page=%d' aria-label=\"Next\">\r\n"
							+ "        <span aria-hidden=\"true\">&raquo;</span>\r\n" + "      </a>\r\n" + "    </li>",
					n);
		}

		pagebar += "</ul>\r\n" + "</nav>";

		ArrayList<DateRecommendDTO> dclist = dao.list(isSearch,map);
		
		int[] rnum = {1,2,3,4,5,6,7,8,9};
		
		//매니저 아이디 list로 가져오기
		
		boolean iswho = false;
		
		ArrayList<DateRecommendDTO> pclist = dao.getmanager();
		
		for(int i=0; i<pclist.size(); i++) {
			System.out.println(pclist.get(i).getId());
			if(session.getAttribute("id").toString().equals(pclist.get(i).getId())) {
				iswho = true;
				break;
			}
		}
		
		System.out.println(pclist);
		
		req.setAttribute("iswho",iswho); 
		
		
		req.setAttribute("rnum", rnum);
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
		//전체 데이트 코스 추천 리스트
		/*req.setAttribute("dlist", dlist);*/
		//페이지 수만큼의 데이트 코스 추천 리스트
		req.setAttribute("dclist", dclist);
		
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("map", map);
		
		dao.close();
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/daterecommend.jsp");
		dispatcher.forward(req, resp);
	}
}
