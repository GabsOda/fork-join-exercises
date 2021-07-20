package parallelRobot;

public class ParallelRobotProgram {
    public static void main(String[] args) {
        long rutimeStart = System.currentTimeMillis();

        ParallelRobot robot = new ParallelRobot(20, 20, false); 

        long total = robot.compute(); 

        long runtimeEnd = System.currentTimeMillis() - rutimeStart; 

        System.out.println(total);
        System.out.println("~ Runtime: " + runtimeEnd);
    }   
}
