package encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

/**
 * Hmac加密算法
 * @author zsy
 * @version 1.0
 * @date 2020/5/11 0011 下午 3:34
 */
public class HmacMain {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        //打印随机生成的key
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1,skey).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("helloworld".getBytes("utf-8"));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1,result).toString(16));
    }


}
