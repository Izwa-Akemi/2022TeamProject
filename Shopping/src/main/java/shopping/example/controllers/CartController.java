package shopping.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpSession;

public class CartController {
	@Autowired
	HttpSession session;
	
}
