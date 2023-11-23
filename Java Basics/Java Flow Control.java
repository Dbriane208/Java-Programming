import javax.swing.JOptionPane;
import java.util.Scanner;

// UsingIf, If-else, If -else - If statements
// A simpe grading system using if statements

class Grades {

    public static void main (String[]args){

        String score = JOptionPane.showInputDialog("Enter your score : ");
        int input = Integer.parseInt(score);

        if(input >= 80 && input <= 100 ){
            System.out.println(input + " is " +" Grade A ");
        }
        else if( input <= 79 && input >= 75){
            System.out.println(input + " is " + " Grade A- ");
        }
        else if (input <= 74 && input >= 70 ){
            System.out.println(input + " is " + " Grade B+ ");
        }
        else if (input <= 69 && input >= 65){
            System.out.println(input + " is " + " Grade B ");
        }
        else if (input <= 64 && input >= 60){
            System.out.println(input + " is " + " Grade B- ");
        }
        else if (input <= 59 && input >= 55){
            System.out.println(input + " is " + " Grade C+ ");
        }
        else{
            System.out.println("Not qualified to attend University");
        }
    }
}

// Checking for even numbers

class EvenOrOddNum {
    public static void main (String[]args){
 
        Scanner number = new Scanner(System.in);

        System.out.println("Enter a numeric value :");
        int num_value = number.nextInt();

        if(num_value%2 == 0){
            System.out.println(num_value + " is an even number");
        }else{
            System.out.println(num_value + " is an odd number"); 
        }

        number.close();
    }
}

// Checking for leap year

class LeapYear {
    public static void main (String[]args){

        String year = JOptionPane.showInputDialog("Enter the year :");
        int leap_year = Integer.parseInt(year);



        if(leap_year%400 == 0){
            System.out.println(leap_year + " is a leap year ");
        }
        else{
            System.out.println(leap_year + " is a not a leap year "); 
        }

    }
}

// Checking for prime numbers

 class PrimeNumbers {

    public static void main(String[] args) {

        String primeNum = JOptionPane.showInputDialog("Enter a number:");
        int prime_Num = Integer.parseInt(primeNum);

        if (isPrime(prime_Num)) {
            System.out.println( prime_Num + " is a Prime Number");
        } else {
            System.out.println(prime_Num + " is not a Prime Number");
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

// Checking for largest numbers for a given Input

class LargestNum {
     
    public static void main (String[]args){
  
        Scanner large = new Scanner(System.in);
        int largest;

        System.out.println("Enter the first number :");
        int firstNum = large.nextInt();

        System.out.println("Enter the second number :");
        int secondNum = large.nextInt();

        System.out.println("Enter the third number :");
        int thirdNum = large.nextInt();


        if(firstNum >= secondNum){
            if(firstNum>= thirdNum){
               largest = firstNum;
            }
            else{
                largest = thirdNum;
            }
        }else{
            if(secondNum >= thirdNum ){
                largest = secondNum;
            }else{
                largest = thirdNum;
            }
        }

        System.out.println("The largest number is : " + largest);

        large.close();
    }
}

// A simple grading system using Switch case 

class SwitchCase {

    public static void main (String[]args){

        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter your score :");
        int score = input.nextInt();

        char grade;


        switch (score){

            case 81:
            grade = 'A';
            break;

            case 70:
            grade = 'B';
            break;

            case 60:
            grade = 'C';
            break;

            case 50:
            grade = 'D';
            break;

            case 40:
            grade = 'E';
            break;

            case 30:
            grade = 'F';
            break;

            default:
            grade = 'Z';
            break;
        }

        System.out.println("My score is : " + score + " and my grade is : " + grade );

        input.close();

    }

}

// Printing a triangle and a square of stars

class forLoop {

    public static void main (String []args){

        for( int i = 0; i < 5; i++){

            for (int j = 0; j < 5; j++){
                
                System.out.print("*");
            }
               System.out.println();
        }

        for( int i = 0; i < 5; i++){

            for (int j = 0; j < i; j++){
                
                System.out.print("*");
            }
               System.out.println();
        }

    }
}

// Calculating the sum of elements in an integer

class sumArrayInteger {

    public static void main (String[]args){

        int [] evenNums = {2,4,6,8,10};
        int sum = 0;

        for(int evenNum : evenNums){
            sum += evenNum;
        }

        System.out.println(sum);
    }
}

// Comparing two numbers using the while loop

class CompareNums{

    public static void main (String[]args){

        String firstNum = JOptionPane.showInputDialog("Enter first number : ");
        int num1 = Integer.parseInt(firstNum);

        String secondNum = JOptionPane.showInputDialog("Enter second number : ");
        int num2 = Integer.parseInt(secondNum);

        while(num1 > num2){

            System.out.println("The largest Number between " + num1 + " and " + num2 + " is " + num1);
            break;

        }

         while(num2 > num1){

            System.out.println("The largest Number between " + num1 + " and " + num2 + " is " + num2);
            break;

        }

    }
}

