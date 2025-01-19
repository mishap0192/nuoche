package com.action;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.weixin.WeiXinMoveCarService;

/*
 * 
		mobilephone	15873305757
		voiceid	59193250
		report_time	2018-04-11 16:44:07
		code	2
		talktime	2
		msg	发送成功
 */
@Controller
@RequestMapping("/sms.do")
public class SmtAction {
	@Autowired 
	private WeiXinMoveCarService service;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping
	@ResponseBody
	public String execute()
	{
		//通知的手机号码
		String mobilephone = request.getParameter("mobilephone");
		
		//返回编码  =2成功
		String code = request.getParameter("code");
		
		//消息
		String msg = request.getParameter("msg");
		
		//语音号码
		String voiceid = request.getParameter("voiceid");
		System.out.println(mobilephone);
		System.out.println(code);
		if ("2".equals(code.trim())) {
			System.out.println("update-xiugaiStatus");
			service.xiugaiStauts(mobilephone);
		}
		System.out.println(msg);
		System.out.println(voiceid);
		return "success";
	}

}
