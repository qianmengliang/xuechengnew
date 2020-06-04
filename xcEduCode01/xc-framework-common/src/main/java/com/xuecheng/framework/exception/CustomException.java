package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @ClassName : CustomException  //类名
 * @Description : 自定义异常类  //描述
 * @Author : qianml  //作者
 * @Date: 2020-01-18 18:11  //时间
 * @Version: 1.0
 */
public class CustomException extends RuntimeException {
     private ResultCode resultCode;
    public CustomException(ResultCode resultCode) {
       //异常信息为错误代码+异常信息
       super("错误代码："+resultCode.code()+"错误信息："+resultCode.message());
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
