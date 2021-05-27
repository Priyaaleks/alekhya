package maymonth;
import java.util.Scanner;
public class multilevel {
     public static void main(String[] args) {
    	 
    	 //String[][] username = new String[3][2];
    	// username[0][0] = "ale";
    	 //username[0][1] = "123";
    	 //username[1][0] = "balu";
    	 //username[1][1] = "456";
    	 //username[2][0] = "rani";
    	 //username[2][1] = "789";
    	 
    	 //System.out.println("names are" + username[2][1]);
    
    	 Scanner scan = new Scanner(System.in);
    	 System.out.println("Enter no of rows and columns");
    	 String[][] names = new String[3][2];
    	 
    	 for(int row =0;row<3;row++) {
    		 for(int col=0;col<2;col++) {
    			 names[row][col] = scan.nextLine();
    		 }
    	 }
    	 
    	 for(int row =0;row<3;row++) {
    		 for(int col=0;col<2;col++) {
    			 System.out.print(names[row][col] +" ");
    		 }
    		     System.out.println("");
    	 }
     }
     
}
