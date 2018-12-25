package mobi.rayson.foundation.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-12-23
 *  Time: 9:23 PM
 *  Description: 弱引用和软引用
 **/
public class WeakAndSoftReferenceDemo {
  public static void main(String[] args) {
    String str = new String("abc");
    SoftReference<String> stringSoftReference = new SoftReference<>(str);
    str = null;
    System.gc();
    System.out.println(stringSoftReference.get());
    String abc = new String("123");
    WeakReference<String> weakReference = new WeakReference<>(abc);
    abc = null;
    System.gc();
    System.out.println(weakReference.get());
  }
}
