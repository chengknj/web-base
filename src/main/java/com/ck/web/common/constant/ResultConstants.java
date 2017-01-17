package com.ck.web.common.constant;

/**
 * 应用相关常量
 * 
 * @author ChengK
 * @version [1.0]
 */
public final class ResultConstants {

    private ResultConstants() {

    }

    /** 默认本地网标示，仅限数据库使用 **/
    public static final String DEFAULT_LATN_ID = "888";

    /** 默认时间格式 **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /** GBK字符集 **/
    @Deprecated
    public static final String CHARSET_GBK = "GBK";

    /** JSON 应格式 */
    public static final String FORMAT_JSON = "json";

    /** XML 应格式 */
    public static final String FORMAT_XML = "xml";

    /** MD5签名方式 */
    public static final String SIGN_METHOD_MD5 = "md5";

    /**请求来源*/
    public static final String REQ_FROM_SOURCE = "from_source_app";

    /**PC源*/
    public static final String PC_SOURCE = "pc";

    /**手机源*/
    public static final String M_SOURCE = "m";

    /*************************返回编码及页面****************************************/
    /** 通用访问成功时的编码 */
    public static final String SUCCESS_CODE = "0000";

    /** 通用访问失败时的编码 */
    public static final String FAILURE_CODE = "1111";

    /** 404的编码 */
    public static final String ERROR_404_CODE = "404";

    /** 500的编码 */
    public static final String ERROR_500_CODE = "500";

    /** PC端404错误页 */
    public static final String PC_ERROR_404_PAGE = "/common/pcerr_404";

    /** PC端500错误页 */
    public static final String PC_ERROR_500_PAGE = "/common/pcerr_500";

    /** PC端成功页 */
    public static final String PC_SUCCESS_PAGE = "/common/pc_success";

    /** 手机端404错误页 */
    public static final String M_ERROR_404_PAGE = "/common/merr_404";

    /** 手机端500错误页 */
    public static final String M_ERROR_500_PAGE = "/common/merr_500";

    /** 手机端成功页 */
    public static final String M_SUCCESS_PAGE = "/common/m_success";

    /*************************end************************************************/

    /*************************控制层返回的数据结果关键字**************************************/
    /** 结果集code值的名称 */
    public static final String RESULT_CODE_NAME = "code";

    /** 结果集message值的名称 */
    public static final String RESULT_MESSAGE_NAME = "msg";

    /** 结果集data值的名称 */
    public static final String RESULT_DATA_NAME = "data";

    /** 结果集请求参数值的名称 */
    public static final String RESULT_PARAM_NAME = "params";

    /** 结果集errors值的名称 */
    public static final String RESULT_ERRORS_NAME = "errors";

    /** 系统公共异常 */
    public static final String ERROR_SYS_COMMON = "系统异常";

    /** 结果集的名称 */
    public static final String RESULT_NAMES[] = {RESULT_CODE_NAME, RESULT_MESSAGE_NAME, RESULT_DATA_NAME,
        RESULT_ERRORS_NAME};
    //public static final String RESULT_NAMES[] = {RESULT_CODE_NAME, RESULT_MESSAGE_NAME, RESULT_DATA_NAME,
    //    RESULT_ERRORS_NAME,"rowTotal","infoContent"};

    /*******************************************end**************************************/



	// MAP查询
	public static final String QM = "QM";

	// Object查询
	public static final String QO = "QO";

	// LIST查询
	public static final String QL = "QL";

	// 更新
	public static final String UP = "UP";

	// 插入
	public static final String IN = "IN";

	// 删除
	public static final String DE = "DE";

	// 分页查询
	public static final String PQL = "PQL";

	// 删除多个KEY查询
	public static final String BDE = "BDE";

	// 修改多个KEY查询
	public static final String BUP = "BUP";

	//导出
	public static final String EXPORT = "EXPORT";

	//密码修改的周期
	public static final String 	PASSWORDUPDATEDATENO = "90";

	/**
	 * 数据库读操作的数据源名称
	 */
	public static final String READ_DATA_SOURCE_NAME = "readDataSource";

	/**
	 * 数据库写操作的数据源名称
	 */
	public static final String WRITE_DATA_SOURCE_NAME = "writeDataSource";

	/**
	 * 系统国际化名称
	 */
	public static final String SYS_I18N = "SYS_I18N";

	/**
	 * 系统默认语言zh-CN
	 */
	public static final String SYS_DEFAULT_LANGUAGE = "zh-CN";

}
