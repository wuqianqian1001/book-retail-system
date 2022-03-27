package com.example.bookretailsystem.common;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
public enum ResultCode {
    SUCCESS("200"), //成功
    FAIL("400"),//失败
    NOT_FOUND("404"), //接口不存在
    INTERNAL_SERVER_ERROR("500");//服务器内部错误

    private final String code;

    ResultCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    }
