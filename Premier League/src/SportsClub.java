import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    //instance variables
   private String clubName;
   private String clubLocation;
   private String clubPresidentName;
   private int clubContactNo;
   private int clubEstYear;

   //constructors
   public SportsClub(String clubName, String clubLocation, String clubPresidentName, int clubEstYear){}

   //arg constructor
    public SportsClub(String clubName, String clubLocation, String clubPresidentName, int clubContactNo, int clubEstYear) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.clubPresidentName = clubPresidentName;
        this.clubContactNo= clubContactNo;
        this.clubEstYear=clubEstYear;
    }

   // getters and setters
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String clubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public String getClubPresidentName() {
        return clubPresidentName;
    }

    public void setClubPresidentName(String clubPresidentName) {
        this.clubPresidentName = clubPresidentName;
    }

    public int getClubContactNo() {
        return clubContactNo;
    }

    public void setClubContactNo(int clubContactNo) {
        this.clubContactNo = clubContactNo;
    }
    public int getClubEstYear() {
        return clubEstYear;
    }

    public void setClubEstYear(int clubEstYear) {
        this.clubEstYear = clubEstYear;
    }

    @Override  //instance method overridden
    public String toString() {
        return "SportsClub{" + "Club Name='" + clubName + '\'' + ", Club Location='" + clubLocation + '\'' +
                ", President Name='" + clubPresidentName + '\'' + ", Club Contact Number=" + clubContactNo +
                ", Club established year=" + clubEstYear + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return
                Objects.equals(clubName, that.clubName) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName);
    }
}
