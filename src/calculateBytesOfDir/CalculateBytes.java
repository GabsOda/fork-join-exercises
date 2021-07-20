package calculateBytesOfDir;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CalculateBytes extends RecursiveTask<Long>{
    private File file; 

    public CalculateBytes(File file){
        this.file = file; 
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    protected Long compute() {
        if(file.isFile()) {
            return file.length(); 
        } else {
            File[] files = file.listFiles();
            
            return CalculateBytes.invokeAll(createSubtasks(files))
                .stream()
                .mapToLong(CalculateBytes::join)
                .sum();
        }

    }

    private Collection<CalculateBytes> createSubtasks(File[] files){
        List<CalculateBytes> subtasks = new ArrayList<>(); 

        for(int i = 0; i < files.length; i++){
            subtasks.add(new CalculateBytes(files[i])); 
        }

        return subtasks; 
    }

}
