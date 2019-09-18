package main.Java;

import java.lang.reflect.Field;

/**
 * Author Rubick
 * Date: 2019-09-18 16:09
 * Description :
 */
public class Reflex04 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Student> cls = Student.class;

        //获取当前类和父类所有public修饰的属性
        Field[] fields = cls.getFields();

        //获取当前类的所有属性，包含private
        Field[] declaredFields = cls.getDeclaredFields();
        System.out.print("Method: ");
        for(Field f :declaredFields){
            System.out.println(f+"-----");
        }
        //获取当前类或父类中指定的public属性
        Field field = cls.getField("name");
        System.out.println("-----------");
        System.out.println(field);

        //获取当前类的任意属性
        Field field02 = cls.getDeclaredField("height");
        System.out.println("----------");
        System.out.println(field02);

        //获取父类的private属性
        Field age = cls.getSuperclass().getDeclaredField("age");
        System.out.println(age);

        Field height = cls.getDeclaredField("height");

        //通过反射为属性赋值
        Student student = new Student();
        height.setAccessible(true);//取消权限控制检查
        height.set(student,100);
        System.out.println(student);

        //获取属性值
        Object stu = height.get(student); //获取student对象的指定属性
        System.out.println(stu);


    }
}
