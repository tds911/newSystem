package com.tds;

import java.util.Random;

public class demo {
    public static void main(String[] args) {
        Random r=new Random();
        String s=" 0 0 # * * ?";


            int num=r.nextInt(12);
            String s1 = s.replaceAll("#", String.valueOf(num));
            System.out.println(s1);







    }
}
