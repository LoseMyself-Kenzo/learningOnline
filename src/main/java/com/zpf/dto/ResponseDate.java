package com.zpf.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/11 19:41
 */
public class ResponseDate {

    private Long total;

    private String message;

    private List<?> list;

    public Long getTotal() {
        return total;
    }

    public ResponseDate setTotal(Long total) {
        this.total = total;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseDate setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<?> getList() {
        return list;
    }

    public ResponseDate setList(List<?> list) {
        this.list = list;
        return this;
    }
}
