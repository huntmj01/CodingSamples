package huntmj01_lab1;

/*The purpose of this class is to print a patter of '*' and then display the
  programmers name along with his favorite number. */

public class PatternPrint {

	public static void main(String[] args) {
		
		String pattern = "**" + "\n" + "****" + "\n" + "*******" + "\n" + "****" + 
		"\n" + "**";
		int number = 70;
		
		System.out.println(pattern);
		System.out.println("\n");
		System.out.println("This program was created by Matthew Hunt.  And his favorite number is " + number + ".");
		
	}

}
