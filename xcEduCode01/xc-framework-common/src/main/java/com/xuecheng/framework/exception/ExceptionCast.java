package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @ClassName : ExceptionCast  //类名
 * @Description : 异常抛出类  //描述
 * @Author : qianml  //作者
 * @Date: 2020-01-18 18:18  //时间
 * @Version: 1.0
 */
public class ExceptionCast {
    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
