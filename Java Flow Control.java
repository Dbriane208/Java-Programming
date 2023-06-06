import javax.swing.JOptionPane;
import java.util.Scanner;

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


