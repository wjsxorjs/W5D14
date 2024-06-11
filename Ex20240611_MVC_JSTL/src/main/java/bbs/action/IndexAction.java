package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		return "jsp/index.jsp";
	}

}
