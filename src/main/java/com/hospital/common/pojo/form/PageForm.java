package com.hospital.common.pojo.form;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2023/12/30
 */
@Data
public class PageForm {

    /**
     * 页码
     */
    private int page;
    /**
     *每页长度
     */
    private int size;

}
