package cntrlr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationCntrlr {

	@RequestMapping("/jsp/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse res) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String message = "";
		Boolean flag = true;
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		if (name.length() < 3 || password.length() < 6) {
			message = "Username lenght less than 3 Or Password Length less than 6 not allowed<br>";
			flag = false;
		}

		System.out.println("ooooochn1");
		UserDao dao = (UserDao) r.getBean("u");

		User u1 = (User) dao.getByName(name);
		User u2 = (User) dao.getByEmail(email);
		System.out.println("ooooochn1");
		if (u1 != null) {
			message = message + "User Name already exist<br>";
			flag = false;
		}
		if (!password.equals(password2)) {
			message = message + "Passwords Doesn't match<br>";
			flag = false;
		}
		if (u2 != null) {
			message = message
					+ "Seems like u already have an account with the email provided, Please Login<br>";
			flag = false;
		}
		System.out.println(password + "ooooochn1" + password2);

		if (flag == false) {
			return new ModelAndView("register", "message", message);
		} else {
			User u = new User();

			u.setName(name);
			// System.out.println("ooooochn");
			u.setEmail(email);
			u.setPassword(password);
			System.out.println(name + password + email);
			try {
				dao.saveUser(u);
				// System.out.println("ooooochn666666");
				message = "Now you need to login";
				return new ModelAndView("login", "message", message);
			} catch (Exception e) {
				message = "Error occured:" + e;
				return new ModelAndView("errorpage", "message", message);
			}
		}
	}
}
