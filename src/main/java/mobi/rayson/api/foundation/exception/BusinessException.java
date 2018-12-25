package mobi.rayson.api.foundation.exception;

import org.springframework.test.util.ReflectionTestUtils;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 上午11:52
 *  Description:
 **/
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException(String message) {
        this.code = 400;
        this.message = message;
    }
    
    public BusinessException(Object object) {
        this.code = (int) ReflectionTestUtils.invokeGetterMethod(object, "code");
        this.message = (String) ReflectionTestUtils.invokeGetterMethod(object, "message");
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
