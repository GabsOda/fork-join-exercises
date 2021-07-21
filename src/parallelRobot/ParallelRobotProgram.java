package parallelRobot;

import java.util.concurrent.ForkJoinPool;

public class ParallelRobotProgram {
    public static void main(String[] args) {
        long total; 
        int x = 15, y = 15; 

        // Recursion method 
        long start = System.currentTimeMillis(); 

        total = RecursiveRobot.count(x, y); 

        long end = System.currentTimeMillis() - start; 


        System.out.println("---------------------------------------------------------");
        System.out.println("|~ The paths using recursion : ");
        System.out.println("| -> Result = " + total); 
        System.out.println("| ------------------------------------------------------- ");
        System.out.println("|~ Runtime: " + end + " ms ");
        System.out.println("---------------------------------------------------------");

        // using fork/join method 
        long rutimeStart = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();

        total = pool.invoke(new ParallelRobot(x, y, false)); 

        pool.shutdown();

        long runtimeEnd = System.currentTimeMillis() - rutimeStart; 

        System.out.println("---------------------------------------------------------");
        System.out.println("|~ The paths using fork/join method: ");
        System.out.println("| -> Result = " + total); 
        System.out.println("| ------------------------------------------------------- ");
        System.out.println("|~ Runtime: " + runtimeEnd + " ms ");
        System.out.println("---------------------------------------------------------");

    }   
}
