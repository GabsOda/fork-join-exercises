package vectorSum;

import java.util.concurrent.ForkJoinPool;

public class VectorSumProgram {
    public static void main(String[] args) {
        int sum = 0;
        int quantity = 1000000;

        Integer arr[] = RandomArrGenerator.generate(quantity); 

        // Conventional method
        long start = System.currentTimeMillis();
        
        sum = ConventionalVectorSum.sum(arr); 

        long end = System.currentTimeMillis() - start ;

        System.out.println("Soma: " + sum);
        System.out.println("Tempo soma convencional: " + end);
    
        // fork/join method
        long runtimeStart = System.currentTimeMillis(); 

        ForkJoinPool pool = new ForkJoinPool();

        sum = pool.invoke(new VectorSum(arr)); 
        
        pool.shutdown();

        long runtimeEnd = System.currentTimeMillis() - runtimeStart;

        System.out.println("Soma: "+ sum);
        System.out.println("Tempo soma paralela ..: " + runtimeEnd );
        
    }
}
