package com.ck.web.controller.base;

import com.ck.web.common.constant.ResultConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;


/**
 * Spring的基础控制器
 * 
 * @author ChengK
 */
@Slf4j
public abstract class AbstractController {

	/**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param view
     *            视图
     * @param result
     *            结果
     * @param params
     *            请求参数
     * @param message
     *            描述
     * @param errors
     *            错误
     */
    protected ModelAndView processResult(String code, String view, Object result, Object params, String message,
                                         Object errors) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, code);
        modelAndView.addObject(ResultConstants.RESULT_DATA_NAME, result);
        modelAndView.addObject(ResultConstants.RESULT_PARAM_NAME, params);
        modelAndView.addObject(ResultConstants.RESULT_MESSAGE_NAME, message);
        modelAndView.addObject(ResultConstants.RESULT_ERRORS_NAME, errors);
        return modelAndView;
    }
    
    /**
     * 处理返回结果
     * 
     * @param view
     *            视图
     * @param result
     *            结果
     */
    protected ModelAndView processSuccess(String view, Object result) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelAndView.addObject(ResultConstants.RESULT_DATA_NAME, result);
        return modelAndView;
    }

    /**
     * 处理重定向返回结果
     * 
     * @param view 视图(需要带上.html后缀)
     */
    protected ModelAndView processRedirect(String view) {
    	return new ModelAndView("redirect:" + view);
    }

    /**
     * 处理返回结果
     * 
     * @param view
     *            视图
     * @param result
     *            结果
     */
    protected ModelAndView processSuccess(String view, Object result, Object params) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelAndView.addObject(ResultConstants.RESULT_DATA_NAME, result);
        modelAndView.addObject(ResultConstants.RESULT_PARAM_NAME, params);
        return modelAndView;
    }
    
    /**
     * 处理返回结果
     * 
     * @param view
     *            视图
     * @param message
     *            描述
     */
    protected ModelAndView processFailure(String view, String message) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, ResultConstants.FAILURE_CODE);
        modelAndView.addObject(ResultConstants.RESULT_MESSAGE_NAME, message);
        return modelAndView;
    }
    
    /**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param view
     *            视图
     * @param message
     *            描述
     */
    protected ModelAndView processFailure(String code, String view, String message) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, code);
        modelAndView.addObject(ResultConstants.RESULT_MESSAGE_NAME, message);
        return modelAndView;
    }
    
    /**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param view
     *            视图
     * @param params
     *            请求参数
     * @param message
     *            描述
     * @param errors
     *            错误
     */
    protected ModelAndView processFailure(String code, String view, Object params, String message, Object errors) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, code);
        modelAndView.addObject(ResultConstants.RESULT_PARAM_NAME, params);
        modelAndView.addObject(ResultConstants.RESULT_MESSAGE_NAME, message);
        modelAndView.addObject(ResultConstants.RESULT_ERRORS_NAME, errors);
        return modelAndView;
    }    
    /**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param result
     *            结果
     * @param params
     *            请求参数
     * @param message
     *            描述
     * @param errors
     *            错误
     */
    protected ModelMap processResultJSON(String code, Object result, Object params, String message,
                                         Object errors) {
    	ModelMap modelMap = new ModelMap();
    	modelMap.put(ResultConstants.RESULT_CODE_NAME, code);
    	modelMap.put(ResultConstants.RESULT_DATA_NAME, result);
    	modelMap.put(ResultConstants.RESULT_PARAM_NAME, params);
    	modelMap.put(ResultConstants.RESULT_MESSAGE_NAME, message);
    	modelMap.put(ResultConstants.RESULT_ERRORS_NAME, errors);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     * 
     * @param result
     *            结果
     */
    protected ModelMap processSuccessJSON(Object result) {
    	ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelMap.put(ResultConstants.RESULT_DATA_NAME, result);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     * 注：针对公司tydic.js的列表框架
     * @param result
     *            结果
     */
    @Deprecated
    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected ModelMap processSuccessJSONByTydic(Map result) {
    	ModelMap modelMap = new ModelMap();
    	modelMap.putAll(result);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     *
     * @param result
     *            结果
     */
    protected ModelMap processSuccessJSON(Object result, Object params) {
    	ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelMap.put(ResultConstants.RESULT_DATA_NAME, result);
        modelMap.put(ResultConstants.RESULT_PARAM_NAME, params);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     * 
     * @param message
     *            描述
     */
    protected ModelMap processFailureJSON(String message) {
    	ModelMap modelMap = new ModelMap();
    	modelMap.put(ResultConstants.RESULT_CODE_NAME, ResultConstants.FAILURE_CODE);
    	modelMap.put(ResultConstants.RESULT_MESSAGE_NAME, message);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param message
     *            描述
     */
    protected ModelMap processFailureJSON(String code, String message) {
    	ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, code);
        modelMap.put(ResultConstants.RESULT_MESSAGE_NAME, message);
        return modelMap;
    }
    
    /**
     * 处理返回结果
     * 
     * @param code
     *            状态码
     * @param params
     *            请求参数
     * @param message
     *            描述
     * @param errors
     *            错误
     */
    protected ModelMap processFailureJSON(String code, Object params, String message, Object errors) {
    	ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, code);
        modelMap.put(ResultConstants.RESULT_PARAM_NAME, params);
        modelMap.put(ResultConstants.RESULT_MESSAGE_NAME, message);
        modelMap.put(ResultConstants.RESULT_ERRORS_NAME, errors);
        return modelMap;
    }

    
    /**
     * 获取请求来源
     * @param request
     * @return
     */
    protected String source(HttpServletRequest request) {
        return (String)request.getAttribute(ResultConstants.REQ_FROM_SOURCE);
    }
    
    /**
     * 处理Spring中的标准异常, DefaultHandlerExceptionResolver
     */
    @ExceptionHandler
    public ModelAndView handleException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                        Exception ex)
        throws IOException {
        
        String code = ResultConstants.FAILURE_CODE;
        String view = ResultConstants.PC_ERROR_500_PAGE;
        String message = "系统错误";
        String errors = "";
        
        if (ex instanceof NoSuchRequestHandlingMethodException) {
            code = "404";
            message = "NoSuchRequestHandlingMethodException";
        }
        else if (ex instanceof HttpRequestMethodNotSupportedException) {
            code = "405";
            message = "HttpRequestMethodNotSupportedException";
        }
        else if (ex instanceof HttpMediaTypeNotSupportedException) {
            code = "415";
            message = "HttpMediaTypeNotSupportedException";
        }
        else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            code = "406";
            message = "HttpMediaTypeNotAcceptableException";
        }
        else if (ex instanceof MissingServletRequestParameterException) {
            code = "400";
            message = "MissingServletRequestParameterException";
        }
        else if (ex instanceof ServletRequestBindingException) {
            code = "400";
            message = "ServletRequestBindingException";
        }
        else if (ex instanceof ConversionNotSupportedException) {
            code = "500";
            message = "ConversionNotSupportedException";
        }
        else if (ex instanceof TypeMismatchException) {
            code = "400";
            message = "TypeMismatchException";
        }
        else if (ex instanceof HttpMessageNotReadableException) {
            code = "400";
            message = "HttpMessageNotReadableException";
        }
        else if (ex instanceof HttpMessageNotWritableException) {
            code = "500";
            message = "HttpMessageNotWritableException";
        }
        else if (ex instanceof MethodArgumentNotValidException) {
            code = "400";
            message = "MethodArgumentNotValidException";
        }
        else if (ex instanceof MissingServletRequestPartException) {
            code = "400";
            message = "MissingServletRequestPartException";
        }
        else if (ex instanceof BindException) {
            code = "400";
            message = "BindException";
            message = " bind exception";
        }
        else if (ex != null) {
            message = ex.getMessage();
        }
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        errors = sw.toString();
        log.error(errors);
        
        String source = source(request);
        if (ResultConstants.PC_SOURCE.equals(source)) {
            view = ResultConstants.PC_ERROR_500_PAGE;
        }
        else if (ResultConstants.M_SOURCE.equals(source)) {
            view = ResultConstants.M_ERROR_500_PAGE;
        }
        return processFailure(code, view, "", message, errors);
    }

}
