package huntmj01_lab10;

public class Main {

	public static void main(String[] args) {
		
		double[][] simple2D = {{3,4,5}, {6,7,8}, {9,9,1}};
		double[][] ragged2D = {{1,2,3,3,3,3},{3,4,5,8,9},{8,9,1}};
		
		// simple
		
		System.out.println("---SIMPLE---");
		
		double simpleTotal = ArrayOps2D.getTotal(simple2D);
		double simpleAverage = ArrayOps2D.getAverage(simple2D);
		double simpleRowTotal = ArrayOps2D.getRowTotal(simple2D, 1);
		int simpleHighestValueInRow = ArrayOps2D.findHighestValueInRow(simple2D, 1);
		
		System.out.println("Total: " + simpleTotal);
		System.out.println("Average: " + simpleAverage);
		System.out.println("Row total: " + simpleRowTotal);
		ArrayOps2D.findHighestValue(simple2D);
		System.out.println("Highest value found on index " + simpleHighestValueInRow);
		ArrayOps2D.sequentialSearch(simple2D, 1);
		
		// ragged
		
		System.out.println("\n---RAGGED---");
		
		double raggedTotal = ArrayOps2D.getTotal(ragged2D);
		double raggedAverage = ArrayOps2D.getAverage(ragged2D);
		double raggedRowTotal = ArrayOps2D.getRowTotal(ragged2D, 1);
		int raggedHighestValueInRow = ArrayOps2D.findHighestValueInRow(ragged2D, 1);
		
		System.out.println("Total: " + raggedTotal);
		System.out.println("Average: " + raggedAverage);
		System.out.println("Row total: " + raggedRowTotal);
		ArrayOps2D.findHighestValue(ragged2D);
		System.out.println("Highest value found on index " + raggedHighestValueInRow);
		ArrayOps2D.sequentialSearch(ragged2D, 1);
	}

}
