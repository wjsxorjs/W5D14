package bbs.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 페이징 처리를 위한 객체생성
		Paging page = new Paging(5, 3);
		String bname = request.getParameter("bname");
		String cPage = request.getParameter("cPage");
		
		// 전체페이지 수를 구하기
		page.setTotalRecord(BbsDAO.getCount(bname));
		
		if(cPage != null) {
//			int nowPage = Integer.parseInt(cPage);
//			page.setNowPage(nowPage);
			page.setNowPage(Integer.parseInt(cPage));
			// 이때 게시물을 추출할 때 begin과 end가 구해지고
			// 시작페이지(startPage)와 끝페이지(endPage)도 구해졌다.
		} else {
			page.setNowPage(1);
		}
		
		
		BbsVO[] b_ar = BbsDAO.getList(bname,page.getBegin(),page.getEnd());
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로 저장
		request.setAttribute("bbs", b_ar);
		request.setAttribute("page", page);
		
		return "/jsp/"+bname+"/list.jsp"; // 뷰페이지의 경로를 반환한다.
	}

}
