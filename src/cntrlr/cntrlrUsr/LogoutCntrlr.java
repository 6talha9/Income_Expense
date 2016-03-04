package cntrlr.cntrlrUsr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutCntrlr {
	@RequestMapping("/jsp/user/logout")
	public void login(HttpServletRequest request, HttpServletResponse res,
			HttpSession session) throws IOException, ServletException {
		session.invalidate();
		String message = "You LoggedOut, login again";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, res);
		// res.sendRedirect("http://localhost:8080/classpro/jsp/login.jsp");

	}

}
