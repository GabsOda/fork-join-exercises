package parallelRobot;

public class RecursiveRobot {
    
    public static long count(int x, int y) {
        if (x == 0 || y == 0) {
            return 1; 
        }
        return (count(x - 1, y) + count(x, y - 1)); 
    }
}
