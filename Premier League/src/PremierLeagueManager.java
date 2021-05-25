
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PremierLeagueManager implements LeagueManager {
    private final ArrayList<FootballClub>footballClubList=getFootballClubList();
    private final int clubCount=footballClubList.size(); //variable which stores no of regsted clubs
    private  ArrayList<NewMatch> matchList=new ArrayList<>();

//logic for adding a new club to the existing array list
    @Override
    public void addClub(FootballClub newFootballClub) { //logic for adding a new club

        if (footballClubList.contains(newFootballClub)) { //checking whether any club is already stored with the same name
            System.out.println("This club is already registered under premier league.");
        } else if (clubCount == 20) { //since PL is conducted with 20 teams, a checker for total clubs
            System.out.println("league is full");
        } else if (clubCount == 19) { //this checker is used to give the user a high experience
            footballClubList.add(newFootballClub);

            System.out.println("Successfully registered");
            System.out.println("Number of registered clubs : " + footballClubList.size());
            System.out.println("there is space for another one club to register");

        } else {
            footballClubList.add(newFootballClub);

            System.out.println("Successfully registered");
            System.out.println("Number of registered clubs : " + footballClubList.size());
            System.out.println("there is space for another " + (20 - footballClubList.size()) + " clubs to register");
            //saveData("club.txt");
        }
        saveClubDetails();
    }
//logic to delete a club fo the arraylist
    @Override
    public boolean deleteClub(String clubName1) {
        boolean found = false;
        if (footballClubList.isEmpty()) { //checking for existance of clubs in list
            System.out.println("No clubs are registered still");
        } else {
            for (FootballClub Club1 : footballClubList) {
                if (Club1.getClubName().equals(clubName1)) { //checking for similar objects
                    found = true;

                    footballClubList.remove(Club1);//removing the object from list
                    System.out.println("successfully removed the club");
                    System.out.println("No of clubs : " + footballClubList.size());
                    saveMatches();
                    saveClubDetails();
                    break;
                }
                System.out.println("Sorry! there is no such club with the provided name.");
            }
        }
        return found;
    }

    @Override
    public void displayStatistics(String clubName){ //logic to display stat of a club
        if (footballClubList.isEmpty()){ //checking the arraylist, whether it contain any elemnt
            System.out.println("No clubs are registered still");
        }
        else {
            boolean found=false;

            for (FootballClub club:footballClubList){
                if (club.getClubName().equals(clubName)){ //checking for existance of club
                    found=true; //if it exists, the follwing stats will be shown
//printing the stats of the club
                    System.out.println("Club Name       : "+club.getClubName());
                    System.out.println("Matches played  : "+club.getNumberOfMatchesPlayed());
                    System.out.println("Number of Wins  : "+club.getNumberOfWins());
                    System.out.println("Number of Loss  : "+club.getNumberOfDefeats());
                    System.out.println("Number of Tie   : "+club.getNumberOfDraws());
                    System.out.println("Total points    : "+club.getTotalPoints());
                    System.out.println("Goals Scored    : "+club.getNumberOfGoalsScored());
                    System.out.println("Goals conceded  : "+club.getNumberOfGoalsConceded());
                    System.out.println("Goal deference  : "+(club.getNumberOfGoalsScored()-club.getNumberOfGoalsConceded()));
                    //System.out.println("Club Name : "+club.getClubName());
                    System.out.println();
                    //System.out.println(matchList.contains(club));
                }
            }if(!found){ //if the club didnt exist, the message will be shown
                System.out.println("Sorry! there is no such club registered here.");
            }
        }

    }

    @Override
    public void premierLeagueTable(){
        if (footballClubList.isEmpty()){ //method to dislpay table
            System.out.println("No clubs are registered still to display the table");
        }else {
            //getting the right formt for the table with printf
            System.out.printf("%10s  %5s  %5s  %5s  %5s  %8s  %5s  %5s  %5s  \n", "Club Name", "MP", "W", "L", "T", "Points", "GS", "GC", "GD");

            Collections.sort(footballClubList, new PointsSorting());//sorting the values according to the points
            for (FootballClub club : footballClubList) {//getting out put
                System.out.printf("%10s  %5s  %5s  %5s  %5s  %5s  %8s  %5s  %5s  \n", club.getClubName(), club.getNumberOfMatchesPlayed(), club.getNumberOfWins(), club.getNumberOfDefeats(), club.getNumberOfDraws(), (club.getNumberOfWins()*3+club.getNumberOfDraws()), club.getNumberOfGoalsScored(), club.getNumberOfGoalsConceded(), (club.getNumberOfGoalsScored() - club.getNumberOfGoalsConceded()));
            }
        }
    }

    @Override
    public void addMatch(String team1, String team2, int homegoals, int awaygoals,DateTime dateTime){
        if (footballClubList.isEmpty()){
            System.out.println("No clubs are registered still");
        }
        else{
            //initializing two club objects
            FootballClub home=null;
            FootballClub away=null;
            //DateTime date= new DateTime(day, month, year);
            for (FootballClub club1:footballClubList) {
                if (club1.getClubName().equals(team1)) //checking for equal object in array list

                    home = club1; //if the clubs with same name exists, assigning it to the object created

            }

            if (home==null){ //if such club is not found, the error msg
                System.out.println("No such club in the premier league called " + team1);
                return;
            }
            for (FootballClub club2 : footballClubList) {
                if (club2.getClubName().equals(team2))
                    away = club2;

            }
            if (away==null){
                System.out.println("No such club in the premier league called " + team2);
                return;
            }else if (away==home){
                System.out.println("the clubs you entered are the same. please enter different clubs");
                return;
            }

            int homeGoals=-1; //assigning a default value for error handling
            try {
                homeGoals=(homegoals); //assigning the useer input value
            }catch (Exception e){
                System.out.println("Please enter the number of goals scored by home side : ");

            }
            if (homeGoals<0){ //error msgs for negative value
                System.out.println("expected to enter number of goals scored");
                return;
            }

            int awayGoals=-1;
            try {
                awayGoals=(awaygoals);
            }catch (Exception e){
                System.out.println("Please enter the number of goals scored by away side : ");

            }
            if (awayGoals<0){
                System.out.println("expected to enter number of goals scored");
                return;
            }

            //creating a match instance and assiging values for statistics of both the clubs
            NewMatch match =new NewMatch();
            match.setTeamA(team1);
            match.setTeamB(team2);
            match.setTeamAScore(homeGoals);
            match.setTeamBScore(awayGoals);
            match.setDate1(dateTime.toString());
            matchList.add(match);

            assert home != null;
            home.setNumberOfGoalsScored(home.getNumberOfGoalsScored()+homeGoals);
            assert away != null;
            away.setNumberOfGoalsScored(away.getNumberOfGoalsScored()+awayGoals);
            home.setNumberOfGoalsConceded(home.getNumberOfGoalsConceded()+awayGoals);
            away.setNumberOfGoalsConceded(away.getNumberOfGoalsConceded()+homeGoals);
            home.setNumberOfMatchesPlayed(home.getNumberOfMatchesPlayed()+1);
            away.setNumberOfMatchesPlayed(away.getNumberOfMatchesPlayed()+1);

            //checking for win side and allocating points
            if (homeGoals>awayGoals){
                home.setTotalPoints(home.getTotalPoints()+3);
                home.setNumberOfWins(home.getNumberOfWins()+1);
                away.setNumberOfDefeats(away.getNumberOfDefeats()+1);
            }
            else if (awayGoals>homeGoals){
                away.setTotalPoints(away.getTotalPoints()+3);
                away.setNumberOfWins(away.getNumberOfWins()+1);
                home.setNumberOfDefeats(home.getNumberOfDefeats()+1);
            }
            else {
                home.setTotalPoints(home.getTotalPoints()+1);
                away.setTotalPoints(away.getTotalPoints()+1);
                home.setNumberOfDraws(home.getNumberOfDraws()+1);
                away.setNumberOfDraws(away.getNumberOfDraws()+1);
            }
        }
        saveClubDetails();
        saveMatches();
    }

    @Override
    public void saveClubDetails(){
        try {
            //saving date in a file
            File fileName=new File("club.txt");
            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(footballClubList);
            System.out.println("Club Details saved successfully");
            oos.close();
        }catch (IOException e){
            System.out.println("no data found to save");
        }
    }

    @Override
    public void saveMatches() {
        File fileName=new File("Match.txt");
        try {

            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos=new ObjectOutputStream(fos);


            //  for (NewMatch match:matchList){
            oos.writeObject(matchList);
            //  }
            //oos.flush();
            //fos.close();
            oos.close();
        }catch (IOException e){
            System.out.println("There were some error in saving match details.please try again");
        }

    }//retreiving data from the text file

    //logic fro loading the data saved in a text file back to the array list
    @Override
    public ArrayList<FootballClub>getFootballClubList(){
        //declaring and initializing the array lsit
        ArrayList<FootballClub>footballClubList=new ArrayList<>();
        File file=new File("club.txt");//providing the file name

        try {
            //writing objects from txt file to the arraylist
            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fis);
            footballClubList=(ArrayList<FootballClub>)ois.readObject();
            ois.close();
            return footballClubList;
//error handling if the fil is not ound
        }catch (IOException|ClassNotFoundException e){
            return footballClubList;
        }
    }
    //logic to load the match details from a txt file
    public ArrayList<NewMatch> getMatchList() {

        File matchDetailsFile = new File("Match.txt");
        try {

            FileInputStream fInputStream = new FileInputStream(matchDetailsFile);

            ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);

            matchList=(ArrayList<NewMatch>)oInputStream.readObject();//Reference:https://stackoverflow.com/questions/52791259/java-how-to-make-objectinputstream-read-all-objects-from-file

            oInputStream.close();
            return matchList;
        } catch (Exception e) {
            return matchList;
        }
    }




    static class PointsSorting implements Comparator<FootballClub> {//comparable interface to sort

        @Override
        public int compare(FootballClub club1, FootballClub club2) {

            if(club1.getTotalPoints() > club2.getTotalPoints()) //comparing two clubs points
                return -1;
            else
            if (club1.getTotalPoints() < club2.getTotalPoints())
                return 1;
            else {//when point are equal, checking for goal difference
                int goalDif = club1.getNumberOfGoalsScored()-club1.getNumberOfGoalsConceded();
                int goalDif1 = club2.getNumberOfGoalsScored()-club2.getNumberOfGoalsConceded();
                if(goalDif > goalDif1)
                    return -1;
                else
                if(goalDif < goalDif1)
                    return 1;
                else return 0;
            }

        }
    }

    static class sortByGoals implements Comparator<FootballClub>{
        @Override
        public  int compare (FootballClub fc1, FootballClub fc2){
            if (fc1.getNumberOfGoalsScored()> fc2.getNumberOfGoalsScored())
                return -1;
            else if (fc1.getNumberOfGoalsScored()<fc2.getNumberOfGoalsScored())
                return 1;
            else{
                return 0;
            }

        }
    }
    //logic for sorting the table by wins
    static class sortByWins implements Comparator<FootballClub>{
        @Override
        public  int compare (FootballClub fc1, FootballClub fc2){
            if (fc1.getNumberOfWins()> fc2.getNumberOfWins())
                return -1;
            else if (fc1.getNumberOfWins()<fc2.getNumberOfWins())
                return 1;
            else{
                return 0;
            }

        }
    }

    //logic for sorting matches in date order
    static class sortMatch implements Comparator<NewMatch>{
        @Override
        public int compare(NewMatch m1,NewMatch m2){
            //dividing the returned data in o month,year and day
            String divider="/";
            String[] date1;
            date1=m1.getDate1().split(divider);
            String[] date2;
            date2=m2.getDate1().split(divider);
            //System.out.println(d2);
//coparing the dates with one another and ordeing
            if (Integer.parseInt(date1[2])>Integer.parseInt(date2[2]))
                return -1;
            else if (Integer.parseInt(date1[2])<Integer.parseInt(date2[2]))
                return 1;
            else {
                if (Integer.parseInt(date1[1])>Integer.parseInt(date2[1]))
                    return -1;
                else if (Integer.parseInt(date1[1])<Integer.parseInt(date2[1]))
                    return 1;
                else {
                    if (Integer.parseInt(date1[0])>Integer.parseInt(date2[0]))
                        return -1;
                    else if (Integer.parseInt(date1[0])<Integer.parseInt(date2[0]))
                        return 1;
                    else
                        return 0;

                }
            }
        }
    }

}


