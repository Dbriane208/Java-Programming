import javax.swing.JOptionPane;
import java.util.Scanner;


class Array1D {

    public static void main (String[]args){
     
        // Names to be stored in the array of size five
        String [] Names = new String[5];

        // This limit s our entry to only five inputs
        for (int name = 0; name < Names.length; name++){
        String input = JOptionPane.showInputDialog("Enter your name ");
        Names [name] = input;
        }
        
        // Lets now print the names in the array using a for each
        for(String name1 : Names){
        System.out.println(name1);
        }
    }
}

// Displaying elements in a 2D element

class Array2D {

    public static void main (String[]args){

        int [][] matrix = new int[2][2];

        Scanner scan = new Scanner(System.in);

        for(int matElem1 = 0; matElem1 < matrix.length; matElem1++){

            for(int matElem2 = 0; matElem2 < matrix[matElem1].length; matElem2++){

            System.out.println("Enter a number : ");
            int input = scan.nextInt();
            matrix[matElem1][matElem2] = input;
        }
    }

        
        for(int[] innerArray : matrix){
            for(int data : innerArray){
                System.out.println(" The Array 2D elements are : " + data);
            }
        }
           System.out.println();

           scan.close();
    }
}

class Array3D {

    public static void main (String[]args){

        int [][][] matrix = new int[2][2][2];

        Scanner scan = new Scanner(System.in);

        for(int matElem1 = 0; matElem1 < matrix.length; matElem1++){

            for(int matElem2 = 0; matElem2 < matrix[matElem1].length; matElem2++){

                for(int matElem3 = 0 ; matElem3 < matrix[matElem2].length; matElem3 ++){
        
                    System.out.println("Enter a number : ");
                    int input = scan.nextInt();
                    matrix[matElem1][matElem2][matElem3] = input;
                }

        }
    }

        
        for(int[][] Array2D : matrix){
            for(int [] Array1D : Array2D){
                for(int data : Array1D){
                System.out.println(" The Array 3D elements are : " + data);
            }
            }
            
        }
           System.out.println();

           scan.close();
    }
}