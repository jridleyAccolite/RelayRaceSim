import java.util.ArrayList;
import java.util.List;

public class Race {

    public List<Thread> teams;

    public Race(int numTeams, int teamSize){

       teams = new ArrayList<>();

        for (int i = 1; i <= numTeams; i++) {
            teams.add(new Thread(new Team(teamSize, i), Integer.toString(i) ));
        }

    }

    public void startRace(){
        for (Thread team: teams) {
            team.start();
        }
        for (Thread team: teams) {
            try {
                team.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
