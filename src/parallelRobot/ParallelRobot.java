package parallelRobot;

import java.util.concurrent.RecursiveTask;

public class ParallelRobot extends RecursiveTask<Long> {
    
    long x; 
    long y; 
    boolean divided; 

    public ParallelRobot(long x, long y, boolean divided) { 
        this.x = x;
        this.y = y; 
        this.divided = divided; 
    }

    @Override
    protected Long compute() {
        //System.out.println(Thread.currentThread().getName());
        if (divided == true) {
            return countPaths(x, y); 
        }

        ParallelRobot pr1 = new ParallelRobot(x - 1, y, true);
        ParallelRobot pr2 = new ParallelRobot(x, y - 1, true); 

        pr1.fork();
        pr2.fork(); 

        long pr1Result = pr1.join(); 
        long pr2Result = pr2.join(); 

        return pr1Result + pr2Result; 
    }

    public long countPaths(long x, long y) {
        if(x == 0 || y == 0) {
            return 1L; 
        }
        return (countPaths(x - 1, y) + countPaths(x, y - 1)); 
    }
}
