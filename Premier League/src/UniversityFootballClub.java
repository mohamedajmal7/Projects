import java.util.Objects;

public class UniversityFootballClub extends FootballClub {

    //instance variables
    private String universityName;
    private int universityContactNo;  //assummed that club office number and uni contact number are different

    //argument constructor
    public UniversityFootballClub(String clubName, String clubLocation, String clubPresidentName, int clubContactNo,
                                  int clubEstYear, int numberOfMatchesPlayed, int numberOfWins, int numberOfDraws,
                                  int numberOfDefeats, int numberOfGoalsScored, int numberOfGoalsConceded,
                                  int totalPoints,int goalDifference, String managerName, String universityName,
                                  int universityContactNo) {
        super(clubName,clubLocation,clubPresidentName,clubContactNo,clubEstYear,numberOfMatchesPlayed,numberOfWins,
                numberOfDraws,numberOfDefeats,numberOfGoalsScored,numberOfGoalsConceded,totalPoints,goalDifference,
                managerName
                );
        this.universityName = universityName;
        this.universityContactNo=universityContactNo;
        
    }
    //getters and setters
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getUniversityContactNo() {
        return universityContactNo;
    }

    public void setUniversityContactNo(int universityContactNo) {
        this.universityContactNo = universityContactNo;
    }

    //instance method overridden
    @Override
    public String toString() {
        return "UniversityFootballClub{" + super.toString()  +"university Name='" + universityName +
                "university contact Number='" + universityContactNo + '\'' +'}';
    }

    @Override
    public boolean equals(Object footballClub) {
        if (this == footballClub) return true;
        if (!(footballClub instanceof UniversityFootballClub)) return false;
        if (!super.equals(footballClub)) return false;
        UniversityFootballClub that = (UniversityFootballClub) footballClub;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }
}
