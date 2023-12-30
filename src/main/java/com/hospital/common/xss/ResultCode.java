package com.hospital.common.xss;

/**
 * @author psh
 */
public enum ResultCode implements Code {
    /** 成功 */
    SUCCESS(200, "SUCCESS", "成功"),
    /** 異常 */
    ERROR(500, "ERROR", "糟糕！系統發生無法預知的錯誤，請稍後嘗試或聯絡客服人員"),
    /** 未經授權 */
    UNAUTHORIZED(401, "UNAUTHORIZED", "登錄信息已過期，請重新登錄"),
    /** 不存在 */
    NOT_FOUND(404, "NOT_FOUND", "不存在"),
    /** 參數錯誤 */
    PARAM_ERROR(400, "PARAM_ERROR", "參數錯誤"),
    /** 數據已存在 */
    DATA_EXIST(600, "DATA_EXISTS", "數據已存在");

    private Integer code;
    private String name;
    private String message;

    private ResultCode(Integer code, String name, String msg) {
        this.code = code;
        this.name = name;
        this.message = msg;
    }


    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
