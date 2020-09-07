package com.example.demo.bo;

import com.example.demo.Coll.DateUtil;

public class ResponseVo<T> extends  BaseVo{

    private String message;

    private T returnVoList;

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

    /**
     * 构建返回VO
     */
    private ResponseVo<T> generateVo(ReturnStatusEnum returnStatusEnum, String returnCode, String returnMSG,
                                     String service, String result) {

        super.setStatus(returnStatusEnum.getStatus());
        this.message = returnStatusEnum.getMessage();
        super.setReturnCode(returnCode);
        super.setReturnMSG(returnMSG);
        super.setTimestamp(DateUtil.getTime());
        super.setService(service);
        return this;
    }

    private ResponseVo<T> generateVo(ReturnStatusEnum returnStatusEnum, ReturnCodeRnum returnCodeEnum, String service,
                                     String result) {

        return generateVo(returnStatusEnum, returnCodeEnum.getStatus(), returnCodeEnum.getMessage(), service, result);
    }

    public ResponseVo<T> success() {

        return generateVo(ReturnStatusEnum.SUCCESS, ReturnCodeRnum.SUCCESS, "", "1");
    }

    public ResponseVo<T> success(String service) {

        return generateVo(ReturnStatusEnum.SUCCESS, ReturnCodeRnum.SUCCESS, service, "1");
    }

    public ResponseVo<T> failed(String service) {

        return generateVo(ReturnStatusEnum.ERROR, ReturnCodeRnum.SERVER_BUSY, service, "0");
    }

    public ResponseVo<T> failed(String returnCode, String returnMSG, String service) {

        return generateVo(ReturnStatusEnum.ERROR, returnCode, returnMSG, service, "0");
    }

    public ResponseVo<T> paramFailed(String service) {

        return generateVo(ReturnStatusEnum.REQUEST_PARAM_ERROR, ReturnCodeRnum.REQUEST_PARAM_ERROR, service, "0");
    }

    public ResponseVo<T> refreshTimestamp() {

        super.setTimestamp(DateUtil.getTime());
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getReturnVoList() {
        return returnVoList;
    }

    public ResponseVo<T> setReturnVoList(T returnVoList) {
        this.returnVoList = returnVoList;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public ResponseVo<T> setPageVo(PageVo pageVo) {

        this.pageIndex = pageVo.getPageIndex();
        this.pageSize = pageVo.getPageSize();
        this.totalPage = pageVo.getTotalCount();
        this.totalCount = pageVo.getTotalCount();
        return this;
    }

}
