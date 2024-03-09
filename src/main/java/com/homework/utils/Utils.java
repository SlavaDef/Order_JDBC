package com.homework.utils;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Utils {

    private Utils() {
    }
    public static int getRandomInt(){
        return ThreadLocalRandom.current().nextInt();
    }

    public static String getRandomString(int l){
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";

        StringBuilder s = new StringBuilder(l);

        int i;

        for ( i=0; i<l; i++) {
            s.append(AlphaNumericStr.charAt(ThreadLocalRandom.current().nextInt(AlphaNumericStr.length())));
        }
        return s.toString();
    }

    public static Timestamp getRandomTimestamp(){
        return new Timestamp(
                ThreadLocalRandom.current()
                        .nextLong(new Date(0).getTime(), new Date().getTime())
        );
    }

    public static String getRandomName(){
        List<String> list = Arrays.asList("Boris Jonson", "Junior Second", "Kait Midelton", "Ormando Banuchi");
        return list.get(ThreadLocalRandom.current().nextInt(4));
    }

    public static <T> void printinEntity(List<T> t){
        for (T cl : t) {
            System.out.println(cl);
        }
    }

    public static void main(String[] args) {
        System.out.println(getRandomTimestamp());
        System.out.println(getRandomName());
        System.out.println(getRandomInt());
        System.out.println(getRandomString(10));
    }
}
