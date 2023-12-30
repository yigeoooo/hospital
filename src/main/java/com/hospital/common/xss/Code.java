package com.hospital.common.xss;

/**
 * @author psh
 */
public interface Code {
    Integer COMM_BASE = 0;

    /**
     * getCode
     * @return Integer
     */
    Integer getCode();

    /**
     * getName
     * @return String
     */
    String getName();

    /**
     * getMessage
     * @return String
     */
    String getMessage();

    /**
     * 返回编码
     * @param code
     * @param name
     * @param message
     * @return Code
     */
    static Code newInstance(final Integer code, final String name, final String message) {
        return new Code() {
            @Override
            public Integer getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }

            @Override
            public String getName() {
                return name;
            }
        };
    }
}
