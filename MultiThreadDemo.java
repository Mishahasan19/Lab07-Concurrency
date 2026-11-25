package Lab07;
public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread calculationThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Square of " + i + " = " + (i * i));
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Calculation Thread Finished");
        });
        Thread loggingThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Logging Data " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Logging Thread Finished");
        });
        System.out.println("Starting Calculation Thread");
        calculationThread.start();
        calculationThread.join();
        System.out.println("\nStarting Logging Thread");
        loggingThread.start();
        loggingThread.join();
        System.out.println("\nProgram Finished");
    }
}