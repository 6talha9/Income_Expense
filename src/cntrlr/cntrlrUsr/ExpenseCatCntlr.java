package cntrlr.cntrlrUsr;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ExpenseCategory;
import model.ExpenseCategoryDao;
import model.IncomeCategory;
import model.IncomeCategoryDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExpenseCatCntlr {
	@RequestMapping("/jsp/user/expensecat")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {

		String reason = request.getParameter("reason");
		String desc = request.getParameter("desc");
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ExpenseCategoryDao dao = (ExpenseCategoryDao) r.getBean("ecat");
		String message;
		ExpenseCategory ic = new ExpenseCategory();
		ic.setReason(reason);
		ic.setDescrip(desc);
		ic.setUid((Integer) session.getAttribute("uId"));
		try {
			dao.saveExpenseCat(ic);
			System.out.println("ooooochn666666");
			message = "Saved Successfully";
			return new ModelAndView("saved", "message", message);
		} catch (Exception e) {
			message = "Error occured:" + e;
			return new ModelAndView("errorpage", "message", message);
		}
	}
}
