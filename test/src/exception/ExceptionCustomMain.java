package exception;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/13 0013 下午 3:17
 */
public class ExceptionCustomMain {
    public static void main(String[] args) {
        String login = login("zsy","222");
        System.out.println(login);
    }

    static String login(String name,String password){
        if("zsy".equals(name)){
            if("123".equals(password)){
                return "成功";
            }else{
                throw new BaseException("密码错误");
            }
        }else{
            throw new BaseException("用户名错误");
        }
    }
}
