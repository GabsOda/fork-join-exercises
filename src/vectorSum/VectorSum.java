package vectorSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class VectorSum extends RecursiveTask<Integer>{

    private Integer[] arr; 

    private static final int LIMIT = 500; 

    public VectorSum(Integer[] arr) {
        this.arr = arr; 
    }    
    
    @Override
    protected Integer compute() {
        if (arr.length > LIMIT) {
            return VectorSum.invokeAll(createSubTasks()) 
                .stream()
                .mapToInt(VectorSum::join)
                .sum(); 
        } else {
            return sum(arr); 
        }
    }
    
    private Collection<VectorSum> createSubTasks() {
        List<VectorSum> subtasks = new ArrayList<>(); 
        
        subtasks.add(new VectorSum(
            Arrays.copyOfRange(arr, 0, arr.length / 2)
        )); 
        subtasks.add(new VectorSum(
            Arrays.copyOfRange(arr, arr.length / 2 , arr.length)
        ));

        return subtasks; 
    }

    private Integer sum(Integer[] arr) {
        return Arrays
            .stream(arr)
            .reduce(0, Integer::sum); 
    }

}
