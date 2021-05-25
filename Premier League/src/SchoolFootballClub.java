import java.util.Objects;

public class SchoolFootballClub extends FootballClub {

    private String schoolName;  //instance variables for school football club
    private String masterInCharge;


    //argument constructors
    public SchoolFootballClub(String clubName, String clubLocation, String clubPresidentName, int clubContactNo,
                              int clubEstYear, int numberOfMatchesPlayed, int numberOfWins, int numberOfDraws,
                              int numberOfDefeats, int numberOfGoalsScored, int numberOfGoalsConceded,
                              int totalPoints,int goalDifference, String managerName,
                              String schoolName, String masterInCharge) {
        super(clubName,clubLocation,clubPresidentName,clubContactNo,clubEstYear,numberOfMatchesPlayed,numberOfWins,
                numberOfDraws,numberOfDefeats,numberOfGoalsScored,numberOfGoalsConceded,totalPoints,goalDifference,
                managerName);

        this.schoolName = schoolName;
        this.masterInCharge=masterInCharge;
    }

    //getters and setters for the instance variables
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMasterInCharge() {
        return masterInCharge;
    }

    public void setMasterInCharge(String masterInCharge) {
        this.masterInCharge = masterInCharge;
    }


    //overide instance method


    @Override
    public String toString() {
        return "SchoolFootballClub{" + super.toString()  +
                "schoolName='" + schoolName + '\'' +
                ", masterInCharge='" + masterInCharge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object footballClub) {
        if (this == footballClub) return true;
        if (!(footballClub instanceof SchoolFootballClub)) return false;
        if (!super.equals(footballClub)) return false;
        SchoolFootballClub that = (SchoolFootballClub) footballClub;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }
}
