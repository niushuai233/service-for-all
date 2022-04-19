package cc.niushuai.projects.serviceforall.common.exception;

import cc.niushuai.projects.serviceforall.common.base.enums.ErrorCodeEnum;
import cc.niushuai.projects.serviceforall.common.base.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * 全局异常处理器
 *
 * @author niushuai
 * @date 2022/4/1 10:38
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义业务异常处理
     *
     * @param businessException 自定义抛出异常对象
     * @author niushuai
     * @date: 2022/4/1 11:11
     * @return: {@link Result <Object>} 接口返回内容
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result<Object> businessExceptionHandler(BusinessException businessException) {
        log.error(businessException.getMessage(), businessException);
        return Result.error(businessException);
    }

    /**
     * 请求方式不匹配异常处理
     *
     * @param exception
     * @author niushuai
     * @date: 2022/4/1 11:19
     * @return: {@link Result<?>}
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage(), exception);
        return Result.error(ErrorCodeEnum.HttpMethodNotAllowed);
    }

    /**
     * sql异常处理器
     *
     * @param sqlException
     * @author niushuai
     * @date: 2022/4/13 9:35
     * @return: {@link Result<?>}
     */
    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public Result<?> sqlExceptionHandler(SQLException exception) {
        log.error(exception.getMessage(), exception);
        return Result.error(ErrorCodeEnum.SQL_EXCEPTION, exception.getMessage());
    }

    /**
     * 请求参数
     *
     * @param exception
     * @author niushuai
     * @date: 2022/4/13 9:35
     * @return: {@link Result<?>}
     */
    @ResponseBody
    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    public Result<?> missingServletRequestParameterException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Result.error(ErrorCodeEnum.RequestParameterError, exception.getMessage());
    }

    /**
     * 兜底的异常处理器
     *
     * @param exception
     * @author niushuai
     * @date: 2022/4/1 11:18
     * @return: {@link Result<?>}
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Result.error("操作失败，请联系实施人员");
    }

    @PostConstruct
    public void init() {
        log.info("Init Global Exception Handler Success.");
    }
}
