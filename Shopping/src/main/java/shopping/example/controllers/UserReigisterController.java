package shopping.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopping.example.services.UserService;

@Controller
public class UserReigisterController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public ModelAndView getRegisterPage(ModelAndView mav) {
		mav.addObject("error", false);
		mav.setViewName("register.html");
		return mav;
	}
	
	@PostMapping("/register")
	public ModelAndView register(@RequestParam String username,@RequestParam String email,
			@RequestParam String password, ModelAndView mav) {
		if (userService.createAccount(username,email,password)) {
			mav.addObject("error", false);
			mav.setViewName("login.html");
		} else {
			mav.addObject("error", true);
			mav.setViewName("register.html");
		}
		return mav;
	}
}
