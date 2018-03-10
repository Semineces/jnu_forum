package com.xzp.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xzp.forum.dao.MessageDao;
import com.xzp.forum.model.User;
import com.xzp.forum.util.HostHolder;


@Controller
public class RankController {
	
	@Autowired
	private HostHolder hostHolder;
	
	@Autowired
	private MessageDao messageDao;
	
	@RequestMapping(path="/rank",method=RequestMethod.GET)
	public String rankPoint(Model model) {
		User user=hostHolder.getUser();
		model.addAttribute("localHost", user.getUsername());
		model.addAttribute("newMessage", messageDao.countMessageByToId(user.getId()));
		return "rank";
	}
}