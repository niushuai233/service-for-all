package cc.niushuai.projects.serviceforall.common.base.vo;

import cc.niushuai.projects.serviceforall.common.base.enums.ErrorCodeEnum;
import cc.niushuai.projects.serviceforall.common.constant.HttpCodeConstant;
import cc.niushuai.projects.serviceforall.common.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回数据格式
 *
 * @author zhsoft
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    private Integer code = HttpCodeConstant.CODE_200;

    /**
     * 返回数据对象 data
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public static Result<Object> ok() {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpCodeConstant.CODE_200);
        r.setMessage("success");
        return r;
    }

    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpCodeConstant.CODE_200);
        r.setMessage(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(HttpCodeConstant.CODE_200);
        r.setResult(data);
        return r;
    }

    public static Result<Object> error(String msg) {
        return error(HttpCodeConstant.CODE_500, msg);
    }

    public static Result<Object> error(ErrorCodeEnum errorCodeEnum) {
        return error(errorCodeEnum, "");
    }

    public static Result<Object> error(ErrorCodeEnum errorCodeEnum, String extraMessage) {
        return error(errorCodeEnum.getCode(), errorCodeEnum.getMessage() + ": " + extraMessage);
    }

    public static Result<Object> error(BusinessException businessException) {
        return error(businessException.getCode(), businessException.getMessage());
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    /**
     * 无权限访问返回结果
     */
    public static Result<Object> noAuth(String msg) {
        return error(HttpCodeConstant.CODE_401, msg);
    }

    /**
     * Token失效返回结果
     */
    public static Result<Object> tokenExpire(String msg) {
        return error(HttpCodeConstant.INTERNAL_CODE_40001, msg);
    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = HttpCodeConstant.CODE_200;
        this.success = true;
        return this;
    }

}