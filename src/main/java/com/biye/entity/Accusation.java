package com.biye.entity;

import lombok.Data;

/**
 * @author: jd_wang
 * @date 2021-03-11 15:02
 * @描述:
 */
@Data
public class Accusation {

    private int accuId;

    private int userId;

    private String userRemark;

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String insertTime;

    private int adminId;

    private String startTime;

    private String endTime;

    private String adminRemark;

    private int status;


}
