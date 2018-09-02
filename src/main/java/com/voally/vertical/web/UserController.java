package com.voally.vertical.web;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.service.UserService;
import com.voally.vertical.util.ArticleUtils;
import com.voally.vertical.util.VerticalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/thinker")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{userName}")
    public String profile(@PathVariable String userName, Model model){
        Thinker thinker = userService.profile(userName);
        List<ArticleDTO> articles = VerticalUtils.getArticlesByThinker(thinker);
        model.addAttribute("thinker",thinker);
        model.addAttribute("articles",articles);
        return "/user/user-profile";
    }

}
