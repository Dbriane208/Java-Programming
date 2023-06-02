class AddTwoNum {

// Adding two numbers 
    public static void main (String[]args){

        int num1 = 40;
        int num2 = 30;
         num1 += num2;

        System.out.println(num1);
    }
}

//Widening using Java
class Widen {

    public static void main (String[]args){

        int val = 20;
        float value = val;

        System.out.println(val);
        System.out.println(value);

    }
}

// Use to convert from one data type to another
class TypeCast {

    public static void main(String[]args){

        float first_num = 30.9f;
        int  sec_num = (int)first_num;

        System.out.println(first_num);
        System.out.println(sec_num);
    }
}

class Overflow {

    public static void main(String[]args){

        int a = 130;
        byte b = (byte)a;

        System.out.println(a);
        System.out.println(b);
    }
}

class Byte {
    
    public static void main (String[]args){

    byte abc = 10;
    byte xyz = 10;
    byte sum = (byte)(abc + xyz);

    System.out.println(sum);

    }
}

// Working with java data types

class DataTypes {

    public static void main (String[]args){

//bolean
boolean value = true;
System.out.println(value);

//short
short height = 124;
System.out.println(height);

//byte
byte age = 24;
System.out.println(age);

//long
Long loss = -345670000L;
System.out.println(loss);

//double
double  length = 34.90;
System.out.println(length);

//float
float litres = 10.5f;
System.out.println(litres);

//int
int income = 150000;
System.out.println(income);

//bolean
char grade = 'A';
System.out.println(grade);


    }
}