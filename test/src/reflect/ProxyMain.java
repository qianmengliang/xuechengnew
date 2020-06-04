package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象
 * @author zsy
 * @version 1.0
 * @date 2020/5/12 0012 下午 2:18
 */
public class ProxyMain
{
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                if(method.getName().equals("morning")){
                    System.out.println("morning："+args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                invocationHandler
        );
        hello.morning("zsy");
    }
}

interface Hello{
    void morning(String name);
}
