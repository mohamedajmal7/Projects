import java.util.Objects;

public class FootballClub extends SportsClub {

  //instance variables
   int numberOfMatchesPlayed;
  private int numberOfWins;
  private int numberOfDraws;
  private int numberOfDefeats;
  private int numberOfGoalsScored;
  private int numberOfGoalsConceded;
  private int totalPoints;
  private int goalDifference;
  private String managerName;

  
  //constructors
  //public FootballClub(){}

  //argument constructors
  public FootballClub(String clubName, String clubLocation, String clubPresidentName, int clubContactNo,
                      int clubEstYear, int numberOfMatchesPlayed, int numberOfWins, int numberOfDraws,
                      int numberOfDefeats, int numberOfGoalsScored, int numberOfGoalsConceded, int totalPoints,
                      int goalDifference, String managerName) {
    super(clubName,clubLocation,clubPresidentName,clubContactNo,clubEstYear);

  this.numberOfMatchesPlayed = numberOfMatchesPlayed;
  this.numberOfWins = numberOfWins;
  this.numberOfDraws = numberOfDraws;
  this.numberOfDefeats = numberOfDefeats;
  this.numberOfGoalsScored = numberOfGoalsScored;
  this.numberOfGoalsConceded = numberOfGoalsConceded;
  this.totalPoints = totalPoints;
  this.goalDifference=getNumberOfGoalsScored()-getNumberOfGoalsConceded();
  this.managerName=managerName;

   
  }

  //getters and setters
  public int getNumberOfMatchesPlayed() {
    return numberOfMatchesPlayed;
  }

  public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
    this.numberOfMatchesPlayed = numberOfMatchesPlayed;
  }
  

  public int getNumberOfWins() {
    return numberOfWins;
  }

  public void setNumberOfWins(int numberOfWins) {
    this.numberOfWins = numberOfWins;
  }

  public int getNumberOfDraws() {
    return numberOfDraws;
  }

  public void setNumberOfDraws(int numberOfDraws) {
    this.numberOfDraws = numberOfDraws;
  }

  public int getNumberOfDefeats() {
    return numberOfDefeats;
  }

  public void setNumberOfDefeats(int numberOfDefeats) {
    this.numberOfDefeats = numberOfDefeats;
  }

  public int getNumberOfGoalsScored() {
    return numberOfGoalsScored;
  }

  public void setNumberOfGoalsScored(int numberOfGoalsScored) {
    this.numberOfGoalsScored = numberOfGoalsScored;
  }

  public int getNumberOfGoalsConceded() {
    return numberOfGoalsConceded;
  }



  public int getTotalPoints() {
    return totalPoints;
  }

  public void setTotalPoints(int totalPoints) {
    this.totalPoints = totalPoints;
  }

  public void setNumberOfGoalsConceded(int numberOfGoalsConceded) {
    this.numberOfGoalsConceded = numberOfGoalsConceded;
  }

  public int getGoalDifference() {
    return goalDifference;
  }

  public void setGoalDifference(int goalDifference) {
    this.goalDifference = goalDifference;
  }

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }



  @Override
  public String toString() {
    return "FootballClub{" + super.toString()  +"number of Wins=" + numberOfWins +", number of Draws="
            + numberOfDraws +", number of Defeats=" + numberOfDefeats +", number of Goals Scored=" +
            numberOfGoalsScored +", number of Goals Conceded=" + numberOfGoalsConceded +", total Points="
            + totalPoints +", number of Matches Played=" + numberOfMatchesPlayed +", Manager name=" + managerName+'}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FootballClub)) return false;
    if (!super.equals(o)) return false;
    FootballClub that = (FootballClub) o;
    return numberOfMatchesPlayed == that.numberOfMatchesPlayed &&
            numberOfWins == that.numberOfWins &&
            numberOfDraws == that.numberOfDraws &&
            numberOfDefeats == that.numberOfDefeats &&
            numberOfGoalsScored == that.numberOfGoalsScored &&
            numberOfGoalsConceded == that.numberOfGoalsConceded &&
            totalPoints == that.totalPoints &&
            Objects.equals(managerName, that.managerName) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfMatchesPlayed, numberOfWins, numberOfDraws, numberOfDefeats,
            numberOfGoalsScored, numberOfGoalsConceded, totalPoints, managerName);
  }
}

//refferences
//https://www.geeksforgeeks.org/constructors-in-java/
//https://www.tutorialspoint.com/what-is-the-difference-between-getter-setter-methods-and-constructor-in-java
//https://www.edureka.co/blog/pojo-in-java/
//https://data-flair.training/blogs/pojo-class-in-java/
//https://www.geeksforgeeks.org/pojo-vs-java-beans/



