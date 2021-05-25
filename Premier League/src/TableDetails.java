import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableDetails {

    private SimpleStringProperty clubName;
    private SimpleIntegerProperty numberOfMatchesPlayed;
    private SimpleIntegerProperty numberOfWins;
    private SimpleIntegerProperty numberOfDraws;
    private SimpleIntegerProperty numberOfDefeats;
    private SimpleIntegerProperty numberOfGoalsScored;
    private SimpleIntegerProperty numberOfGoalsConceded;
    private SimpleIntegerProperty goalDifference;
    private SimpleIntegerProperty totalPoints;


    public TableDetails(String clubName,int numberOFWins,int numberOfDraws,int numberOfDefeats,
                        int totalPoints,int numberOfMatchesPlayed,int numberOfGoalsScored,
                        int numberOfGoalConceded,int goalDifference) {
        this.clubName=new SimpleStringProperty(clubName);
        this.numberOfWins=new SimpleIntegerProperty(numberOFWins);
        this.numberOfDraws=new SimpleIntegerProperty(numberOfDraws);
        this.numberOfDefeats=new SimpleIntegerProperty(numberOfDefeats);
        this.totalPoints=new SimpleIntegerProperty(totalPoints);
        this.numberOfMatchesPlayed=new SimpleIntegerProperty(numberOfMatchesPlayed);
        this.numberOfGoalsScored=new SimpleIntegerProperty(numberOfGoalsScored);
        this.numberOfGoalsConceded=new SimpleIntegerProperty(numberOfGoalConceded);
        this.goalDifference= new SimpleIntegerProperty(goalDifference);
    }

    public String getClubName() {
        return clubName.get();
    }

    public SimpleStringProperty clubNameProperty() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName.set(clubName);
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed.get();
    }

    public SimpleIntegerProperty numberOfMatchesPlayedProperty() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed.set(numberOfMatchesPlayed);
    }

    public int getNumberOfWins() {
        return numberOfWins.get();
    }

    public SimpleIntegerProperty numberOfWinsProperty() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins.set(numberOfWins);
    }

    public int getNumberOfDraws() {
        return numberOfDraws.get();
    }

    public SimpleIntegerProperty numberOfDrawsProperty() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws.set(numberOfDraws);
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats.get();
    }

    public SimpleIntegerProperty numberOfDefeatsProperty() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats.set(numberOfDefeats);
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored.get();
    }

    public SimpleIntegerProperty numberOfGoalsScoredProperty() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored.set(numberOfGoalsScored);
    }

    public int getNumberOfGoalsConceded() {
        return numberOfGoalsConceded.get();
    }

    public SimpleIntegerProperty numberOfGoalsConcededProperty() {
        return numberOfGoalsConceded;
    }

    public int getGoalDifference() {
        return goalDifference.get();
    }

    public SimpleIntegerProperty goalDifferenceProperty() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference.set(goalDifference);
    }

    public void setNumberOfGoalsConceded(int numberOfGoalsConceded) {
        this.numberOfGoalsConceded.set(numberOfGoalsConceded);
    }

    public int getTotalPoints() {
        return totalPoints.get();
    }

    public SimpleIntegerProperty totalPointsProperty() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints.set(totalPoints);
    }
}
