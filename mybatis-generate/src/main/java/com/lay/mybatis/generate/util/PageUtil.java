package com.lay.mybatis.generate.util;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:38 2019/1/4
 * @Modified By:IntelliJ IDEA
 */
public class PageUtil {

    /** 当前页码 */
    public int pageNum = 0;
    /** 每页多少条 */
    public int pageSize = 0;
    /** 总共多少条 */
    public int total = 0;

    public int totalPage;

    public int pageStart;

    public long getTotalPage() {
        calcTotalPage();
        return totalPage;
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageStart()
    {
        return pageSize * (pageNum - 1);
    }

    private void calcTotalPage(){
        if(total==0){
            this.totalPage= 1;
        }
        else if(total%this.pageSize==0){
            this.totalPage = total/this.pageSize;
        }else{
            this.totalPage = total/this.pageSize+1;
        }
    }

}
