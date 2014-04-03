package com.sym.demo;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sym.DAO.UserDao;
import com.sym.model.Loginf;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request,HttpSession session) {
		Locale locale = null;
		logger.info("Welcome home! The client locale is {}.", locale);
		String usr=request.getParameter("userid");
		String pwd=request.getParameter("pswrd");
		session.setAttribute("username",usr);
		ApplicationContext context = new ClassPathXmlApplicationContext("mod.xml");
		UserDao usrdao=(UserDao)context.getBean("usrdao");
		Loginf lginf=usrdao.logidpwd(usr, pwd);
		if(lginf!=null)
		{
			return "UserHome";
		}
		else{
			model.addAttribute("result", "Invalid Credentials.Contact your Administrator.");
			
		}
		return "login";
		
		
		
	}
	
	
}
