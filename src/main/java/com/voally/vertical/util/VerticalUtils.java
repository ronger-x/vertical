package com.voally.vertical.util;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.mapper.UserMapper;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.List;

public class VerticalUtils {

    private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private static ArticleMapper articleMapper = SpringContextHolder.getBean(ArticleMapper.class);

    /**
     * 首页文章
     * */
    public static List<ArticleDTO> getArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(getThinker(articleDTO.getArticleThinkerId()));
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    /**
     * 首页推荐作者
     * */
    public static List<Thinker> getRecommendThinkers() {
        List<Thinker> thinkers = userMapper.getRecommendThinkers();
        return thinkers;
    }

    public static List<ArticleDTO> getArticlesByThinker(Thinker thinker) {
        List<ArticleDTO> articleDTOS = articleMapper.getArticlesByThinkerId(thinker.getId());
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(thinker);
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static String getTimeAgo(Long time){
        try {
            return GlobalFunc.getTimeAgo(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "刚刚";
    }

    public static Thinker getThinker(String id){
        Thinker thinker = new Thinker();
        User user = userMapper.selectByPrimaryKey(id);
        BeanCopierUtil.copy(user, thinker);
        return thinker;
    }

    public static List<ArticleDTO> getRecommendArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getRecommendArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(getThinker(articleDTO.getArticleThinkerId()));
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static Integer[] getPaginationPageNums(Long paginationPageCount, Integer paginationRows) {
        Integer[] integers = null;
        int len = (int) Math.ceil(GlobalFunc.parseFloat(paginationPageCount)/GlobalFunc.parseFloat(paginationRows));
        for (int i=1;i<=len;i++){
            integers = (Integer[]) ArrayUtils.add(integers,i);
        }
        return integers;
    }

    public static void getUserAgent() throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("浏览器基本信息："+request.getHeader("user-agent"));
        System.out.println("客户端系统名称："+System.getProperty("os.name"));
        System.out.println("客户端系统版本："+System.getProperty("os.version"));
        System.out.println("客户端操作系统位数："+System.getProperty("os.arch"));
        System.out.println("HTTP协议版本："+request.getProtocol());
        System.out.println("请求编码格式："+request.getCharacterEncoding());
        System.out.println("Accept："+request.getHeader("Accept"));
        System.out.println("Accept-语言："+request.getHeader("Accept-Language"));
        System.out.println("Accept-编码："+request.getHeader("Accept-Encoding"));
        System.out.println("Connection："+request.getHeader("Connection"));
        System.out.println("Cookie："+request.getHeader("Cookie"));
        System.out.println("客户端发出请求时的完整URL"+request.getRequestURL());
        System.out.println("请求行中的资源名部分"+request.getRequestURI());
        System.out.println("请求行中的参数部分"+request.getRemoteAddr());
        System.out.println("客户机所使用的网络端口号"+request.getRemotePort());
        System.out.println("WEB服务器的IP地址"+request.getLocalAddr());
        System.out.println("WEB服务器的主机名"+request.getLocalName());
        System.out.println("客户机请求方式"+request.getMethod());
        System.out.println("请求的文件的路径"+request.getServerName());
        System.out.println("请求体的数据流"+request.getReader());
        BufferedReader br=request.getReader();
        String res = "";
        while ((res = br.readLine()) != null) {
            System.out.println("request body:" + res);
        }
        System.out.println("请求所使用的协议名称"+request.getProtocol());
        System.out.println("请求中所有参数的名字"+request.getParameterNames());
        Enumeration enumNames= request.getParameterNames();
        while (enumNames.hasMoreElements()) {
            String key = (String) enumNames.nextElement();
            System.out.println("参数名称："+key);
        }
    }
}
