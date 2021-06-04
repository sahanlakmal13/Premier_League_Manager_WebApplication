package controllers;

import OOP.Date;
import OOP.FootballClub;
import OOP.Match;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import java.io.*;
import java.util.ArrayList;

class AppSummary {
    private String content;

    AppSummary(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class HomeController extends Controller {

    public Result appSummary() {
        JsonNode jsonNode = Json.toJson(new AppSummary("Premier League Season 2019/20 - Club Details"));
        return ok(jsonNode).as("application/json");
    }

    public Result postTest() {
        JsonNode jsonNode = Json.toJson(new AppSummary("okay"));
        return ok(jsonNode).as("application/json");
    }
    public Result getFootballClubs() throws IOException {

        ArrayList<FootballClub> w1790286ClubArrayList = new ArrayList<>();

        FileInputStream fInStream = new FileInputStream("../Premier_League_Data.txt");
        ObjectInputStream oInStream = new ObjectInputStream(fInStream);

        for (;;){
            try {
                FootballClub sClub = (FootballClub) oInStream.readObject();
                w1790286ClubArrayList.add(sClub);
            }

            catch (EOFException | ClassNotFoundException e){
                System.out.println("\nPremier league data loaded successfully");
                break;
            }
        }

        fInStream.close();
        oInStream.close();

        JsonNode jsonNode = Json.toJson(w1790286ClubArrayList);
        return ok(jsonNode).as("application/json");

    }

    public Result generateMatch() throws IOException {

        ArrayList<Match> w1790286MatchArrayList = new ArrayList<Match>();

        FileInputStream fInStream = new FileInputStream("../Match_Data.txt");
        ObjectInputStream oInStream = new ObjectInputStream(fInStream);

        for (;;){
            try {
                Match match = (Match) oInStream.readObject();
                w1790286MatchArrayList.add(match);
            }

            catch (EOFException | ClassNotFoundException e){
                System.out.println("\nPremier league data loaded successfully");
                break;
            }
        }

        fInStream.close();
        oInStream.close();
        JsonNode jsonNode = Json.toJson(w1790286MatchArrayList);
        return ok(jsonNode).as("application/json");
    }
}
