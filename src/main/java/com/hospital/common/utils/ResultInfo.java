package com.hospital.common.utils;

import com.hospital.common.xss.ResultCode;
import lombok.Data;
import lombok.Getter;

/**
 * @author psh
 * @since date 2023/12/30
 */
@Data
public class ResultInfo<T> {

    private int code;

    @Getter
    private T body = null;

    private String message;


    public ResultInfo() {
        this.code = ResultCode.SUCCESS.getCode();
    }


    private ResultInfo(int code, T body) {
        this.code = code;
        this.body = body;
    }

    public  ResultInfo(int code, T body, String message) {
        this.body = body;
        this.message = message;
        this.code = code;
    }


    public static <T> ResultInfo<T> build(T body) {
        return new ResultInfo(ResultCode.SUCCESS.getCode(), body);
    }

    public static <T> ResultInfo<T> build(T body, String message) {
        return new ResultInfo(ResultCode.ERROR.getCode(), body, message);
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


}
