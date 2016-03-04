package cntrlr;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IncomeDao;
import model.User;
import model.UserDao;

import org.apache.catalina.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mchange.v1.io.OutputStreamUtils;

@Controller
@SessionAttributes("uId")
public class LoginCntrlr {

	@RequestMapping("/jsp/login")
	// @RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) throws IOException {
		String message;
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");

			ApplicationContext r = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			UserDao dao = (UserDao) r.getBean("u");

			User u = (User) dao.getByNamePassword(name, password);
			if (u != null) {

				int userId = u.getUid();

				// session.setAttribute("uId", userId);
				// res.sendRedirect("http://localhost:8080/classpro/jsp/user/home.jsp");

				message = "Welcome " + name;
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("uId", userId);
				modelAndView.addObject("message", message);

				modelAndView.setViewName("user/home");// do this here if problem

				// request.getRequestDispatcher("home.jsp").forward(request,res);
				return modelAndView;
				// return new ModelAndView("home", "message", message);
			} else {
				message = "Sorry, username or password error";

				// res.sendRedirect("http://localhost:8080/classpro/jsp/errorpage.jsp");
				return new ModelAndView("errorpage", "message", message);
			}
		}

		catch (Exception e) {
			message = "Error occured:" + e;
			return new ModelAndView("errorpage", "message", message);
			// res.sendRedirect("http://localhost:8080/classpro/jsp/errorpage.jsp");
		}

	}

}