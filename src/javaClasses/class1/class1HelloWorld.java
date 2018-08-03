package javaClasses.class1;

/**
 * Created by yehuixiang on 8/2/18.
 */
class class1Student {
    public int age;
    private final String name;//final修饰的必须要初始化
    private static String school;
    private static final String GREETINGS = "Hello";

    public class1Student(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void sayHello(){
        System.out.println(GREETINGS+"I am "+ name + ". I am " + age);
    }
}

public class class1HelloWorld{
    public static void main(String[] args){
        class1Student firstStudent = new class1Student("Tom");
        class1Student secondStudent = new class1Student("Jerry");
        class1Student thirdStudent = null;
        firstStudent.setAge(18);
        secondStudent.setAge(10);
        firstStudent.sayHello();
        secondStudent.sayHello();
        //class1Student thirdStudent = null;
        try{
            thirdStudent.sayHello();
        }catch (NullPointerException e){
            System.out.println("Expected error occured!" + e.toString());
        }
    }
}
