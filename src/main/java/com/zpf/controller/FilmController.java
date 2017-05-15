//package com.zpf.controller;
//
//
//import com.zpf.dto.Actor;
//import com.zpf.service.ActorService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Controller
//public class FilmController {
//
//	@Autowired
//	private FilmService filmService;
//	@Autowired
//	private LoginService loginService;
//	@Autowired
//	private LanguageService languageService;
//	@Autowired
//	private ActorService service;
//
//	Log log = LogFactory.getLog(this.getClass());
//
//	@RequestMapping(value = "toAdd")
//	// 跳转到展示页面
//	public void toAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		req.getRequestDispatcher("/WEB-INF/add.html").forward(req, res);
//	}
//
//	@RequestMapping(value = "toShow")
//	public void toShow(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		req.getRequestDispatcher("/WEB-INF/show.html").forward(req, res);
//	}
//
//	@RequestMapping(value = "add")
//	public void add(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		String title = req.getParameter("title");
//		String description = req.getParameter("description");
//		String language = req.getParameter("language");
//		Boolean flag = false;
//		if (title.equals("") || title.equals(null)) {
//			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
//		} else if (description.equals("") || description.equals(null)) {
//			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
//		} else if (language.equals("") || language.equals(null)) {
//			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
//		} else {
//			Film film = new Film();
//			film.setDescription(description);
//			film.setLanguage_id(languageService.getLanguageId(language));
//			film.setTitle(title);
//			flag = filmService.addFilm(film);
//			if (flag == false) {
//				req.getRequestDispatcher("/WEB-INF/add/addfail.html").forward(req, res);
//			} else {
//				req.getRequestDispatcher("/WEB-INF/add/addtrue.html").forward(req, res);
//			}
//
//		}
//	}
//
//	@RequestMapping(value = "toLogin")
//	public void toLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		String userName = req.getParameter("first_name");
//		String str = null;
//		str = loginService.findCustomerByName(userName);
//
//		if (str != null) {
//			req.getSession().setAttribute("LOGIN_USER", userName);
//			req.getRequestDispatcher("/WEB-INF/show.html").forward(req, res);
//		} else {
//			req.getRequestDispatcher("WEB-INF/faillogin.html").forward(req, res);
//		}
//
//	}
//
//	@RequestMapping(value = "/toDelete")
//	public void toDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		int film_id = Integer.parseInt(req.getParameter("film_id"));
//		boolean flag = false;
//		flag = filmService.deleteByid(film_id);
//		if(flag == true){
//			req.getRequestDispatcher("WEB-INF/show/showt.html").forward(req, res);
//		}else{
//			req.getRequestDispatcher("WEB-INF/showf.html").forward(req, res);
//		}
//
//	}
//
//	@RequestMapping(value = "/toUpdate")
//	public void toUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		String title = req.getParameter("title");
//		String description = req.getParameter("description");
//		String language = req.getParameter("language");
//		int film_id = Integer.parseInt(req.getParameter("film_id"));
//		Film f = new Film();
//		f.setFilm_id(film_id);
//		f.setLanguage_id(languageService.getLanguageId(language));
//		f.setDescription(description);
//		f.setTitle(title);
//		boolean flag = false;
//		flag = filmService.updatef(f);
//		if(flag == true){
//			req.getRequestDispatcher("WEB-INF/edit/editt.html?film_id="+film_id).forward(req, res);
//		}else{
//			req.getRequestDispatcher("WEB-INF/edit/editf.html?film_id="+film_id).forward(req, res);
//		}
//
//	}
//
//	@RequestMapping("/main")
//	public ModelAndView queryActor(HttpServletRequest request){
//        System.out.println(request.getParameter("id"));
//        List<Actor> actor = service.findActorById(new Long(1));
//		ModelAndView modelAndView = new ModelAndView();
//		//相当于request的setAttribute,在jsp页面中通过list取数据
//		modelAndView.addObject("list",actor);
//		//指定视图
//		modelAndView.setViewName("main");
//		return modelAndView;
//	}
//
//	@RequestMapping("/index")
////	public void index(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
////		request.getRequestDispatcher("index").forward(request,response);
////	}
//	public ModelAndView index(HttpServletRequest request){
//		String username = request.getParameter("username");
//		System.out.println(username);
//		ModelAndView modelAndView = new ModelAndView();
//		//相当于request的setAttribute,在jsp页面中通过list取数据
//		modelAndView.addObject("username",username);
//		//指定视图
//		modelAndView.setViewName("index");
//		return modelAndView;
//	}
//
//
//
//	@RequestMapping(value = "/ttt", method = RequestMethod.GET)
//	public String q1(Model model){
//		List<Actor> actors = service.findActorById(new Long(1));
//		model.addAttribute("list",actors);
//		return new String("main");
//	}
//
//    @RequestMapping(value = "/tt", method = RequestMethod.GET)
//    public String q2(Model model){
//        List<Actor> actors = service.findActorById(new Long(1));
//        model.addAttribute("list",actors);
//        return "redirect:ttt";
//    }
//
//    @RequestMapping(value = "/t", method = RequestMethod.GET)
//    public String q3(HttpServletRequest request){
//        return "forward:main";
//    }
//}
