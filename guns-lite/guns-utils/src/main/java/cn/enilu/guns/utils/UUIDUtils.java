package cn.enilu.guns.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtils {
    public static String getActivateCodeByUUId() {
        int first = new Random(2).nextInt(100) + 1;
        //System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i ++ ){
            System.out.println(getActivateCodeByUUId());
        }
    }
}
