public class ArrayOps {

    // no constructor
    
    // a public static method called copyIntArray.  It takes an int array as an
    // argument and returns a brand new one, made by copying the values from 
    // the first array
    public static int[] copyIntArray(int[] array){
        
        int[] copyedArray = new int[7];
        
        for (int i = 0; i < array.length; i++){
            copyedArray[i] = array[i];
        }
        
        return copyedArray;
        
    }
    
    // a public static method called copyDoubleArray.  It does the same as 
    // copyIntArray, but takes and returns a double array
    public static double[] copyDoubleArray(double[] array){
        
        double[] copyedArray = new double[7];
        
        for (int i = 0; i < array.length; i++){
            copyedArray[i] = array[i];
        }
        
        return copyedArray;
    }
    
    // two public static methods both named sumArray.  One should take an int 
    // array, the other should take a double array.  The one that takes an int 
    // array should return an integer and the one that takes a double should 
    // return a double.
    public static int sumArray(int[] array){
        
        int sum = 0;
        
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        return sum;
        
    }
    
    public static double sumArray(double[] array){
        
        double sum = 0;
        
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        return sum;
        
    }
}


