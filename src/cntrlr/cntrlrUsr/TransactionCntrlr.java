package cntrlr.cntrlrUsr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Expense;
import model.ExpenseCategory;
import model.ExpenseCategoryDao;
import model.ExpenseDao;
import model.Income;
import model.IncomeCategory;
import model.IncomeCategoryDao;
import model.IncomeDao;
import model.Transaction;
import model.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionCntrlr {
	@RequestMapping("/jsp/user/transaction")
	public ModelAndView trans(HttpServletRequest request,
			HttpServletResponse res, HttpSession session) throws ParseException {
		System.out.println("66666666");
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		IncomeDao dao1 = (IncomeDao) r.getBean("i");
		ExpenseDao dao2 = (ExpenseDao) r.getBean("e");
		IncomeCategoryDao dao3 = (IncomeCategoryDao) r.getBean("icat");
		ExpenseCategoryDao dao4 = (ExpenseCategoryDao) r.getBean("ecat");
		List<Income> l1 = dao1.getIncomesbyUid((Integer) session
				.getAttribute("uId"));
		List<Expense> l2 = dao2.getExpensesbyUid((Integer) session
				.getAttribute("uId"));
		// List<IncomeCategory> l3=dao3.getIncomesCat();
		// List<ExpenseCategory> l4=dao4.getExpenseCat();
		System.out.println("oooooch1");
		ListIterator<Income> i1 = l1.listIterator();
		ListIterator<Expense> i2 = l2.listIterator();
		// ListIterator<IncomeCategory> i3=l3.listIterator();
		// ListIterator<ExpenseCategory> i4=l4.listIterator();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		// SimpleDateFormat df= new SimpleDateFormat("");

		ArrayList<Transaction> l5 = new ArrayList<Transaction>();
		System.out.println(l1.size() + "+" + l2.size());
		int tid = l1.size() + l2.size();

		System.out.println("oooooch1");
		while (i1.hasNext() && i2.hasNext()) {
			Transaction t = new Transaction();
			Income temp1 = i1.next();
			Expense temp2 = i2.next();
			IncomeCategory temp3 = dao3.getIncCatbyId(temp1.getCatid());
			ExpenseCategory temp4 = dao4.getExpCatbyId(temp2.getCatid());
			System.out.println(temp3.getDescrip());
			System.out.println(temp4.getDescrip());
			System.out.println(temp1.getDate());
			if (df.parse(temp1.getDate()).after(df.parse(temp2.getDate()))) {
				System.out.println(df.parse(temp1.getDate()).after(
						df.parse(temp2.getDate())));
				t.setTid(tid);
				System.out.println("ooooossadsadsadch1");
				t.setType(temp1.getClass().getSimpleName());
				t.setIncOrExpId(temp1.getIncmid());
				System.out.println(temp3.getIncsource());
				t.setSrcOrresn(temp3.getIncsource());
				t.setDesc(temp3.getDescrip());
				t.setAmount(temp1.getAmount());
				t.setDate(temp1.getDate());
				l5.add(t);
				i2.previous();
				tid--;

			} else {
				t.setTid(tid);
				t.setType(temp2.getClass().getSimpleName());
				t.setIncOrExpId(temp2.getExpid());

				t.setSrcOrresn(temp4.getReason());
				t.setDesc(temp4.getDescrip());
				t.setAmount(temp2.getAmount());
				t.setDate(temp2.getDate());
				l5.add(t);
				i1.previous();
				System.out.println("oooooch2");
				tid--;
			}
		}
		while (i1.hasNext()) {
			Transaction t = new Transaction();
			Income temp1 = i1.next();
			// Expense temp2= i2.next();
			t.setTid(tid);
			t.setType(temp1.getClass().getSimpleName());
			t.setIncOrExpId(temp1.getIncmid());
			IncomeCategory temp3 = dao3.getIncCatbyId(temp1.getCatid());
			t.setSrcOrresn(temp3.getIncsource());
			t.setDesc(temp3.getDescrip());
			t.setAmount(temp1.getAmount());
			t.setDate(temp1.getDate());
			l5.add(t);
			System.out.println("oooooch3");
			tid--;
		}
		while (i2.hasNext()) { // Income temp1=i1.next();
			Transaction t = new Transaction();
			Expense temp2 = i2.next();
			t.setTid(tid);
			t.setType(temp2.getClass().getSimpleName());
			t.setIncOrExpId(temp2.getExpid());
			ExpenseCategory temp4 = dao4.getExpCatbyId(temp2.getCatid());
			t.setSrcOrresn(temp4.getReason());
			t.setDesc(temp4.getDescrip());
			t.setAmount(temp2.getAmount());
			t.setDate(temp2.getDate());
			l5.add(t);
			System.out.println("oooooch4");
			tid--;
		}
		Iterator<Transaction> ix = l5.iterator();
		while (ix.hasNext()) {
			Transaction tx = ix.next();
			System.out
					.println(tx.getType() + tx.getTid() + "  " + tx.getDate());

		}
		return new ModelAndView("user/transaction", "trans", l5);
	}
}
