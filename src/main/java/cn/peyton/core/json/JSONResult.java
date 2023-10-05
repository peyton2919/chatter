package cn.peyton.core.json;

import cn.peyton.core.enums.HttpStatusCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>自定义响应数据数据结构,保证序列化json时，如果是null对象，key也会消失</h3>
 *
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date: 2021/10/31 23:36
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public final  class JSONResult<T> implements Serializable {
    /**
     * <pre>
     *     自定义的状态码
     *  状态码: 200 成功, 700 失败 , 800 异常
     * </pre>
     */
    private Integer code;
    /**  消息 */
    private String msg;
    /** 成功时要返回的数据 */
    private T data;
    /** 扩展数据 */
    private Object expand;
    /** 异常错误码 (定制扩展异常码) */
    private Integer errorCode;
    /**  response 带的状态码  */
    private Integer httpStatusCode = -1;


    // ====================================== external method begin ====================================== //

    /**
     * <h4>成功</h4>
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success() {
        return new JSONResult<T>(HttpStatusCode.SUCCESS.getCode(),
                null,null,null,null,null);
    }

    /**
     * <h4>成功</h4>
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(String msg) {
        return new JSONResult<T>(HttpStatusCode.SUCCESS.getCode(),
                null, msg,null,null,null);
    }

    /**
     * <h4>成功</h4>
     * @param data 成功时要返回的数据
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(T data) {
        return new JSONResult<T>(HttpStatusCode.SUCCESS.getCode(),
                data,null,null,null,null);
    }

    /**
     * <h4>成功</h4>
     *
     * @param msg  消息
     * @param data 成功时要返回的数据
     * @param <T>  申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> success(String msg, T data) {
        return new JSONResult<T>(HttpStatusCode.SUCCESS.getCode(),data,
                msg,null,null,null);
    }

    /**
     * <h4>成功{带回扩展数据}</h4>
     * @param expand 扩展数据
     * @param msg    消息
     * @return JSONResult对象
     */
    public static JSONResult success(Object expand, String msg) {
        return new JSONResult(HttpStatusCode.SUCCESS.getCode(),
                null, msg,null,expand,null);
    }

    /**
     * <h4>错误</h4>
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(String msg) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                null, msg,null,null,null);
    }

    /**
     * <h4>错误</h4>
     * @param httpStatusCode 状态码枚举,规定好给的提示
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(HttpStatusCode httpStatusCode) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                null, httpStatusCode.getMsg(),httpStatusCode.getCode(),null,null);
    }


    /**
     * <h4>错误</h4>
     * <pre>
     *     默认 code: HttpStatusCode.FAIL.getCode
     *          errorCode: HttpStatusCode.FAIL_PARAM.getCode()
     * </pre>
     * @param data  消息
     * @return JSONResult对象
     */
    public static <T> JSONResult fail(T data) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                data,null,HttpStatusCode.FAIL.getCode(),null,null);
    }

    /**
     * <h4>错误</h4>
     * @param httpStatusCode 状态码枚举,规定好给的提示
     * @param expand 扩展数据
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(HttpStatusCode httpStatusCode,Object expand) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                null, httpStatusCode.getMsg(),httpStatusCode.getCode(),expand,null);
    }

    /**
     * <h4>错误</h4>
     * @param errorCode 失败时,规定好给的提示
     * @param msg  消息
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(Integer errorCode, String msg) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                null,msg,errorCode,null,null);
    }

    /**
     * <h4>错误</h4>
     * @param errorCode 失败时,规定好给的提示
     * @param expand 扩展对象
     * @param msg    消息
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> fail(Integer errorCode, Object expand, String msg) {
        return new JSONResult<T>(HttpStatusCode.FAIL.getCode(),
                null,msg,errorCode, expand, null);
    }

    /**
     * <h4>错误</h4>
     * @param code 状态码
     * @param msg 消息
     * @param errorCode 自定义状态码
     * @param expand    扩展自定对象
     * @param httpStatusCode response 状态码
     * @return JSONResult对象
     * @param <T> T 对象
     */
    public static <T> JSONResult<T> fail(Integer code, String msg, Integer errorCode, Object expand, Integer httpStatusCode) {
        return new JSONResult<T>(code, null, msg, errorCode, expand, httpStatusCode);
    }

    /**
     * <h4>异常</h4>
     * @param errorCode 异常时,规定好给的提示
     * @param msg    消息
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(Integer errorCode,String msg) {
        return new JSONResult<T>(HttpStatusCode.ERROR.getCode(),
                null, msg, errorCode, null, null);
    }

    /**
     * <h4>异常</h4>
     * @param httpStatusCode 状态码枚举,规定好给的提示
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(HttpStatusCode httpStatusCode) {
        return new JSONResult<T>(HttpStatusCode.ERROR.getCode(),
                null, httpStatusCode.getMsg(), httpStatusCode.getCode(), null, null);
    }

    /**
     * <h4>异常</h4>
     * @param errorCode 异常时,规定好给的提示
     * @param msg    消息
     * @param expand 扩展对象
     * @param <T> 申明泛型数据类型
     * @return JSONResult对象
     */
    public static <T> JSONResult<T> error(Integer errorCode,String msg,Object expand) {
        return new JSONResult<T>(HttpStatusCode.ERROR.getCode(),
                null, msg, errorCode, expand, null);
    }


    // ====================================== external method end ====================================== //

    // ====================================== Get and Set begin ====================================== //

    /**
     * @return 自定义状态码: 200 成功, 700 失败 , 800 异常
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return 消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return 成功时要返回的数据
     */
    public T getData() {
        return data;
    }

    /**
     * @param code 自定义 状态码: 200 成功, 700 失败 , 800 异常
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @param msg 消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @param data 成功时要返回的数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return 扩展数据
     */
    public Object getExpand() {
        return expand;
    }

    /**
     * @param expand 扩展数据
     */
    public void setExpand(Object expand) {
        this.expand = expand;
    }

    /**
     * @return 异常错误码
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode 异常错误码
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return response 带的状态码
     */
    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * @param httpStatusCode response 带的状态码
     */
    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    // ====================================== Get and Set end ====================================== //

    // ====================================== private constructor begin ====================================== //
    /** 构造函数 */
    public JSONResult() { }

    /** 构造函数 */
    private JSONResult(Integer code,T data,String msg,
                       Integer errorCode,Object expand,Integer httpStatusCode){
        this.code = code;
        if(null != data){ this.data = data;}
        if(null != msg){  this.msg = msg;}
        if(null != errorCode){ this.errorCode = errorCode;}
        if(null != expand) {this.expand = expand;}
        if(null != httpStatusCode){this.httpStatusCode = httpStatusCode;}
    }
    /**
     * <h4>判断是否成功</h4>
     * @return 成功true
     */
    @JsonIgnore //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.code == HttpStatusCode.SUCCESS.getCode();
    }

    /**
     * <h4>数据封装到Map</h4>
     * @return Map<String, Object>对象
     */
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        result.put("expand", expand);
        result.put("errorCode", errorCode);
        result.put("httpStatusCode", httpStatusCode);
        return result;
    }

    // ====================================== private constructor end ====================================== //
}
