package com.entity;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 下午1:32 2018/12/12
 * @ Version    ：1.0
 */
public class TestEncoder {

    public static void main(String[] args) {


        String s="11111";
        String s1="111111";
        /*boolean equals = s.equals(s1)==false;*/
        if(s.equals(s1)==false){

            System.out.println("2222");
        }

        /*String s1=null;
        Base64 base64 = new Base64();
        String text = "字符串";
        byte[] bytes = text.getBytes();
        String s = base64.encodeToString(bytes);
        System.out.println(s);
        try {
            s1 = new String(base64.decode(s), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s1);*/
        /*String s=null;
        BASE64Encoder base64Encoder = new BASE64Encoder();//编码
        BASE64Decoder base64Decoder = new BASE64Decoder();//解码
        String text = "字符串";
        byte[] bytes = text.getBytes();
        System.out.println(bytes);
        String encode = base64Encoder.encode(bytes);
        System.out.println(encode);
        //解码
        try {
            s = new String(base64Decoder.decodeBuffer(encode), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);*/
    }
}
