package com.voally.vertical.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.voally.vertical.core.result.GlobalResult;
import com.voally.vertical.core.result.GlobalResultGenerator;
import com.voally.vertical.core.result.Pagination;
import com.voally.vertical.service.VerticalAdminService;
import com.voally.vertical.util.VerticalUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class VerticalAdminController {

    @Resource
    private VerticalAdminService verticalAdminService;

    @GetMapping
    public String admin(HttpServletRequest request, Model model){
        return "/admin/index";
    }

    @GetMapping("/users")
    public String users(HttpServletRequest request, Model model){
        return "/admin/users";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public GlobalResult getUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size, HttpServletRequest request){
        PageHelper.startPage(page, size);
        List<Map> users = verticalAdminService.getUsers(request);
        PageInfo pageInfo = new PageInfo(users);
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

    @GetMapping("/tags")
    public String tags(HttpServletRequest request, Model model){
        return "/admin/tags";
    }

    @RequestMapping("/getTags")
    @ResponseBody
    public GlobalResult getTags(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size, HttpServletRequest request){
        PageHelper.startPage(page, size);
        List<Map> tags = verticalAdminService.getTags(request);
        PageInfo pageInfo = new PageInfo(tags);
        Map result = new HashMap();
        System.out.println(pageInfo.getList());
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
