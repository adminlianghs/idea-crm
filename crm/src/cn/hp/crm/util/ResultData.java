package cn.hp.crm.util;

// 响应工具类  通过java --> json 必须要set get方法
public class ResultData {

    private int code ; // 响应的状态码
    private String msg ; // 响应的备注
    private Object data ; // 响应的数据

    private ResultData(int code , String msg , Object data){
        this.code = code ;
        this.msg = msg;
        this.data = data ;
    }

//    提供一个可以获取当前类对象的方法
//    响应成功内容方法  1.只需要成功的结果  2.成功还要带有一些数据
    public static ResultData success(String msg){
        return new ResultData(Constant.SUCCESS_CODE ,msg , null);
    }

    public static ResultData success(String msg,Object data){
        return new ResultData(Constant.SUCCESS_CODE,msg,data);
    }

    public static ResultData success(int code,String msg,Object data){
        return new ResultData(code,msg,data);
    }

//    响应失败内容
    public static ResultData fail(String msg){
        return new ResultData(Constant.FAIL_CODE,msg , null);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
