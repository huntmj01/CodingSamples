package com.test.HW2;

public class Application {

	private static int powCount = 0;

	public static void main(String args[]) {
		
		int[] arr = { 122, 54, 64, 832, 214, 26, 734, 214, 134, 636, 9343 };
		int[] arr2 = { 0, 0, 0, 0, 0, 0, 0 };
		int[] arr3 = {};
		int[] arr4 = null;
		
		
		System.out.println("--------PROBLEM 1-------");
		System.out.println("Number of matching elements in array: " + find1(arr, 214));	// Worst Case
		System.out.println("--------PROBLEM 2-------");
		System.out.println(find2(arr));
		System.out.println("Empty array: " + find2(arr3));
		//System.out.println(find2("Null array: " + arr4)); //error
		System.out.println("--------PROBLEM 3-------");
		System.out.println(find3(arr));
		System.out.println("Empty array: " + find3(arr3));
		//System.out.println(find3("Null array: " + arr4)); // error
		System.out.println("--------PROBLEM 4-------");
		System.out.println(pow(arr[5], 5));
		System.out.println("powCount: " + powCount);
	}

	private static int find1(int[] list, int element) {

		int answer = 0;  
		int itCount = 0;
		
		for (int k = 0; k < list.length; k++){
			itCount++;
			if (element == list[k]){
				answer++;
			}
		}
			
		//System.out.println("Count: " + itCount);	
		
		return answer;
		
	}// end 1

	// The array elements must be non-negative integers
	private static int find2(int[] arr) {
		int zeroCounter = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 0)
				zeroCounter++;
		}
		if (zeroCounter == arr.length)
			return 0;
		while (zeroCounter < arr.length - 2) {
			// see maxIndex() definition below
			int max = maxIndex(arr);
			arr[max] = 0;
			// see display() definition below
			display(arr);
			zeroCounter++;
		}
		return maxIndex(arr);
	}// end method

	// helper methods for find
	private static int maxIndex(int[] arr) {
		int maxindex = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[maxindex] < arr[k])
				maxindex = k;
		}
		return maxindex;
	}

	private static void display(int[] arr) {
		System.out.println();
		for (int k = 0; k < arr.length; k++)
			System.out.print(arr[k] + " ");

		System.out.println();
	}

	
	private static int find3(int[] num){
   		int answer = 0;
    		for(int k = 0; k < num.length; k++ )
      		for(int j = k; j< num.length; j++){
				int current = 0;
				for(int i = k; i<=j; i++)
					current += num[i];
				if (current > answer)
                     answer = current;
         	}
    		return answer;

    }
	
	private static double pow(double base, int num){
		powCount++;
		 if(num == 0)
			return 1;
		 else{
			 double value = pow(base,num/2);
			    		if(num%2==0)
				return value*value;
		 		   	else
						return value*value*base;
		}//end else		
	}//end method


	
	
}
