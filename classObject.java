class Sum {

   void subtract () {
   int num1 = 70;
   int num2 = 20;

   int minus = num1 - num2;

   System.out.println("The result is " + minus);
   }

    //Defining a returnable method
    int addNumbers (int a, int b){
       
        return a + b;
    }

    // method overloading
    int addNumbers (int a, int b, int c){
        return a + b + c;
    }
    
    //method overloading
    String addNumbers (String a){
        return a;
    }
}
class Main {
    public static void main (String[]args){

        Sum sum = new Sum();
        Sum sub = new Sum();
        
        int result = sum.addNumbers(20, 20);
        int result1 = sum.addNumbers(20, 20, 20);
        String result2 = sum.addNumbers("500");
        
        sub.subtract();
        System.out.println("The result is " + result);
        System.out.println("The result is " + result1);
        System.out.println("The result is " + result2);
        
    }
}