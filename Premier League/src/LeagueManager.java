import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    void addClub(FootballClub newFootballClub);
    void displayStatistics(String clubName);
    void premierLeagueTable();
    boolean deleteClub(String clubName1);
    void addMatch(String team1, String team2, int homegoals, int awaygoals,DateTime dateTime);
    void saveMatches();
    void saveClubDetails();
    public ArrayList<FootballClub> getFootballClubList();
    public ArrayList<NewMatch>getMatchList();


}
