package com.biye.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ServiceResult
 * @Description: TODO
 * @Author: jacky.ning
 * @Date: 2020/8/18 11:02
 * @Version: v1.0
 */
public class ServiceResult<T> {

    private PageInfo<T> pageInfo;

    public ServiceResult(){
    }

    public ServiceResult(PageInfo<T> pageInfo){
        this.pageInfo = pageInfo;
    }

    public Map<String,Object> result(){
        Map<String,Object> data = new HashMap<>();
        data.put("total",pageInfo.getTotal());
        //总页数
        data.put("pages",pageInfo.getPages());
        //当前页
        data.put("page_num",pageInfo.getPageNum());
        //页大小
        data.put("page_size",pageInfo.getPageSize());
        //开始行
        data.put("start_row",pageInfo.getStartRow());
        //结束行
        data.put("end_row",pageInfo.getEndRow());
        //列表数据
        data.put("result",pageInfo.getList());
        return data;
    }
}
