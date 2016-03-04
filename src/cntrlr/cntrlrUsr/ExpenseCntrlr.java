package cntrlr.cntrlrUsr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Expense;
import model.ExpenseDao;
import model.Income;
import model.IncomeDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExpenseCntrlr {
	@RequestMapping("jsp/user/expense")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {
		String amount = request.getParameter("amount");
		String catid = request.getParameter("catid");
		String date = request.getParameter("date");
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		System.out.println("ooooochn1");
		ExpenseDao dao = (ExpenseDao) r.getBean("e");
		String message;
		Expense i = new Expense();
		// Date d= new Date();

		try {
			i.setAmount(Integer.parseInt(amount));
		} catch (Exception e) {
			// TODO: handle exception
			message = "Error occured: Invalid Amount";
			return new ModelAndView("errorpage", "message", message);
		}
		i.setCatid(Integer.parseInt(catid));
		// i.setUid(Integer.parseInt(uid));
		i.setDate(date);
		i.setUid((Integer) session.getAttribute("uId"));

		try {
			dao.saveExpense(i);
			// System.out.println("ooooochn666666");
			message = "Saved Successfully";
			return new ModelAndView("saved", "message", message);
		} catch (Exception e) {
			message = "Error occured:" + e;
			return new ModelAndView("errorpage", "message", message);
		}
	}

}
