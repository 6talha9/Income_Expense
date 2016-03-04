package cntrlr.cntrlrUsr;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Income;
import model.IncomeDao;
import model.User;
import model.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.SessionAttributesHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IncomeCntrlr {
	@RequestMapping("/jsp/user/income")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {
		String amount = request.getParameter("amount");
		String catid = request.getParameter("catid");
		String date = request.getParameter("date");
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		System.out.println("ooooochn1");
		IncomeDao dao = (IncomeDao) r.getBean("i");
		String message;
		Income i = new Income();
		// Date d= new Date();
		System.out.println("ooooochn1.1");
		try {
			i.setAmount(Integer.parseInt(amount));
		} catch (Exception e) {
			// TODO: handle exception
			message = "Error occured: Invalid Amount";
			return new ModelAndView("errorpage", "message", message);
		}

		System.out.println("ooooochn1.1");
		i.setCatid(Integer.parseInt(catid));
		System.out.println("ooooochn1.1");
		System.out.println(session.getAttribute("uId"));
		i.setUid((Integer) session.getAttribute("uId"));

		i.setDate(date);

		System.out.println("ooooochn2");
		try {
			dao.saveIncome(i);
			System.out.println("ooooochn3");
			message = "Saved Successfully";
			return new ModelAndView("saved", "message", message);
		} catch (Exception e) {
			message = "Error occured:" + e;
			return new ModelAndView("errorpage", "message", message);
		}
	}

}
