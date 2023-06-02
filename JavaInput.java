import java.util.Scanner;

class Input {

    public static void main (String[]args){

Scanner get = new Scanner(System.in);

System.out.println("Enter first number :");
int first_num = get.nextInt();

System.out.println("Enter second number :");
int second_num = get.nextInt();

int sum, multiplication, divide, subtract, modulus;

sum = first_num + second_num;
System.out.println("The sum of " + first_num + " and " + second_num + " is: " + sum);

subtract = first_num - second_num;
System.out.println("The difference of " + first_num +" and " + second_num + " is: " + subtract);

divide = first_num / second_num;
System.out.println("The division of " + first_num +" and " + second_num +" is: " + divide);

multiplication = first_num * second_num;
System.out.println("The multiplication of " + first_num + " and " + second_num +" is: " + multiplication);

modulus = first_num % second_num;
System.out.println("The remainder of " + first_num + " and " + second_num + " is: " + modulus);

get.close();
    }
}