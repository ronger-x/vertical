package com.voally.vertical.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.core.result.GlobalResult;
import com.voally.vertical.core.result.GlobalResultGenerator;
import com.voally.vertical.core.result.Pagination;
import com.voally.vertical.util.ArticleUtils;
import com.voally.vertical.util.VerticalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VerticalController {

    @GetMapping(value = {"/","/index"})
    public String index(HttpServletRequest request, Model model) throws IOException {
        List<ArticleDTO> list = VerticalUtils.getArticles();
        model.addAttribute("list",list);
        List<Thinker> thinkers = VerticalUtils.getRecommendThinkers();
        model.addAttribute("thinkers",thinkers);
        List<ArticleDTO> articles = VerticalUtils.getRecommendArticles();
        model.addAttribute("articles",articles);

        VerticalUtils.getUserAgent();

        return "index";
    }

    @RequestMapping(value = "/getArticles", method = RequestMethod.GET)
    @ResponseBody
    public GlobalResult getArticles(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size, HttpServletRequest request){
        PageHelper.startPage(page, size);
        List<ArticleDTO> list = VerticalUtils.getArticles();
        PageInfo pageInfo = new PageInfo(list);
        Map result = new HashMap();
        result.put("data",pageInfo.getList());
        Pagination pagination = new Pagination();
        pagination.setPaginationPage(pageInfo.getPageNum());
        pagination.setPaginationSize(pageInfo.getPageSize());
        pagination.setPaginationPageCount(pageInfo.getTotal());
        pagination.setNextPage(pageInfo.getNextPage());
        pagination.setPrePage(pageInfo.getPrePage());
        pagination.setPaginationPageNums(VerticalUtils.getPaginationPageNums(pagination.getPaginationPageCount(),pagination.getPaginationSize()));
        result.put("pagination",pagination);
        return GlobalResultGenerator.genSuccessResult(result);
    }

}
