package com.example.demo.bo;

public enum ReturnStatusEnum {

    /**
     * 200 服务器成功返回用户请求的数据。
     * 302 用户未登录
        * 400 用户发出的请求有错误，服务器没有进行新建或修改数据的操作。
        * 401 表示用户没有权限（令牌、用户名、密码错误）。
        * 404 用户发出的请求针对的是不存在的记录，服务器没有进行操作。
        * 406 用户请求的格式不正确
        * 422 当创建一个对象时，发生一个验证错误。
        * 500 服务器发生错误，用户将无法判断发出的请求是否成功。
     */
    SUCCESS("200", "成功"),
    REQUEST_PARAM_ERROR("400", "参数错误"),
    REQUEST_ERROR_USERID_IS_NULL("400", "用户id为空"),
    RECORD_NOT_FOUND("404", "记录不存在"),
    RECORD_ALREADY_EXIST("422", "记录已经存在"),
    ERROR("500", "服务异常");

    private String status;

    private String message;

    private ReturnStatusEnum(String status, String message) {

        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
