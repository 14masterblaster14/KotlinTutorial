package Java;

import Kotlin.MyCustomKotlinFileName;

//import Kotlin.MyTestKt;

public class MyJava {

    public static void main(String[] args) {

        //int sum = MyTestKt.addNumbers(3,4);
        int sum = MyCustomKotlinFileName.addNumbers(3, 4);
        System.out.println("Printing sum from java file :" + sum);
    }

    public static int getArea(int length, int breadth) {
        return length * breadth;
    }
}
