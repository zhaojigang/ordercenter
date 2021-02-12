package common.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author jigang
 */
@Data
public class OrderException extends RuntimeException {
    private Integer code;
    private String message;

    public OrderException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
