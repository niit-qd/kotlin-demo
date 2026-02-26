package com.demo.kotlin.language_guide.basic_syntax;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationsJavaDemo {

    public static class MyClass {
        private String id;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void testExample() {
        Example example = new Example("foo", "bar", "quux", "female");
        example.getGender();
        example.setGender("xxxx");
        try {
            Field[] fields = example.getClass().getDeclaredFields();
            System.out.println(Arrays.asList(fields));
            Annotation annotationFoo = example.getClass().getDeclaredField("foo").getAnnotation(Ann.class);
            System.out.println("annotation foo = " + annotationFoo);
            Annotation annotationGender = example.getClass().getDeclaredField("gender").getAnnotation(Ann.class);
            System.out.println("annotation gender = " + annotationGender);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    static void main() {
        testExample();
    }
}
