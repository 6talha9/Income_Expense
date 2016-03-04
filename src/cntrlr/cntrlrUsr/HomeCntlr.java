package cntrlr.cntrlrUsr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ExpenseCategory;
import model.ExpenseCategoryDao;
import model.IncomeCategory;
import model.IncomeCategoryDao;
import model.IncomeDao;
import model.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeCntlr {
	@RequestMapping("/jsp/user/incomelnk")
	public ModelAndView link1(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IncomeCategoryDao incatdao = (IncomeCategoryDao) r.getBean("icat");
		List<IncomeCategory> lst = (List<IncomeCategory>) incatdao
				.getIncmCatsbyUid((Integer) session.getAttribute("uId"));
		// Model model;

		ListIterator<IncomeCategory> i = lst.listIterator();
		ArrayList<String> source = new ArrayList<String>();
		while (i.hasNext()) {
			IncomeCategory ic = i.next();
			source.add(String.valueOf(ic.getInccatid()));
			source.add(ic.getIncsource());

		}
		// Iterator<String> ii= source.iterator();

		return new ModelAndView("user/income", "source", source);

	}

	// @RequestMapping("/incomelnk")
	@RequestMapping("/jsp/user/expenselnk")
	public ModelAndView link2(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ExpenseCategoryDao expensecatdao = (ExpenseCategoryDao) r
				.getBean("ecat");
		List<ExpenseCategory> lst = (List<ExpenseCategory>) expensecatdao
				.getExpCatsbyUid((Integer) session.getAttribute("uId"));
		// Model model;

		ListIterator<ExpenseCategory> i = lst.listIterator();
		ArrayList<String> reason = new ArrayList<String>();
		while (i.hasNext()) {
			ExpenseCategory ec = i.next();
			reason.add(String.valueOf(ec.getExpcatid()));
			reason.add(ec.getReason());

		}
		// Iterator<String> ii= source.iterator();

		return new ModelAndView("user/expense", "reason", reason);

	}

	@RequestMapping("/jsp/user/incomecategorylnk")
	public ModelAndView link4(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {

		return new ModelAndView("user/incomecategory");
	}

	@RequestMapping("/jsp/user/expensecategorylnk")
	public ModelAndView link5(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) {

		return new ModelAndView("user/expensecategory");
	}

}