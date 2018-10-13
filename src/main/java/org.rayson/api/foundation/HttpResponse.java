package org.rayson.api.foundation;

import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午3:27
 *  Description:
 **/
@Data
public class HttpResponse {
    private int code ;
    private String message;

    public HttpResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
