package main.Java;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Author Rubick
 * Date: 2019-09-19 14:41
 * Description :
 */
public class Reflex05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> cls = Student.class;

        //获取当前类及其父类所有用public修饰的方法
        Method[] methods = cls.getMethods();

        //获取当前类的所有方法
        Method[] methods1 = cls.getDeclaredMethods();
        for(Method m:methods1){
            //返回方法名，参数类型，修饰符，参数列表
            System.out.println(m.getName()+"\t"+m.getReturnType()+"\t"+ Modifier.toString(m.getModifiers())+"\t"
                + Arrays.toString(m.getParameters()));
        }

        //获取当前类或父类指定的public方法
        Method c = cls.getMethod("c", int.class, int.class);
        System.out.println(c);

        //获取当前类的指定方法--包括private方法
        Method c1 = cls.getDeclaredMethod("c", int.class, double.class);
        c1.setAccessible(true);
        System.out.println(c1);

        //通过反射调用方法
        Student stu = new Student();
        Object value = c1.invoke(stu, 1, 1.1);
        System.out.println(value);
    }


}
