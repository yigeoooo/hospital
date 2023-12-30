package com.hospital.common.utils;

import com.hospital.common.xss.Code;
import com.hospital.common.xss.ResultCode;

/**
 * @author psh
 * @since date 2023/12/30
 */
public class ResultInfo<T> {

    private int code;

    private T body = null;


    public ResultInfo() {
        this.code = ResultCode.SUCCESS.getCode();
    }

    private ResultInfo(int code, T body) {
        this.code = code;
        this.body = body;
    }

    public static <T> ResultInfo<T> build(T body) {
        return new ResultInfo(ResultCode.SUCCESS.getCode(), body);
    }

    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode().equals(this.code);
    }

    public static <T> T ofNullable(ResultInfo<T> result) {
        return result != null && result.isSuccess() ? result.getBody() : null;
    }

    public static <T> T ofNullable(ResultInfo<T> result, T value) {
        return result != null && result.isSuccess() ? result.getBody() : value;
    }

    public T getBody() {
        return this.body;
    }

    public ResultInfo<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public int getResultCode() {
        return code;
    }

    public void setResultCode(int resultCode) {
        this.code = resultCode;
    }


}
