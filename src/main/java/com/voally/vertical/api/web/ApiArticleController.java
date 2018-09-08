package com.voally.vertical.api.web;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.result.GlobalResult;
import com.voally.vertical.core.result.ResultCode;
import com.voally.vertical.entity.Article;
import com.voally.vertical.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Article相关接口")
@RequestMapping("/api/article")
public class ApiArticleController {

    private final ArticleService articleService;

    @Autowired
    public ApiArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value="getArticleInfo",method = RequestMethod.GET)
    public GlobalResult getArticleInfo(
            @ApiParam(required = true,name = "article_id",value = "文章id") @RequestParam("article_id") Long article_id
    ){
        GlobalResult result = GlobalResult.newInstance();

        if(article_id == null){
            result.error(ResultCode.INVALID_PARAM.getCode(),"文章id不能为空");
            return result;
        }

        Article article = articleService.getArticleDetail(article_id);
        if (article == null) {
            result.error(ResultCode.INVALID_PARAM.getCode(),"文章不存在");
            return result;
        }

        ArticleDTO articleDTO = articleService.detail(article);

        result.success(articleDTO);
        return result;
    }

}
