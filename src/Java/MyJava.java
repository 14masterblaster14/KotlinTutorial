package Java;

import Kotlin.MyCustomKotlinFileName;

//import Kotlin.MyTestKt;

public class MyJava {

    public static void main(String[] args) {

        //int sum = MyTestKt.addNumbers(3,4);
        int sum = MyCustomKotlinFileName.addNumbers(3, 4);
        System.out.println("Printing sum from java file :" + sum);

        //Handelling Default Functions

        int result = MyCustomKotlinFileName.findVolume(5, 6);   //5*6*10 (by Default)
        System.out.println("Printing volume from java file :" + result);

        int result1 = MyCustomKotlinFileName.findVolume(5, 6, 7);  //5*6*7
        System.out.println("Printing volume from java file :" + result1);

        //Named Parameters < Strictly available in Kotlin but not in Java >

    }

    public static int getArea(int length, int breadth) {
        return length * breadth;
    }
}
