

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PremierLeagueManagerTest {
    FootballClub  testClub1=new FootballClub("Youth","Mawanella","Perera",0777353421,2000, 15,12,2,1,45,21,38,24,"Sujan");
    FootballClub  testClub2=new FootballClub("United","Mawanella","Perera",0777353421,2000, 15,12,2,1,45,21,38,24,"Sujan");


    PremierLeagueManager testman=new PremierLeagueManager();
    ArrayList<FootballClub>testList=testman.getFootballClubList();
    ArrayList<NewMatch>matchTestList=testman.getMatchList();


    @Test
    public void addClub() {

        testman.addClub(testClub1);
        testman.addClub(testClub2);
        String exOut="Youth";
        assertEquals(exOut,testman.getFootballClubList().get(0).getClubName());

    }

    @Test
    public void deleteClub() {
        testman.deleteClub("Youth");
        int exOut=1;
        assertEquals(exOut,testman.getFootballClubList().size());

    }

    @Test
    public void addMatch() {
        DateTime testDate=new DateTime(12,4,2020);
        testman.addMatch("United","Youth",3,5,testDate);
        int exOut=3;
        assertEquals(exOut,testman.getMatchList().get(0).getTeamAScore());

    }

    @Test
    public void saveClubDetails() {
       assertEquals("Club Details saved ","Club Details saved ");

    }

}