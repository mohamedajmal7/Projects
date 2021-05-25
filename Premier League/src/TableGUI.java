import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TableGUI {
    private final static PremierLeagueManager manager2=new PremierLeagueManager();
    private final static ConsoleUI consoleMan=new ConsoleUI();
    public static void gui() {

        Stage window=new Stage();
        window.setTitle("Premier League");
        Label lb1 = new Label("Standings");
        lb1.setLayoutX(350);
        lb1.setLayoutY(20);
        Label lbl3=new Label();
        Label lbl4=new Label();
        Label lbl5=new Label();
        Label lbl6=new Label();
        Label lbl7=new Label();
        Pane root4 = new Pane();

        ArrayList<FootballClub> footballClubs=manager2.getFootballClubList();
        Collections.sort(footballClubs, new PremierLeagueManager.PointsSorting());
        final TableView<TableDetails>[]table= new TableView[]{tableView(footballClubs)};
        lb1.setStyle("-fx-font-family:\"Radikal Bold\"; -fx-text-alignment:\"center\"; " +
                "-fx-font-size:34; -fx-pref-height:150;  -fx-pref-width: 450; -fx-text-fill: white;" +
                "-fx-font-weight: bold");
        Pane root = new Pane();

        Image image = new Image("file:g60282ki001i001.gif");
        ImageView ms=new ImageView(image);
        ms.setFitWidth(630);
        ms.setFitHeight(650);

        Button exitBtn=new Button("Exit");
        exitBtn.setLayoutX(485);
        exitBtn.setLayoutY(310);
        exitBtn.setMinWidth(100);
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                consoleMan.displayMenu();
            }
        });

        Button goalSortBtn=new Button("Sort By Goals");
        goalSortBtn.setLayoutX(485);
        goalSortBtn.setLayoutY(160);
        goalSortBtn.setMinWidth(100);
        goalSortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                ArrayList<FootballClub> footballClubs=manager2.getFootballClubList();
                Collections.sort(footballClubs,new PremierLeagueManager.sortByGoals());
                TableView<TableDetails> tablew=tableView(footballClubs);
                root.getChildren().addAll(tablew);
            }
        });

        Button pointSortBtn=new Button("Sort By Points");
        pointSortBtn.setLayoutX(485);
        pointSortBtn.setLayoutY(190);
        pointSortBtn.setMinWidth(100);
        pointSortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                ArrayList<FootballClub> footballClubs=manager2.getFootballClubList();
                Collections.sort(footballClubs,new PremierLeagueManager.PointsSorting());
                TableView<TableDetails> table8=tableView(footballClubs);
                root.getChildren().addAll(table8);
            }
        });

        goalSortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                ArrayList<FootballClub> footballClubs=manager2.getFootballClubList();
                Collections.sort(footballClubs,new PremierLeagueManager.sortByGoals());
                TableView<TableDetails> table2=tableView(footballClubs);
                root.getChildren().addAll(table2);
            }
        });

        Button winSortBtn=new Button("Sort By Wins");
        winSortBtn.setLayoutX(485);
        winSortBtn.setLayoutY(220);
        winSortBtn.setMinWidth(100);

        winSortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                ArrayList<FootballClub>footballClubs=manager2.getFootballClubList();
                Collections.sort(footballClubs,new PremierLeagueManager.sortByWins());
                TableView<TableDetails>table3=tableView(footballClubs);
                root.getChildren().addAll(table3);
            }
        });

        Button matchSortBtn=new Button("Played Matches");
        matchSortBtn.setLayoutX(485);
        matchSortBtn.setLayoutY(250);
        matchSortBtn.setMinWidth(100);
        matchSortBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                ArrayList<NewMatch> matchList=manager2.getMatchList();
                Collections.sort(matchList, new PremierLeagueManager.sortMatch());
                final TableView<NewMatch>[]table10= new TableView[]{matchTableView(matchList)};
                root.getChildren().addAll(table10);
            }
        });

        Button matchingBtn=new Button("New Match");
        matchingBtn.setLayoutX(485);
        matchingBtn.setLayoutY(280);
        matchingBtn.setMinWidth(100);

        matchingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Random randomGenerator;
                randomGenerator = new Random();
                ArrayList<NewMatch>match=manager2.getMatchList();
                System.out.println(match);
                ArrayList<FootballClub>footballClubs=manager2.getFootballClubList();
                FootballClub fc1=anyItem();
                FootballClub fc2=anyItem();
                DateTime ranDate=new DateTime();
                while (fc1.getClubName()==fc2.getClubName()){
                    fc1=anyItem();
                    fc2=anyItem();
                }
                int rand_int1 = randomGenerator.nextInt(10);
                int rand_int2 = randomGenerator.nextInt(10);

                int year = (int)(21.0* Math.random()+2000);
                ranDate.setYear(year);

                int month = (int)(12.0* Math.random()+1);
                ranDate.setMonth(month);

                if (month==2){
                    int day=(int)(28.0* Math.random()+1);
                    ranDate.setDay(day);
                }else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                    int day=(int)(31.0* Math.random()+1);
                    ranDate.setDay(day);
                }else {
                    int day=(int)(30.0* Math.random()+1);
                    ranDate.setDay(day);
                }

                manager2.addMatch(fc1.getClubName(),fc2.getClubName(),rand_int1,rand_int2,ranDate);
                manager2.saveClubDetails();
                manager2.saveMatches();

                lbl3.setText("New Match added successfully");
                lbl4.setText(fc1.getClubName()+" "+rand_int1+" -"+" "+rand_int2+" "+fc2.getClubName());
                lbl3.setStyle("-fx-font-weight: bold;-fx-text-fill: white;-fx-font-size: 20");
                lbl4.setStyle("-fx-font-weight: bold; -fx-text-fill: white;-fx-font-size: 20");

                lbl3.setLayoutX(50);
                lbl3.setLayoutY(580);
                lbl4.setLayoutX(100);
                lbl4.setLayoutY(600);

                ArrayList<FootballClub>footballClubs2=manager2.getFootballClubList();
                Collections.sort(footballClubs2,new PremierLeagueManager.PointsSorting());
                TableView<TableDetails>tabler=tableView(footballClubs2);
            }

            public int getRandomDay(int min,int max) {
                Random random = new Random();
                return random.nextInt();
            }

            public FootballClub anyItem()
            {
                Random randomGenerator1;
                randomGenerator1 = new Random();
                int index = randomGenerator1.nextInt(footballClubs.size());
                FootballClub item = footballClubs.get(index);
                return item;
            }
        });

        final TextField yrTxt = new TextField("");
        yrTxt.setPromptText("d/m/yyyy");
        yrTxt.setPrefWidth(100);
        yrTxt.setLayoutX(485);
        yrTxt.setLayoutY(370);

        Label label1=new Label();
        label1.setLayoutX(50);
        label1.setLayoutY(580);
        label1.setStyle("-fx-font-weight: bold;-fx-text-fill: white;-fx-font-size: 20");
        label1.setStyle("-fx-font-weight: bold; -fx-text-fill: white;-fx-font-size: 20");

        Button search=new Button("Search");
        search.setLayoutX(485);
        search.setLayoutY(400);
        search.setMinWidth(100);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl3.setText("");
                lbl4.setText("");
                String date=yrTxt.getText();

                ArrayList<NewMatch> matches=manager2.getMatchList();
                boolean found=false;
                for (NewMatch match: matches){
                    if (date.equals(match.getDate1())){
                        ArrayList<NewMatch> dateMatch=new ArrayList<>();
                        dateMatch.add(match);
                        final TableView<NewMatch>[]table12= new TableView[]{matchTableView(dateMatch)};
                        lbl3.setText("These are the matches played on the date : "+date);
                        root.getChildren().addAll(table12);
                        found=true;
                    }
                }
                if (!found){
                    lbl3.setText("Sorry! No matches were played on the date  : "+date);
                }
            }

        });

        root.getChildren().addAll(ms,table[0],yrTxt,search,goalSortBtn,pointSortBtn,winSortBtn,matchingBtn,
                matchSortBtn,exitBtn,lbl5,lbl6,lbl7,lbl3,lb1,lbl4,label1);
        Scene scene = new Scene(root, 630, 650);
        window.setTitle("");
        window.setScene(scene);
        window.show();
    }

    public static TableView <TableDetails> tableView(ArrayList<FootballClub>footballClubs){
        TableView<TableDetails>table =new TableView<>();
        ObservableList <TableDetails> data=FXCollections.observableArrayList();

        TableColumn clubName = new TableColumn<>("Club Name");
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        clubName.setMaxWidth(210);

        TableColumn matchesPlayed = new TableColumn<>("MP");
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));
        matchesPlayed.setMaxWidth(40);

        TableColumn wins = new TableColumn<>("W");
        wins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));
        wins.setMaxWidth(40);

        TableColumn draw = new TableColumn<>("D");
        draw.setCellValueFactory(new PropertyValueFactory<>("numberOfDraws"));
        draw.setMaxWidth(40);

        TableColumn loss = new TableColumn<>("L");

        loss.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeats"));
        loss.setMaxWidth(40);

        TableColumn points = new TableColumn<>("Pts");

        points.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));
        points.setMaxWidth(40);

        TableColumn goalsScored = new TableColumn<>("GS");

        goalsScored.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));
        goalsScored.setMaxWidth(40);

        TableColumn goalsConceded = new TableColumn<>("GC");

        goalsConceded.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsConceded"));
        goalsConceded.setMaxWidth(40);

        TableColumn goalDif = new TableColumn<>("GD");

        goalDif.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));
        goalDif.setMaxWidth(40);

        table.setItems(data);
        table.getColumns().addAll(clubName,matchesPlayed,wins,draw,loss,points,goalsScored,goalsConceded,goalDif);

        for (FootballClub club: footballClubs) {
            TableDetails addRecord = new TableDetails(club.getClubName(),club.getNumberOfWins(),
                    club.getNumberOfDraws(),club.getNumberOfDefeats(),club.getTotalPoints(),
                    club.getNumberOfMatchesPlayed(),club.getNumberOfGoalsScored(),
                    club.getNumberOfGoalsConceded(),(club.getNumberOfGoalsScored()-club.getNumberOfGoalsConceded()));

            table.getItems().add(addRecord);
            table.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:15;");

            table.setPrefSize(400,420);
            table.setLayoutX(30);
            table.setLayoutY(130);
        }return table;
    }
    public static TableView <NewMatch> matchTableView(ArrayList<NewMatch>matchArrayList){
        TableView<NewMatch>matchTable =new TableView<>();
        ObservableList <NewMatch> data=FXCollections.observableArrayList();

        TableColumn clubName1 = new TableColumn<>("Home Team");
        clubName1.setCellValueFactory(new PropertyValueFactory<>("teamA"));
        clubName1.setMaxWidth(210);

        TableColumn clubName2 = new TableColumn<>("Away Team");
        clubName2.setCellValueFactory(new PropertyValueFactory<>("teamB"));
        clubName2.setMaxWidth(210);

        TableColumn score1 = new TableColumn<>("score");
        score1.setCellValueFactory(new PropertyValueFactory<>("teamAScore"));
        score1.setMaxWidth(210);

        TableColumn score2 = new TableColumn<>("score");
        score2.setCellValueFactory(new PropertyValueFactory<>("teamBScore"));
        score2.setMaxWidth(210);

        TableColumn matchDate = new TableColumn<>("Date");
        matchDate.setCellValueFactory(new PropertyValueFactory<>("date1"));
        matchDate.setMaxWidth(210);

        matchTable.setItems(data);
        matchTable.getColumns().addAll(clubName1,score1,score2,clubName2,matchDate);

        for (NewMatch matches:matchArrayList ){
            NewMatch records=new NewMatch(matches.getTeamA(),matches.getTeamAScore(),matches.getTeamBScore(),
                    matches.getTeamB(),matches.getDate1());
            matchTable.getItems().add(records);
            matchTable.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:15;");

            matchTable.setPrefSize(400,420);
            matchTable.setLayoutX(30);
            matchTable.setLayoutY(130);
        }return matchTable;
    }
}
