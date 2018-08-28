package com.voally.vertical.web;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/${id}")
    public ArticleDTO detail(@PathVariable Long id){
        ArticleDTO articleDTO = articleService.detail(id);
        return articleDTO;
    }

}
