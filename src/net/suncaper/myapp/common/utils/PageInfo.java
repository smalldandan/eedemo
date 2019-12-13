package net.suncaper.myapp.common.utils;

import java.util.List;

public class PageInfo<T> {
    //页码
    private int pageNo;
//    页面大小
    private int pageSize;
    //总页数
    private int pageCount;
    //记录总数
    private int count;
    //是否首页
    private boolean first;
    // 是否尾页
    private boolean last;
    private int next;
    private int pre;
    //核心数据
    private List<T> data;


    public PageInfo(int pageNo, int pageSize, int count, List<T> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.data = data;
        this.pageCount = count/pageSize+ (count%pageSize==0?0:1);

    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getCount() {
        return count;
    }

    public boolean isFirst() {
        return pageNo==1;
    }

    public boolean isLast() {
        return pageNo==pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public int getNext() {
        return  this.isLast()?pageNo:pageNo+1;
    }

    public int getPre() {
        return this.isFirst()?pageNo:pageNo-1;
    }
}
