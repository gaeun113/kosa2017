package com.coderby.myapp.users.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderby.myapp.users.model.UserVO;
import com.coderby.myapp.users.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

//	디버깅 메시지 처리기 Logger (하나하나 출력문 넣지 않도록 해줌)
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//	이제 출력문 대신 logger를 사용하면 됨
	
	
	@Autowired
	IUserService service;
	
//	삽입 GET
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertUser() {
		logger.info("insert");
//		어떤 클래스에 무슨 내용이 실행되는지 알려줌
//		이 모양이 마음에 안든다면 log4j.xml에서 변경가능
		return "user/insertform"; //insertform.jsp
	}
	
//	삽입 POST
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertUser(UserVO user, Model model) {
		System.out.println(user);
		try {
			service.insertUser(user);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "user/error"; //error.jsp
		}
		return "redirect:/"; //list.jsp
	}
	
//	수정 GET
	@RequestMapping(value="/update", method=RequestMethod.GET)
//	public String updateUser(HttpSession session, Model model) {
//		String userId = (String)session.getAttribute("userId");
//		model.addAttribute("user", service.selectUser(userId));
//		return "user/updateform";
//	}
	
//	교수님 수정 GET
	public String updateUser(HttpSession session, Model model) {
  		String userId = (String)session.getAttribute("userId");
  		if(userId == null || userId.equals("")) {
  			model.addAttribute("message", "로그인 사용자가 아닙니다");
  			return "user/loginform";
  		} else {
  			model.addAttribute("user", service.selectUser(userId));
  			return "user/updateform";
 		}
  	}
	
//	수정 POST
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(UserVO user, Model model) {
		try {
			service.updateUser(user);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			System.out.println("수정 실패");
			return "user/error"; //error.jsp
		}
		System.out.println("수정 완료");
		return "redirect:/user/view";
	}
	
	
	
//	삭제 GET
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(HttpSession session, Model model) {
		String userId= (String)session.getAttribute("userId");
		model.addAttribute("user", service.selectUser(userId));
		return "user/deleteform"; //deleteform.jsp
	}
	
//	삭제 POST
	@RequestMapping(value="/delete", method=RequestMethod.POST)
//	public String deleteUser(HttpSession session, String userPassword, Model model) {
//		String userId = (String)session.getAttribute("userId");
//		//model.addAttribute("user", service.selectUser(userId));
//		try {
//			service.deleteUser(userId, userPassword);
//		} catch (Exception e) {
//			model.addAttribute("message", e.getMessage());
//			return "user/error"; //error.jsp
//		}
//		System.out.println("삭제 완료");
//		return "redirect:/";
//	}
	
//	교수님 삭제
	public String delete(String userPassword, HttpSession session, Model model){
		String userId= (String)session.getAttribute("userId");
		model.addAttribute("user", service.selectUser(userId));
		if(userId==null || userId.equals("")){
			model.addAttribute("message","로그인한 사용자가 아닙니다.");
			session.invalidate();
			return "user/loginform"; //로그인한 사용자가 아니면 로그인폼으로 가도록!!
		}else {
			if(service.checkPassword(userId, userPassword)) {
				service.deleteUser(userId, userPassword);
				session.invalidate();
	            return "redirect:/";
			}else {
				model.addAttribute("message", ": 비밀번호가 다릅니다.");
				return "user/deleteform";
			}
		}
	}
	
//	회원 조회
//	@RequestMapping(value="/view", method=RequestMethod.GET)
//	public String getUser(HttpSession session, Model model) {
//		String userId = (String)session.getAttribute("userId");
//		model.addAttribute("user", service.selectUser(userId));
//		return "user/view"; //view.jsp
//	}
	
//	교수님 단일 조회
	@RequestMapping(value="/view", method=RequestMethod.GET)
  	public String getUser(HttpSession session, Model model) {
  		String userId = (String)session.getAttribute("userId");
  		if(userId == null || userId.equals("")) {
  			model.addAttribute("message", "로그인 사용자가 아닙니다");
  			return "user/loginform";
  		} else {
  			model.addAttribute("user", service.selectUser(userId));
  			return "user/view";
 		}
  	}
	
	
//	목록 조회
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getUserList(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		if(service.selectUser(userId).getUserRole().equals("Admin")) {
			System.out.println("관리자로 로그인 했습니다.");
			model.addAttribute("userList", service.selectAllUser());
			return "user/list"; //list.jsp
		} else {
			model.addAttribute("message", "관리자가 아닙니다!");
			return "user/error";
		}
	}
	
//	로그인 GET
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
  		if(userId == null || userId.equals("")) {
  			return "user/loginform";
  		} else {
  			model.addAttribute("message", "이미 로그인한 상태입니다!");
  			return "redirect:/"; //loginform.jsp
  		}
	}
	
//	로그인 POST
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String userId, String userPassword, HttpSession session, Model model) {
		try{
			if(service.checkPassword(userId, userPassword)) {
				session.setMaxInactiveInterval(300); //초 단위로 로그인 session 유지 시간 설정 (시간 초과하면 session 만료 / 저장된 데이터 다 사라짐)
				session.setAttribute("userId", userId);
				System.out.println("로그인 성공");
			} else {
				session.invalidate(); //현재 세션을 무효화 시킴, 로그아웃과 같음
				model.addAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다!");
				System.out.println("로그인 실패");
				return "user/loginform";
			}
			return "redirect:/user/view";
		} catch (Exception e) {
			session.invalidate();
			model.addAttribute("message", e.getMessage());
			return "user/loginform";
		}
	}
	
//	로그아웃 GET
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		if(session.getAttribute("userId") != null) {
			session.invalidate();
			System.out.println("로그아웃 성공");
			return "redirect:/";
		} else {
			System.out.println("로그인 상태가 아닙니다");
			return "redirect:/user/login";
		}
	}
	

	
}
