package com.example.demo.chatsystem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("/chatsystem")
	public String chatsystem(Model model) {
		model.addAttribute("message", "一覧ページ");
		return "index";
	}

	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("title", "チャットルーム");
		return "view";
	}

	private final Chatdao chatdao;

	public ChatController(Chatdao chatdao) {
		this.chatdao = chatdao;
	}

	@RequestMapping("/complete")
	public String complete(Chatform chatform, Model model) {
		ChatentForm chatentform = new ChatentForm();
		chatentform.setName(chatform.getName());
		chatentform.setComment(chatform.getComment());

		chatdao.insertDb(chatentform);

		List<ChatentForm> list = chatdao.searchDb();
		model.addAttribute("dbList", list);

		model.addAttribute("title", "チャットルーム");
		return "view";
	}

}
