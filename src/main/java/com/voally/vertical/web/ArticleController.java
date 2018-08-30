package com.voally.vertical.web;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        ArticleDTO articleDTO = articleService.detail(id);
        model.addAttribute("article",articleDTO);
        return "/article/article-detail";
    }

    @GetMapping(value = "/post")
    public String post(HttpServletRequest request, Model model){
        return "/article/article-post";
    }



}
