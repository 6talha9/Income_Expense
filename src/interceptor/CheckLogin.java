package interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CheckLogin implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Pre-handle");

		try {

			// RequestDispatcher rd = req.getRequestDispatcher(arg0);
			HttpSession session = request.getSession();
			Object id = session.getAttribute("uId");
			System.out.println("111");
			if (id == null) {
				String message = "You LoggedOut, login again";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request,
						response);

				// response.sendRedirect("http://localhost:8080/classpro/jsp/login.jsp");
				System.out.println("222");
				return false;

			}

		} catch (Exception e) {
			String message = "You LoggedOut, login again";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);

			// System.out.println("333");
			// response.sendRedirect("http://localhost:8080/classpro/jsp/login.jsp");
			System.out.println("222");

		}
		System.out.println("444");

		return true;
	}

	// override postHandle() and afterCompletion()

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After completion handle");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Post-handle");

	}
}

/*
 * @ControllerAdvice("cntrlr.cntrlrUser") public class CheckLogin { //
 * @Pointcut("execution(* cntrlr.cntrlrUser..*(..))") // public void k(){}
 * 
 * @Before("execution(* cntrlr.cntrlrUser..*(..))") public void
 * myadvice(JoinPoint jp) throws IOException//it is advice { String message;
 * System.out.println("000");
 */
/*
 * try{ ServletRequestAttributes attr= (ServletRequestAttributes)
 * RequestContextHolder.currentRequestAttributes();
 * 
 * HttpServletRequest req= attr.getRequest(); //RequestDispatcher rd =
 * req.getRequestDispatcher(arg0); HttpSession session= req.getSession(); int
 * id= (Integer)session.getAttribute("uId") ; System.out.println("111");
 * if(id==0){ //res.sendRedirect("login.jsp"); System.out.println("222");
 * message = "You need to login"; return new ModelAndView("login",
 * "message",message);
 * 
 * }
 * 
 * }catch (Exception e) { System.out.println("333"); message =
 * "You need to login"; return new ModelAndView("login", "message",message); }
 * System.out.println("444"); return null;
 * //System.out.println("Method Signature: " + jp.getSignature());
 */
// }
// }
