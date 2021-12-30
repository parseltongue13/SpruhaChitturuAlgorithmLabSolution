package driver;
import java.util.Scanner;

public class minimumNotes {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the number of denominations:");
		int size= sc.nextInt();
		
		int[] notes=new int[size];
		int[] numNotes = new int[size];

		System.out.println("Enter the denominations:");
		for(int i=0;i<size;i++) {
			notes[i] = sc.nextInt();
		}
		
		MergeSortImplementation ms=new MergeSortImplementation();
		ms.sort(notes, 0, notes.length-1);
		
		for(int j=0;j<notes.length;j++) {
			System.out.println(notes[j]);
		}
		
		System.out.println("What is the amount to be paid?");
		int amount = sc.nextInt();
		
		try {
			for(int i=0; i<notes.length;i++) {
				int rem=(int)amount/notes[i];
				numNotes[i]=rem;
				amount=amount-(notes[i]*rem);
			
				if(i == notes.length-1 && amount !=0) {
					System.out.println("Not possible to pay the amount.");
				}else if(i ==notes.length-1 && amount ==0) {
					for(int j=0;j<numNotes.length; j++) {
						System.out.println(notes[j]+ " : "+ numNotes[j]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Entered nothing as denomination.");
		}
	}
}
