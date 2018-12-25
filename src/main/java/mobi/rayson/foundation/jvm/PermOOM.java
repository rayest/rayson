package mobi.rayson.foundation.jvm;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-11-02
 *  Time: 6:01 PM
 *  Description:
 **/

public class PermOOM {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1==s2); // false
        System.out.println(s1==s2.intern()); // false
        System.out.println("hello"==s2.intern()); // true
    }
}