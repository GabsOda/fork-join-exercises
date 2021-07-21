package parallelRobot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        if(x < 5 && x < 5 || divided == true) {
            return countPaths(x, y); 
        }else {
            return ParallelRobot.invokeAll(createSubtasks(x, y))
                .stream()
                .mapToLong(ParallelRobot::join)
                .sum(); 
        }
    }

    private Collection<ParallelRobot> createSubtasks(long x, long y) {
        List<ParallelRobot> subtasks = new ArrayList<>(); 

        subtasks.add(new ParallelRobot(x - 1, y, true)); 
        subtasks.add(new ParallelRobot(x, y - 1, true));

        return subtasks; 
    }

    public long countPaths(long x, long y) {
        if(x == 0 || y == 0) {
            return 1L; 
        }
        return (countPaths(x - 1, y) + countPaths(x, y - 1)); 
    }
}
