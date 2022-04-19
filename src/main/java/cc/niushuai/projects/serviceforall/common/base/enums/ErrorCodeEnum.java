package cc.niushuai.projects.serviceforall.common.base.enums;

/**
 * 错误码
 *
 * @author niushuai
 * @date 2022/4/13 9:28
 */
public enum ErrorCodeEnum {

    /**
     * 请求方式不匹配
     */
    HttpMethodNotAllowed(405, "请求方式不匹配"),

    /**
     * 请求参数错误
     */
    RequestParameterError(1301, "请求参数错误"),

    /**
     * 数据库操作失败
     */
    SQL_EXCEPTION(1300, "数据库操作失败"),
    ;


    private Integer code;
    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
