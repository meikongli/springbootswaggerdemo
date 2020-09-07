package com.example.demo.bo;

public enum ReturnCodeRnum {

    /**
     *  1000 接口调用成功  　   常用编码
     1001    查询数据为空  　   　
     1002    接口不存在   　   　
     1003    数据已经存在  重复插入某数据 　
     1004    服务器繁忙   一般为接口程序执行报错 　
     1005    必填请求参数缺失

     1101    用户名或密码错误    登录用户名不存在    登录相关（1100-1109）
     1102    用户名或密码错误    密码错误    　
     1103    用户被锁定   通过某种方式可以解锁  　
     1104    用户不可用   未知原因导致不可用   　
     1110    工单已被签收  　   工单类提示（1110-1119）
     1111    该环节已完成  流程已经到达其他环节  　
     1112    已退回到上一环节    　   　

     9999    缓存已失效，请重新登录 缓存已失效，请重新登录 缓存已失效，请重新登录
     9998    非法请求
     9997    绑定  注册后进行用户绑定
     9996    默认密码修改  业务用户第一次登录系统需修改默认密码
     9995    当前工单已被XXX签收 同一条待办工单只能被同一人签收
     9994    权限认证失败  用户登录系统时未通过isc权限认证
     */

    SUCCESS("1000", "接口调用成功"),
    QUERY_DATA_IS_NULL("1001", "查询数据为空"),
    INTERFACE_NOT_EXIST("1002", "接口不存在"),
    RECORD_ALREADY_EXIST("1003", "数据已经存在"),
    SERVER_BUSY("1004", "服务器繁忙"),
    REQUEST_PARAM_ERROR("1005", "必填请求参数缺失");

    private String status;

    private String message;

    private ReturnCodeRnum(String status, String message) {

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
