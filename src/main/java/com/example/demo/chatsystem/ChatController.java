package com.example.demo.chatsystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("/chatsystem")
	public String chatsystem(Model model){
	model.addAttribute("message","一覧ページ");
	return "index";
	}
	
	@RequestMapping("/view")
	public String view(Model model){
	model.addAttribute("title","チャットルーム");
	return "view";
	}
	
	@RequestMapping("/complete")
	public String complete(){
	return "view";
}
}
