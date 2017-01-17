package com.ck.web.controller.base;

import com.ck.web.common.util.StringEscapeEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * 公共请求action
 * @author tianshuo
 * @date 2016/3/11
 */
@Controller
@RequestMapping("/base")
public class BaseController extends AbstractController {
    //通用内容后续增加


    /**
     * 获取请求参数()
     *
     * @param request
     * @return
     */
    protected Map<String,String> getParameters(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements(); ) {
            String key = enu.nextElement().toString();
            String val = request.getParameter(key);
            map.put(key, val);
        }
        return map;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

}
