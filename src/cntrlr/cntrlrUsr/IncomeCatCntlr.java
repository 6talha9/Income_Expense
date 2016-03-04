package cntrlr.cntrlrUsr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IncomeCategory;
import model.IncomeCategoryDao;
import model.User;
import model.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IncomeCatCntlr {
	@RequestMapping("/jsp/user/incomecat")  
    public ModelAndView login(HttpServletRequest request,HttpServletResponse res, HttpSession session) {  
		  String source=request.getParameter("source");  
	       String desc=request.getParameter("desc"); 
	       ApplicationContext	 r=new ClassPathXmlApplicationContext("applicationContext.xml");  
		      

	       IncomeCategoryDao dao=(IncomeCategoryDao)r.getBean("icat");  
	       	         String message; 
	       	      IncomeCategory ic=new IncomeCategory();  
	       	   ic.setIncsource(source);
	       	   ic.setDescrip(desc);
	       	   ic.setUid((Integer)session.getAttribute("uId"));
	       	try{
	 	       dao.saveIncomeCat(ic);
	 	       System.out.println("ooooochn666666");
	 	       message="Saved Successfully";
	 	       return new ModelAndView("saved", "message", message);  
	 	       }
	 	       catch(Exception e)
	 	       {
	 	        	 message="Error occured:"+e;
			return new ModelAndView("errorpage", "message",message);  
	 	       } 
	}
	}
