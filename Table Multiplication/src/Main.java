import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

       Scanner input = new Scanner(System.in);

      System.out.println("Enter the number of rows : ");
      int rows = input.nextInt();

      System.out.println("Enter the number of columns : ");
      int columns = input.nextInt();

      for(int i = 1; i <= rows; i++){
          System.out.print(i);
        for(int j = 1 ; j <= columns; j++){
          System.out.print(i*j + "");
        }
          System.out.println("");
      }

    }
}