package com.hospital.model.medicine.pojo.form;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


/**
 * 修改接惨对象
 * @author psh
 * @since date 2024/1/6
 */
@Data
public class MedicineInfoUpdateForm {


    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 药品名称
     */
    private String medicineName;
    /**
     * 药品别名
     */
    private String alias;
    /**
     * 用药部位
     */
    private String medicinalPart;
    /**
     * 产地
     */
    private String producer;
    /**
     * 药性
     */
    private String properties;
    /**
     * 功效
     */
    private String functions;
    /**
     * 禁忌
     */
    private String taboos;
    /**
     * 临床应用
     */
    private String application;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

}
