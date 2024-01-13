package com.hospital.model.register.pojo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 查封装询数据数据dto
 * @author psh
 * @since date 2024/1/13
 */
@Data
public class RegisterInfoDto {

    private String id;

    private String doctorName;

    private String patientId;

    private String patientName;

    private String patientGender;

    private String idCard;

    private String phoneNumber;

    private String date;

    private String advice;

    private List<RegisterInfoListDto> list = new ArrayList<>();

}
