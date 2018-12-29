package com.cobra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WeChatController
{
    @RequestMapping("/index")
    public String intoIndex(HttpServletRequest request,HttpServletResponse response)
    {

        return "wechat/index";

    }
}