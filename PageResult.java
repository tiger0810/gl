package com.gl.longrange.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private  int Page;//总页数
    private  int limit; //每页的大小
    private  long count; //总数据量
    private  String code;//状态码
    private  String msg; //描述信息
    private List<T> data;//返回数据
    private T example; //任何条件类型

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "Page=" + Page +
                ", limit=" + limit +
                ", count=" + count +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", example=" + example +
                '}';
    }
}
