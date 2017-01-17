package com.ck.web.common.views;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * 约定格式的JSON处理
 * 
 * @author tianshuo
 * @version [1.0]
 */
public class JsonView extends FastJsonJsonView {
    
    /**
     * model数据如下
     * code: 结果编码, data:结果数据, params: 请求参数, msg:结果消息,  errors:出错时的名细
     */
    /** {@inheritDoc} */
    protected Object filterModel(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>(model.size());
        for (String item : ResultConstants.RESULT_NAMES) {
            result.put(item, model.get(item));
        }
        return result;
    }
}
