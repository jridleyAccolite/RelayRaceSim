import java.util.ArrayList;
import java.util.List;

public class Team implements Runnable{

    List<Thread> members;
    static final int max_size = 15;

    public Team(int size, int teamNumber){
        if(size > max_size){
            System.out.println("Maximum team size is " + max_size);
        }

        // create new array of threads
        members = new ArrayList<Thread>();

        // create a leader of team (who does not wait for anyone)
        members.add(new Thread(new Runner(), "Team " + Integer.toString(teamNumber) +
            " runner 1"));

        // populate team with runners
        for (int i = 1; i < size; i++) {
            members.add(new Thread(new Relayer(members.get(i-1)), "Team " + Integer.toString(teamNumber) +
                    " runner " + Integer.toString(i+1)));
        }
    }

    @Override
    public void run() {
        for (Thread m : members){
            m.start();
        }

        // wait for last team member to finish
        try {
            members.get(members.size()-1).join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Team " + Thread.currentThread().getName() + " has finished!! =============");
    }

}
