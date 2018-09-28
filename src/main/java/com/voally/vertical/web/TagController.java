package com.voally.vertical.web;

import com.voally.vertical.core.result.GlobalResult;
import com.voally.vertical.core.result.GlobalResultGenerator;
import com.voally.vertical.entity.Tag;
import com.voally.vertical.service.TagService;
import com.voally.vertical.util.GlobalFunc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ResponseBody
    public GlobalResult add(Tag tag){
        Map result = tagService.add(tag);
        if("false".equals(result.get("success"))){
            return GlobalResultGenerator.genErrorResult(GlobalFunc.toString(result.get("message")));
        }
        return GlobalResultGenerator.genSuccessResult(result);
    }

    @RequestMapping("/detail")
    public GlobalResult detail(@RequestParam Long id){
        return GlobalResultGenerator.genSuccessResult();
    }

}
