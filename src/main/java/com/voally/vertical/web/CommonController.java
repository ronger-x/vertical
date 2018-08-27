package com.voally.vertical.web;


import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommonController {

    @GetMapping(value = {"/","/index"})
    public String index(HttpServletRequest request, Model model){
        List<ArticleDTO> list = Utils.getArticles();
        model.addAttribute("list",list);
        return "index";
    }

}
