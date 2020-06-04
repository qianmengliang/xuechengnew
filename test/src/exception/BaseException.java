package exception;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/13 0013 下午 3:20
 */
public class BaseException extends RuntimeException {
    public BaseException(String message){
        super(message);
    }

    public BaseException(String message,Throwable casue){
        super(message,casue);
    }

    public BaseException(Throwable casue){
        super(casue);
    }
}
