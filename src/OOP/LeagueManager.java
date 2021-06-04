package OOP;

import java.io.IOException;

public interface LeagueManager {

    public void createClub(FootballClub footballClub);

    public void deleteClub(String clubName);

    public void displayStatistics(String clubName);

    public void displayTable();

    public void printRow();

    public void addMatch(Match match);

    public boolean matchUpdate(FootballClub club, int matchDifference);

    public void saveAll() throws IOException;

    public void loadAll() throws IOException, ClassNotFoundException;

}
