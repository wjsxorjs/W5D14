package bbs.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청시 전달되어오는 파라미터 받기(fname)
		String fname = request.getParameter("fname");
		
		// 위 파일은 서버의 .../upload라는 폴더에 있다.
		// 서버입장에서는 클라이언트에게 파일을 보내야 하기 때문에 우선
		// 절대경로화 시켜야 한다.
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/upload/"+fname);
		
		// 얻어진 절대경로로 File 객체 생성!
		File f = new File(realPath);
		
		if(f.exists()) {
			// 존재하므로 파일을 읽어서 바로 다운로드 시키면 된다.
			byte[] buf = new byte[4096];
			int size = -1;
			
			// 서버 입장에서는 실제 존재하는 파일의 내용을 읽기(InputStream)하여
			// 요청한 사용자에게 응답으로 보내야(OutputStream)한다.
			// 읽고 쓰기할 수 있는 스트림들을 준비하자!
			
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			
			// 요청한 곳으로 파일의 내용을 보내주기 위해 필요한 스트림
			ServletOutputStream sos = null; // 접속자에게 응답으로 다운로드를 시켜야한다.
											// 이때, response로 얻을 수 있는 스트림이
											// ServletOutputStream이기에 선언한다.
			BufferedOutputStream bos = null;
			
			try {
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition",
						"attachment;filename="+new String(fname.getBytes(),"8859_1"));
				fis = new FileInputStream(f);
				bis = new BufferedInputStream(fis);
				
				sos = response.getOutputStream();
				bos = new BufferedOutputStream(sos);
				
				// 스트림을 통해 읽기한 후 바로 쓰기를 하여
				// 요청한 곳으로 자원을 보낸다.
				while((size = bis.read(buf)) != -1){
					bos.write(buf,0,size);
					bos.flush();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(fis!=null) {
						fis.close();
					}
					if(bis!=null) {
						bis.close();
					}
					if(sos!=null) {
						sos.close();
					}
					if(bos!=null) {
						bos.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		return null;
	}

}
