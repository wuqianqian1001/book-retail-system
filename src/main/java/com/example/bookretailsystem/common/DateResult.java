package com.example.bookretailsystem.common;

import java.io.Serializable;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
public class DateResult<T> extends CommonResult implements Serializable {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
