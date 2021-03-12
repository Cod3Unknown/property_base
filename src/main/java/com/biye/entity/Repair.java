package com.biye.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @描述:
 */
@Data
public class Repair {

    private int id;

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
