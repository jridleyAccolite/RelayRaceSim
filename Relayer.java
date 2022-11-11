import java.util.Random;

// Relayer is a Runner who follows a partner
public class Relayer extends Runner{
    Thread partner;

    public Relayer(Thread p){
        this.partner = p;
    }

    @Override
    public void run() {
        try {
            partner.join(); // waits for partner before executing Runner.run() method
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        super.run();
    }
}
