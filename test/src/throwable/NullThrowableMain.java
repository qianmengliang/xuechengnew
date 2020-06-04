package throwable;

import java.sql.SQLOutput;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/13 0013 下午 3:51
 */
public class NullThrowableMain
{
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.address.city.toString());
    }
}

class Person {
    String[] name = new String[2];
    Address address = new Address();
}

class Address {
    String city;
    String street;
    String zipcode;
}
