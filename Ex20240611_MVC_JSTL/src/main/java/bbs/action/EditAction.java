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

public class EditAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
//		현재객체를 호출하는 곳은 적어도 두 군데다.
//		1) view.jsp에서 [수정]버튼을 클릭했을때 : get
//		2) edit.jsp에서 [저장]버튼을 클릭했을때 : post(Multipart)
//		

		String viewPath = null;

		String enc_type = request.getContentType();

		String source = request.getParameter("source");
		
		
		if(enc_type.startsWith("application") && source.equals("view")) {
			String b_idx = request.getParameter("b_idx");
			String bname = request.getParameter("bname");
			
			
			BbsVO bvo = BbsDAO.getView(b_idx);
			request.setAttribute("bvo", bvo);

			viewPath = "/jsp/"+bname+"/edit.jsp";
		} else if(enc_type.startsWith("multipart") && source == null) {
			// DB에서 Update하기
			ServletContext application = request.getServletContext();
			
			String realPath = application.getRealPath("/upload");
			
			try {
				// 첨부파일 저장
				MultipartRequest mr = new MultipartRequest(request, realPath,5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
				// 첨부파일이 있다면 이때 이미 저장된 상태다.
				
				// 나머지 파라미터들(제목, 내용, 작성자) 등을 받아야한다.
				
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				
				String b_idx = mr.getParameter("b_idx");
				String bname = mr.getParameter("bname");
				String cPage = mr.getParameter("cPage");
				// 첨부파일은 이미 서버에 저장된 상태이지만
				// 새로 업로드된 파일명을 DB에 수정해야한다.
				
				File f = mr.getFile("file");
				
				String fname = null;
				String oname = null;
				
				if(f != null) {
					fname = f.getName();
					oname = mr.getOriginalFileName("file");
				}
				
				String ip =request.getRemoteAddr();
				
				BbsDAO.edit(b_idx, title, content, fname, oname, ip);
				
				viewPath = "Controller?type=view&cPage="+cPage+"&bname="+bname+"&b_idx="+b_idx;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return viewPath; // 뷰페이지의 경로를 반환한다.
	}

}
