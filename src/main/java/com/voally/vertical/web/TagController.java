package com.voally.vertical.web;

import com.voally.vertical.core.result.GlobalResult;
import com.voally.vertical.core.result.GlobalResultGenerator;
import com.voally.vertical.service.TagService;
import com.voally.vertical.util.GlobalFunc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping
    public String index(){
        return "/tag/add";
    }

    @RequestMapping("/add/{tagTitle}")
    public GlobalResult add(@PathVariable String tagTitle){
        Map result = tagService.add(tagTitle);
        if("false".equals(result.get("success"))){
            return GlobalResultGenerator.genErrorResult(GlobalFunc.toString(result.get("message")));
        }
        return GlobalResultGenerator.genSuccessResult();
    }

}
