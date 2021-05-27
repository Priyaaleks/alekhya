package maymonth;
import java.util.Scanner;
public class strings {
       
      
	public static void main(String[] args) {
		System.out.println("Enter the number of index values");
		Scanner obj = new Scanner(System.in);
		int index = obj.nextInt();
		String[] arraylist = new String[index];
	
		System.out.println("Enter "+index+" values");
		
		Scanner scan1 = new Scanner(System.in);
		
		for(int i=0;i< index;i++) {
			arraylist[i] = scan1.nextLine();
		}
		
		for(int i=0;i <index;i++) {
			System.out.println("The index values are:" + arraylist[i]);
		}
		
		int usercount = 0;
		for(int i = 0;i < index; i++) {
			if(arraylist[i].equals("ale")) {
				System.out.println("ale is recorded in database");
				usercount++;
			}
			
		}
		System.out.println("count of ale recorded:" + usercount);
		
		String name = "Alekhya";
		System.out.println("MY NAME IS:" + name);
		System.out.println("MY NAME LENGTH IS:" + name.length());
		System.out.println("MY NAME IS:" + name.toUpperCase());

	}

}
