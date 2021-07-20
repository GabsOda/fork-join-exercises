package vectorSum;

import java.util.Random;

public class RandomArrGenerator {
    
    public static Integer[] generate(int quantity){
        Integer arr[] = new Integer[quantity];
        Random generator = new Random();

        for (int i = 0; i < quantity; i++) {
            arr[i] = generator.nextInt();
        }

        return arr; 
    }

}
