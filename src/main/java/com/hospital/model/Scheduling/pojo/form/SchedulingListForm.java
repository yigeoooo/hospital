package com.hospital.model.Scheduling.pojo.form;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 接收list
 * @author psh
 * @since date 2024/1/7
 */
@Data
public class SchedulingListForm {

    private List<SchedulingForm> item = new ArrayList<>();

}
