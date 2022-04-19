package cc.niushuai.projects.serviceforall.common.exception;

import cc.niushuai.projects.serviceforall.common.constant.HttpCodeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 自定义异常对象
 *
 * @author niushuai
 * @date 2022/4/1 10:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException(String message) {
        this.code = HttpCodeConstant.CODE_500;
        this.message = message;
    }
}
