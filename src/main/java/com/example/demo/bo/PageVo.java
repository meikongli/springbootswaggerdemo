package com.example.demo.bo;

public class PageVo {

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 每页显示条数
     */
    private Integer pageSize = 10;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 当前页
     */
    private Integer pageIndex = 1;

    public PageVo(Integer pageIndex, Integer pageSize) {

        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPageSize() {

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {

        this.pageSize = pageSize;

        if (null != this.pageSize) {

            this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        }

    }

    public Integer getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {

        this.totalCount = totalCount;
        if (null != this.pageSize) {

            this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        }
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return "CommonPage [totalPage=" + totalPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
                + ", pageIndex=" + pageIndex + "]";
    }
}
