package lab7;

public class Lab7Driver {
	
	public static void main(String args[]){
		
		System.out.println("---Sum Down By 3---");
		
		System.out.println(RecursiveDefinitions.sumDownBy3(7));		// 12
		System.out.println(RecursiveDefinitions.sumDownBy3(10));	// 22
		System.out.println(RecursiveDefinitions.sumDownBy3(0));		// 0
		System.out.println(RecursiveDefinitions.sumDownBy3(2));		// 2
		System.out.println(RecursiveDefinitions.sumDownBy3(5)); 	// 7
		
		System.out.println("---Harmonic Sum---");
		
		System.out.println(RecursiveDefinitions.harmonicSum(7));
		System.out.println(RecursiveDefinitions.harmonicSum(10));
		System.out.println(RecursiveDefinitions.harmonicSum(1));
		
		System.out.println("---Geometric Sum---");
		
		System.out.println(RecursiveDefinitions.geometricSum(7));
		System.out.println(RecursiveDefinitions.geometricSum(10));
		System.out.println(RecursiveDefinitions.geometricSum(1));
		
		System.out.println("---Additive Multiplication---");
		
		System.out.println(RecursiveDefinitions.additiveMult(2,3));		// 6
		System.out.println(RecursiveDefinitions.additiveMult(3,2));		// 6
		
		System.out.println("---Loan Amount---");
		
		System.out.println(RecursiveDefinitions.loanLength(1000, 0.10, 200));	// 6 month
		System.out.println(RecursiveDefinitions.loanLength(1000, 0.10, 1050));	// 1 month
		System.out.println(RecursiveDefinitions.loanLength(0, 0.90, 50));		// 0 month
		
	}
	
}
