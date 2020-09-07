package com.example.demo.bo;

import com.example.demo.Coll.DateUtil;

public class BaseVo {


    private String message;

    private String status;

    private Long timestamp;

    private String service;

    private String returnCode;

    private String returnMSG;

    public BaseVo success(String service) {
        this.status = ReturnStatusEnum.SUCCESS.getStatus();
        this.message = ReturnStatusEnum.SUCCESS.getMessage();
        this.returnCode = ReturnCodeRnum.SUCCESS.getStatus();
        this.returnMSG = ReturnCodeRnum.SUCCESS.getMessage();
        this.timestamp = DateUtil.getTime();
        this.service = service;
        return this;
    }

    public BaseVo failed(String service) {
        this.status = ReturnStatusEnum.ERROR.getStatus();
        this.message = ReturnStatusEnum.ERROR.getMessage();
        this.returnCode = ReturnCodeRnum.SERVER_BUSY.getStatus();
        this.returnMSG = ReturnCodeRnum.SERVER_BUSY.getMessage();
        this.timestamp = DateUtil.getTime();
        this.service = service;
        return this;
    }

    public BaseVo failed(String returnCode, String returnMSG, String service) {
        this.status = ReturnStatusEnum.ERROR.getStatus();
        this.message = ReturnStatusEnum.ERROR.getMessage();
        this.returnCode = returnCode;
        this.returnMSG = returnMSG;
        this.timestamp = DateUtil.getTime();
        this.service = service;
        return this;
    }

    public BaseVo refreshTimestamp() {

        this.timestamp = DateUtil.getTime();
        return this;
    }


    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMSG() {
        return returnMSG;
    }

    public void setReturnMSG(String returnMSG) {
        this.returnMSG = returnMSG;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

}
