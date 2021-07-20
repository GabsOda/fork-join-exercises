package vectorSum;

public class ConventionalVectorSum {
    
    public static Integer sum(Integer[] arr){
        int sum = 0; 

        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
        }

        return sum; 
    }

}
