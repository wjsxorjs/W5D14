package bbs.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mybatis.dao.BbsDAO;

public class CommAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		String cPage = request.getParameter("cPage");
		String bname = request.getParameter("bname");
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String writer = request.getParameter("writer");
		String comm = request.getParameter("comm");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		String b_idx = request.getParameter("b_idx");
		
		String viewPath = null;
		
		int chk = BbsDAO.addComm(writer, comm, pwd, ip, b_idx);
		
		if(chk >0) {
			viewPath = "Controller?type=view&b_idx="+b_idx+"&bname="+bname+"&cPage="+cPage;
		}
		return viewPath;
	}

}
