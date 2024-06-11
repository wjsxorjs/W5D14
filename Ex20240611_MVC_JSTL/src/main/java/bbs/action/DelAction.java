package bbs.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class DelAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
//		현재객체를 호출하는 곳은 적어도 두 군데다.
//		1) view.jsp에서 [수정]버튼을 클릭했을때 : get
//		2) edit.jsp에서 [저장]버튼을 클릭했을때 : post(Multipart)
//		

		String viewPath = null;

		String b_idx = request.getParameter("b_idx");
		String bname = request.getParameter("bname");
		String cPage = request.getParameter("cPage");
		
		
		int chk = BbsDAO.delBbs(b_idx);

		if(chk>0) {
//			viewPath = "/jsp/"+bname+"/del_success.jsp?bname="+bname+"&cPage="+cPage;
			viewPath = "Controller?type=list&bname="+bname+"&cPage="+cPage;
		} else {
			viewPath = "/jsp/"+bname+"/view.jsp?bname="+bname+"&cPage="+cPage;
		}
	
		return viewPath; // 뷰페이지의 경로를 반환한다.
	}

}
