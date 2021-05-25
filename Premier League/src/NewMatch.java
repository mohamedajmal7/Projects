
import java.io.Serializable;
import java.util.Objects;

public class NewMatch implements Serializable {

    private String teamA;
    private String  teamB;
    private int teamAScore;
    private int teamBScore;
    private String date1;

    public NewMatch(){}

    public NewMatch(String teamA,  int teamAScore, int teamBScore,String teamB, String date1) {
        this.teamA=teamA;
        this.teamB=teamB;
        this.teamAScore=teamAScore;
        this.teamBScore=teamBScore;
        this.date1=date1;
    }


    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getTeamAScore(){
        return teamAScore;
    }

    public int getTeamBScore(){
        return teamBScore;
    }

    public String getDate1() {
        return date1;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public void setDate1(String date) {
        this.date1 = date;
    }

    @Override
    public String toString() {
        return
                "Home side=" + teamA + ", away=" + teamB + ", Home goals=" + teamAScore +
                ", away goals=" + teamBScore +
                ", date=" + date1
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewMatch)) return false;
        NewMatch match = (NewMatch) o;
        return teamAScore == match.teamAScore &&
                teamBScore == match.teamBScore &&
                Objects.equals(teamA, match.teamA) &&
                Objects.equals(teamB, match.teamB) &&
                Objects.equals(date1, match.date1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamA, teamAScore, teamBScore,teamB, date1);
    }

}
