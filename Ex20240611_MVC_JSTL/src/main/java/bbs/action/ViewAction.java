package bbs.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ViewAction implements Action {

	List<BbsVO> r_list;
	
	public boolean checkBbs(BbsVO vo) {
		boolean value = true;
		
		for(BbsVO bvo: r_list) {
			if(bvo.getB_idx().equals(vo.getB_idx())) {
				value = false;
			}
		}
		
		
		return value;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("read_list");
		if(obj == null) {
			r_list = new ArrayList<>();
			// 생성된 리스트를 세션에 저장
			session.setAttribute("read_list", r_list);
		} else {
			r_list = (ArrayList<BbsVO>) obj;
		}

		String bname = request.getParameter("bname");
		String b_idx = request.getParameter("b_idx");
		String viewPath = null;

		BbsVO bvo = BbsDAO.getView(b_idx);
		
		if(bvo != null) {
			if(checkBbs(bvo)) {
				BbsDAO.hitInc(b_idx); // 조회수 증가
				r_list.add(bvo);	// 다음에 읽기를 수행할 때
									// 조회수를 증가시키지않도록
									// r_list에 추가시켜준다.
			}
			request.setAttribute("bvo", bvo);
			viewPath = "/jsp/"+bname+"/view.jsp";
		}
		
		
		return viewPath; // 뷰페이지의 경로를 반환한다.
	}

}
