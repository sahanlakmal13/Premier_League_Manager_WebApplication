package OOP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager{

    private static final ArrayList<FootballClub> w1790286ClubArrayList = new ArrayList<>();
    private static final ArrayList<Match> w1790286MatchArrayList = new ArrayList<>();

    private int w1790286MatchCount = 380;

    public static void main(String[] args) {

        PremierLeagueManager pml = new PremierLeagueManager();

        try {
            pml.loadAll();
        }
        catch (Exception e){
            System.out.println("Data loading error, try again!");
        }
        while (true){

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("\n-------------------------------------------------------------------------------------------------------");
            System.out.println("---Welcome to Premier League - Season 2019/20--");
            System.out.println("Clubs can be added with the matches played among them");
            System.out.println("\nPremier League Menu");
            System.out.println("1 - Create a new football club");
            System.out.println("2 - Delete a club");
            System.out.println("3 - Display statistics for a club");
            System.out.println("4 - Display premier league table");
            System.out.println("5 - Add a match");
            System.out.println("6 - Save all data");
            System.out.println("7 - Exit");
            System.out.print("Enter a menu item: ");

            try {
                int menu1 = scanner1.nextInt();
                if (menu1 == 1){
                    System.out.println("\nEnter club details");

                    Scanner scanner3 = new Scanner(System.in);
                    System.out.print("\nEnter club name : ");
                    String clubName = scanner3.nextLine();

                    System.out.print("\nEnter club location : ");
                    String clubLoc = scanner1.next();

                    System.out.print("\nEnter matches won : ");
                    int clubWins = pml.clubDetails();

                    System.out.print("\nEnter matches draw : ");
                    int clubDraws=pml.clubDetails();

                    System.out.print("\nEnter matches lost : ");
                    int clubDefeats=pml.clubDetails();

                    System.out.print("\nEnter club scored goals : ");
                    int clubScoredGoals=pml.clubDetails();

                    System.out.print("\nEnter club received goals : ");
                    int clubReceivedGoals=pml.clubDetails();

                    FootballClub footballClub = new FootballClub(clubName,clubLoc,clubWins,clubDraws,clubDefeats,clubReceivedGoals,clubScoredGoals);
                    pml.createClub(footballClub);
                }

                else if (menu1 == 2){

                    if (w1790286ClubArrayList.size() != 0){
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print("\nEnter club name to delete : ");
                        String clubName = scanner2.nextLine();
                        pml.deleteClub(clubName);
                    }
                    else {
                        System.out.println("Club list is empty. add clubs before deleting!");
                    }
                }

                else if (menu1 == 3){
                    if (w1790286ClubArrayList.size() != 0){
                        System.out.print("\nEnter club name to view statistics : ");
                        Scanner scanner3 = new Scanner(System.in);
                        String clubName = scanner3.nextLine();
                        pml.displayStatistics(clubName);
                    }
                    else {
                        System.out.println("Club list is empty. add a club to view statistics!");
                    }
                }

                else if (menu1 == 4){
                    if (w1790286ClubArrayList.size() != 0){
                        pml.displayTable();
                    }
                    else {
                        System.out.println("\nClub list is empty. add a club to view premier league table!");
                    }
                }
                else if (menu1 == 5){
                    if (pml.w1790286MatchCount != 0){
                        System.out.println("Enter match date");
                        System.out.println("Matches played in season 2019/20 can be added");
                        int day;
                        while (true){
                            System.out.print("Day: ");
                            try {
                                day = scanner1.nextInt();
                                if (day <=0 || day >31){
                                    System.out.println("Invalid day, try again!");
                                    continue;
                                }
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Invalid day, try again!");
                                scanner1.next();
                            }
                        }

                        int month;
                        while (true){
                            System.out.print("Month: ");
                            try {
                                month = scanner1.nextInt();
                                if (month<=0 || month>12){
                                    System.out.println("Invalid month, try again!");
                                    continue;
                                }
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Invalid month, try again!");
                                scanner1.next();
                            }
                        }

                        int year;
                        while (true){
                            System.out.print("Year: ");
                            try {
                                year = scanner1.nextInt();
                                if (year < 2019 || year > 2020 ){
                                    System.out.println("Invalid year, try again!");
                                    continue;
                                }
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Invalid year, try again!");
                                scanner1.next();
                            }
                        }

                        System.out.print("Club 1 Name: ");
                        Scanner scanner3 = new Scanner(System.in);
                        String club1Name = scanner3.nextLine();
                        int score1;
                        while (true){
                            System.out.print("Club 1 Score: ");
                            try {
                                score1 = scanner1.nextInt();
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Invalid score, try again!");
                                scanner1.next();
                            }
                        }
                        System.out.print("Club 2 Name: ");
                        Scanner scanner4 = new Scanner(System.in);
                        String club2Name = scanner4.nextLine();
                        int score2;
                        while (true){
                            System.out.print("Club 2 Score: ");
                            try {
                                score2 = scanner1.nextInt();
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Invalid score, try again!");
                                scanner1.next();
                            }
                        }
                        Date date = new Date(day,month,year);
                        Match match = new Match(date,club1Name,score1,club2Name,score2);
                        pml.addMatch(match);
                    }
                    else {
                        System.out.println("All 380 matches have been played!");
                    }
                }

                else if (menu1 == 6){
                    if (w1790286ClubArrayList.size() != 0){
                        pml.saveAll();
                    }
                    else {
                        System.out.println("Premier league is empty, add data before saving!");
                    }
                }
                else if (menu1 == 7){
                    System.out.println("Exiting Premier league table");
                    break;
                }
                else if (menu1 == 8){
                    pml.clear();
                    break;
                }
                else {
                    System.out.println("Invalid menu item, try again!");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid menu item1, try again!");
                scanner1.next();
            }
        }
    }

    public int clubDetails(){
        Scanner scanner2 = new Scanner(System.in);
        int clubInput = 0;
        while (true){
            try {
                clubInput = scanner2.nextInt();
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input, try again!");
                scanner2.next();
            }
        }
        return clubInput;
    }

    @Override
    public void createClub(FootballClub footballClub) {

        if (w1790286ClubArrayList.size() < 20){
            w1790286ClubArrayList.add(footballClub);
            System.out.println("\n"+footballClub.getW1790286ClubName()+" club is added to the premier league.");
            System.out.println((20- w1790286ClubArrayList.size())+" more clubs can be added to the league.");
        }
        else {
            System.out.println("\nPremier league is full, more clubs cannot be added.");
        }
    }

    @Override
    public void deleteClub(String clubName) {
        boolean clubFlag = true;
        for (FootballClub club : w1790286ClubArrayList){
            if (club.getW1790286ClubName().equals(clubName)){
                w1790286ClubArrayList.remove(club);
                clubFlag = false;
                System.out.println("\n"+clubName + " club is deleted from the premier league..");
                break;
            }
        }
        if (clubFlag){
            System.out.println("\n"+clubName + " club cannot be found the premier league!");
        }
    }

    @Override
    public void displayStatistics(String clubName) {
        boolean clubFlag = true;
        int index=0;
        for (FootballClub club : w1790286ClubArrayList){
            if (club.getW1790286ClubName().equals(clubName)){
                clubFlag = false;
                index = w1790286ClubArrayList.indexOf(club);
                break;
            }
        }
        if (clubFlag){
            System.out.println("\n"+clubName + " club cannot be found the premier league!");
        }
        else {
            System.out.println("\n---Statistics of the "+clubName +" club---\n");
            System.out.println("Club Name                   : "+ w1790286ClubArrayList.get(index).getW1790286ClubName());
            System.out.println("Club Location               : "+ w1790286ClubArrayList.get(index).getW1790286ClubLocation());
            System.out.println("Club Points                 : "+ w1790286ClubArrayList.get(index).getW1790286ClubPoints());
            System.out.println("Total Wins                  : "+ w1790286ClubArrayList.get(index).getW1790286Wins());
            System.out.println("Total Defeats               : "+ w1790286ClubArrayList.get(index).getW1790286Defeats());
            System.out.println("Total Draws                 : "+ w1790286ClubArrayList.get(index).getW1790286Draws());
            System.out.println("Total Matches Played        : "+ w1790286ClubArrayList.get(index).getW1790286NumOfPlayedMatches());
            System.out.println("Total of Scored Goals       : "+ w1790286ClubArrayList.get(index).getW1790286ScoredGoals());
            System.out.println("Total of Received Goals     : "+ w1790286ClubArrayList.get(index).getW1790286ReceivedGoals());
            System.out.println("Goal Difference of the club : "+ w1790286ClubArrayList.get(index).getW1790286GoalDifference());
            System.out.println("Goal Average of the club    : "+ w1790286ClubArrayList.get(index).getW1790286GoalAverage());
        }
    }

    @Override
    public void displayTable() {
        Collections.sort(w1790286ClubArrayList);
        System.out.println("\n---Premier League Table / Club Statistics---");
        printRow();
        System.out.format("%-25s%-15s%13s%10s%10s%13s%10s%10s%13s%10s%10s%n","| Name","| Location","|        MP |",
                "Wins |","Draws |", "Defeats |","GS |","GA |","GAvg |","GD |","Pts |");
        printRow();

        for (FootballClub club : w1790286ClubArrayList){

            if (club.getW1790286ClubName() != null) {
                System.out.format("%-25s%-15s%13s%10s%10s%13s%10s%10s%13s%10s%10s%n", "| " + club.getW1790286ClubName(),
                        "| " + club.getW1790286ClubLocation(), "|        " + club.getW1790286NumOfPlayedMatches() + " |", club.getW1790286Wins() + " |",
                        club.getW1790286Draws() + " |", club.getW1790286Defeats() + " |", club.getW1790286ScoredGoals() + " |", club.getW1790286ReceivedGoals() + " |",
                        club.getW1790286GoalAverage() + " |", club.getW1790286GoalDifference() + " |", club.getW1790286ClubPoints() + " |");
            }
        }
        printRow();
        System.out.println("\nTable Abbreviations:\nMP-Matches Played, GS-Goals Scored, GA-Goals Against/Received," +
                " GAvg-Goal Average, " + "GD-Goal Difference, Pts-Club Points");
    }

    @Override
    public void printRow(){
        int[] colWidth = {25,15,12,10,10,13,10,10,13,10,10};
        System.out.print("+");
        for (int i : colWidth) {

            String line = String.join("", Collections.nCopies(i - 1, "-"));
            System.out.print(line + "+");
        }
        System.out.println();
    }

    @Override
    public void addMatch(Match match) {
        if (w1790286MatchCount != 0){
            w1790286MatchArrayList.add(match);
            w1790286MatchCount--;
            boolean clubFlag = true;
            for (FootballClub club : w1790286ClubArrayList) {
                    if (club.getW1790286ClubName().equals(match.getW1790286Club1Name())){

                        club.setW1790286ScoredGoals(club.getW1790286ScoredGoals() + match.getW1790286Club1Score());
                        club.setW1790286ReceivedGoals(club.getW1790286ReceivedGoals() + match.getW1790286Club2Score());
                        club.setW1790286GoalDifference(club.getW1790286ScoredGoals() - club.getW1790286ReceivedGoals());
                        club.setW1790286GoalAverage(club.getW1790286ScoredGoals() + 0.0 / club.getW1790286ReceivedGoals());
                        int matchDifference = match.getW1790286Club1Score() - match.getW1790286Club2Score();
                        clubFlag = matchUpdate(club,matchDifference);
                    }

                    else if (club.getW1790286ClubName().equals(match.getW1790286Club2Name())) {

                        club.setW1790286ScoredGoals(club.getW1790286ScoredGoals() + match.getW1790286Club2Score());
                        club.setW1790286ReceivedGoals(club.getW1790286ReceivedGoals() + match.getW1790286Club1Score());
                        club.setW1790286GoalDifference(club.getW1790286ScoredGoals() - club.getW1790286ReceivedGoals());
                        club.setW1790286GoalAverage(club.getW1790286ScoredGoals() + 0.0 / club.getW1790286ReceivedGoals());
                        int matchDifference = match.getW1790286Club2Score() - match.getW1790286Club1Score();
                        clubFlag = matchUpdate(club,matchDifference);
                    }
            }
            if (clubFlag){
                System.out.println("\nPremier league table is not updated, try again with existing clubs!");
            }
            else {
                System.out.println("\nPremier league table is updated.");
            }
        }
        else {
            System.out.println("\nAll the matches have been played, table cannot be updated");
        }
    }

    @Override
    public boolean matchUpdate(FootballClub club, int matchDifference) {

        if (matchDifference > 0){
            club.setW1790286Wins(club.getW1790286Wins()+1);
            club.setW1790286ClubPoints(club.getW1790286ClubPoints()+3);
        }
        else if (matchDifference < 0){
            club.setW1790286Defeats(club.getW1790286Defeats()+1);
        }
        else {
            club.setW1790286Draws(club.getW1790286Draws()+1);
            club.setW1790286ClubPoints(club.getW1790286ClubPoints()+1);
        }
        club.setW1790286NumOfPlayedMatches(club.getW1790286NumOfPlayedMatches()+1);

        return false;
    }

    @Override
    public void saveAll() throws IOException {

        FileOutputStream fOutStream1 = new FileOutputStream("Premier_League_Data.txt");
        ObjectOutputStream oOutStream1 = new ObjectOutputStream(fOutStream1);

        for (FootballClub club : w1790286ClubArrayList){
            oOutStream1.writeObject(club);
        }

        oOutStream1.flush();
        fOutStream1.close();
        oOutStream1.close();

        FileOutputStream fOutStream2 = new FileOutputStream("Match_Data.txt");
        ObjectOutputStream oOutStream2 = new ObjectOutputStream(fOutStream2);

        for (Match match : w1790286MatchArrayList){
            oOutStream2.writeObject(match);
        }

        oOutStream2.flush();
        fOutStream2.close();
        oOutStream2.close();

        System.out.println("\nData saved successfully");
    }

    public void clear() throws IOException {

        FileOutputStream fOutStream = new FileOutputStream("Premier_League_Data.txt");
        ObjectOutputStream oOutStream = new ObjectOutputStream(fOutStream);
        oOutStream.flush();
        fOutStream.close();
        oOutStream.close();

        FileOutputStream fOutStream2 = new FileOutputStream("Match_Data.txt");
        ObjectOutputStream oOutStream2 = new ObjectOutputStream(fOutStream2);
        oOutStream2.flush();
        fOutStream2.close();
        oOutStream2.close();

        System.out.println("\nPremier league data cleared successfully");
    }

    @Override
    public void loadAll() throws IOException, ClassNotFoundException {

        FileInputStream fInStream1 = new FileInputStream("Premier_League_Data.txt");
        ObjectInputStream oInStream1 = new ObjectInputStream(fInStream1);

        for (;;){

            try {
                FootballClub sClub = (FootballClub) oInStream1.readObject();
                w1790286ClubArrayList.add(sClub);
            }

            catch (EOFException e){
                break;
            }
        }

        fInStream1.close();
        oInStream1.close();

        FileInputStream fInStream2 = new FileInputStream("Match_Data.txt");
        ObjectInputStream oInStream2 = new ObjectInputStream(fInStream2);

        for (;;){

            try {
                Match match = (Match) oInStream2.readObject();
                w1790286MatchArrayList.add(match);
            }

            catch (EOFException e){
                System.out.println("\nSaved data loaded successfully");
                break;
            }
        }

        fInStream2.close();
        oInStream2.close();
    }
}
