package calculateBytesOfDir;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class CalculateBytesOfDirProgram {
    public static void main(String[] args) {
        Long size;
        String dir = "C:\\temp";

        // Conventional method 
        long start = System.currentTimeMillis();
        
        size = ConventionalCalculateBytes.calculation(new File(dir));   

        long end = System.currentTimeMillis() - start;

        System.out.println("---------------------------------------------------------");
        System.out.println("|~ The conventional sum : ");
        System.out.println("| on " + dir + " directory"); 
        System.out.println("| -> Result = " + size + " Bytes"); 
        System.out.println("| ------------------------------------------------------- ");
        System.out.println("|~ Runtime: " + end + " ms ");
        System.out.println("---------------------------------------------------------");

        // fork/join method
        long runtimeStart = System.currentTimeMillis();
        
        ForkJoinPool pool = new ForkJoinPool();

        size = pool.invoke(new CalculateBytes(new File(dir))); 

        pool.shutdown();

        long runtimeEnd = System.currentTimeMillis() - runtimeStart;

        System.out.println("---------------------------------------------------------");
        System.out.println("|~ The sum with join/fork method: ");
        System.out.println("| on " + dir + " directory"); 
        System.out.println("| -> Result = " + size + " Bytes"); 
        System.out.println("| ------------------------------------------------------- ");
        System.out.println("|~ Runtime: " + runtimeEnd + " ms ");
        System.out.println("---------------------------------------------------------");

    }
}
