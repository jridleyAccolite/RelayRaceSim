import java.util.Random;

public class Runner implements Runnable{
    @Override
    public void run() {
        // variation in sleeping time to randomise race results
        Random r = new Random();
        int t = r.nextInt(1000, 3000);

        System.out.println(Thread.currentThread().getName() + " is running...");

        try {
            Thread.sleep(t);    // sleep() simulates running a certain amount of time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(Thread.currentThread().getName() + " has finished --");
    }
}
