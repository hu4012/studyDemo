package com.geekbang.javatech;

import java.lang.reflect.Field;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/27
 * @time 23:15
 */

public class MainDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Lesson3 lesson3 = new Lesson3();
        Field field = lesson3.getClass().getDeclaredField("info");
        field.setAccessible(true);
        field.set(lesson3, 789);
        System.out.println(field.get(lesson3));
        System.out.println(lesson3.info);
    }
}
