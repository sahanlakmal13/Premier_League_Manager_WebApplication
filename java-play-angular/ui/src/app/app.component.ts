import { MatchDate } from './classes/matchDate';
import { FootBallClub } from './classes/football';
import { Component } from '@angular/core';

import { AppService } from './app.service';
import { Match } from './classes/match';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title: string;
  postRequestResponse: string;

  w1790286FootBallClub1 : FootBallClub;
  w1790286FootBallClub2 : FootBallClub;
  w1790286FootBallClub2Check : FootBallClub;
  w1790286MatchList : Match[];
  w1790286FootBallClubList : FootBallClub[];
  w1790286Ranclub1Name : string;
  w1790286Ranclub1Score : number;
  w1790286Ranclub2Name : string;
  w1790286Ranclub2Score : number;
  w1790286RanmatchDate : MatchDate;
  w1790286SearchMatchListFinal: Match[] = [];

  constructor(private appService: AppService) {

    this.appService.getFootBallClubs().subscribe((data:any) => {
      this.w1790286FootBallClubList = data;
      this.sortByPoints();
    });

    this.appService.getMatches().subscribe((data:any) => {

      this.w1790286MatchList = data;
      this.sortMatchByDate();   
    });

    this.appService.getWelcomeMessage().subscribe((data: any) => {
      this.title = data.content;
    });
  }

  public postData(): void {
    this.appService.sendData().subscribe((data: any) => {
      this.postRequestResponse = data.content;
      
    });
  }

  public sortMatchByDate() {
    this.w1790286MatchList = this.w1790286MatchList.sort((o1, o2) => o1.w1790286MatchDate.w1790286Year - o2.w1790286MatchDate.w1790286Year || o1.w1790286MatchDate.w1790286Month - o2.w1790286MatchDate.w1790286Month || o1.w1790286MatchDate.w1790286Day - o2.w1790286MatchDate.w1790286Day)
  }

  public sortByPoints() {
    this.w1790286FootBallClubList = this.w1790286FootBallClubList.sort((o1, o2) => o2.w1790286ClubPoints - o1.w1790286ClubPoints || o2.w1790286GoalDifference - o1.w1790286GoalDifference);
  }

  public sortByScoredGoals() {
    this.w1790286FootBallClubList = this.w1790286FootBallClubList.sort((o1, o2) => o2.w1790286ScoredGoals - o1.w1790286ScoredGoals);
  }

  public sortByWins() {
    this.w1790286FootBallClubList = this.w1790286FootBallClubList.sort((o1, o2) => o2.w1790286Wins - o1.w1790286Wins);
  }

  public generateMatch() {

    this.w1790286FootBallClub1 = this.w1790286FootBallClubList[Math.floor(Math.random() * this.w1790286FootBallClubList.length)];
    this.w1790286FootBallClub2Check = this.w1790286FootBallClubList[Math.floor(Math.random() * this.w1790286FootBallClubList.length)];
    
    while(this.w1790286FootBallClub1 == this.w1790286FootBallClub2Check){
      this.w1790286FootBallClub2Check = this.w1790286FootBallClubList[Math.floor(Math.random() * this.w1790286FootBallClubList.length)];
    }

    this.w1790286FootBallClub2 = this.w1790286FootBallClub2Check;

    var w1790286RanDate : MatchDate = new MatchDate();
    var w1790286RanMatch : Match = new Match();
    var w1790286RanyearCheck : number;

    w1790286RanMatch.w1790286Club1Name=this.w1790286FootBallClub1.w1790286ClubName;
    w1790286RanMatch.w1790286Club2Name=this.w1790286FootBallClub2.w1790286ClubName;
    w1790286RanMatch.w1790286Club1Score=Math.floor(Math.random() * 5);
    w1790286RanMatch.w1790286Club2Score=Math.floor(Math.random() * 5);

    w1790286RanDate.w1790286Day=Math.floor(Math.random() * 31)+1;
    w1790286RanDate.w1790286Month=Math.floor(Math.random() * 12)+1;
    w1790286RanyearCheck=Math.floor(Math.random() * 2)+1;
    console.log(w1790286RanyearCheck);

    if(w1790286RanyearCheck == 1){
      w1790286RanDate.w1790286Year = 2019;
    }
    if(w1790286RanyearCheck == 2){
      w1790286RanDate.w1790286Year = 2020;
    }

    w1790286RanMatch.w1790286MatchDate=w1790286RanDate;

    this.w1790286MatchList.push(w1790286RanMatch)

    this.w1790286Ranclub1Name=this.w1790286FootBallClub1.w1790286ClubName;
    this.w1790286Ranclub2Name=this.w1790286FootBallClub2.w1790286ClubName;
    this.w1790286Ranclub1Score=w1790286RanMatch.w1790286Club1Score;
    this.w1790286Ranclub2Score=w1790286RanMatch.w1790286Club2Score;
    this.w1790286RanmatchDate=w1790286RanMatch.w1790286MatchDate;

    this.w1790286FootBallClub1.w1790286NumOfPlayedMatches += 1;
    this.w1790286FootBallClub2.w1790286NumOfPlayedMatches += 1;

    if(w1790286RanMatch.w1790286Club1Score > w1790286RanMatch.w1790286Club2Score){
      this.w1790286FootBallClub1.w1790286Wins += 1;
      this.w1790286FootBallClub2.w1790286Defeats += 1;
      this.w1790286FootBallClub1.w1790286ScoredGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub1.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ScoredGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub1.w1790286ClubPoints += 3
      this.w1790286FootBallClub1.w1790286GoalDifference += this.w1790286FootBallClub1.w1790286ScoredGoals-this.w1790286FootBallClub1.w1790286ReceivedGoals;
      this.w1790286FootBallClub2.w1790286GoalDifference += this.w1790286FootBallClub2.w1790286ScoredGoals-this.w1790286FootBallClub2.w1790286ReceivedGoals;
    }
    else if(w1790286RanMatch.w1790286Club1Score < w1790286RanMatch.w1790286Club2Score){
      this.w1790286FootBallClub1.w1790286Defeats += 1;
      this.w1790286FootBallClub2.w1790286Wins += 1;
      this.w1790286FootBallClub1.w1790286ScoredGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub1.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ScoredGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub2.w1790286ClubPoints += 3
      this.w1790286FootBallClub1.w1790286GoalDifference += this.w1790286FootBallClub1.w1790286ScoredGoals-this.w1790286FootBallClub1.w1790286ReceivedGoals;
      this.w1790286FootBallClub2.w1790286GoalDifference += this.w1790286FootBallClub2.w1790286ScoredGoals-this.w1790286FootBallClub2.w1790286ReceivedGoals;
    }
    else{
      this.w1790286FootBallClub1.w1790286Draws += 1;
      this.w1790286FootBallClub2.w1790286Draws += 1;
      this.w1790286FootBallClub1.w1790286ScoredGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub1.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ScoredGoals += w1790286RanMatch.w1790286Club2Score;
      this.w1790286FootBallClub2.w1790286ReceivedGoals += w1790286RanMatch.w1790286Club1Score;
      this.w1790286FootBallClub2.w1790286ClubPoints += 1
      this.w1790286FootBallClub1.w1790286GoalDifference += this.w1790286FootBallClub1.w1790286ScoredGoals-this.w1790286FootBallClub1.w1790286ReceivedGoals;
      this.w1790286FootBallClub2.w1790286GoalDifference += this.w1790286FootBallClub2.w1790286ScoredGoals-this.w1790286FootBallClub2.w1790286ReceivedGoals;
    }
    this.sortByPoints();
  }

  searchByDate(){

    this.w1790286SearchMatchListFinal = [];

    var w1790286SelectedDay = parseInt((document.getElementById("searchDate") as HTMLInputElement).value);
    var w1790286SelectedMonth = parseInt((document.getElementById("searchMonth") as HTMLInputElement).value);
    var w1790286SelectedYear = parseInt((document.getElementById("searchYear") as HTMLInputElement).value);

    let searchw1790286MatchList: Match[] = [];

    for(var match of this.w1790286MatchList){
      if(w1790286SelectedYear==match.w1790286MatchDate.w1790286Year && w1790286SelectedMonth==match.w1790286MatchDate.w1790286Month && w1790286SelectedDay==match.w1790286MatchDate.w1790286Day ){
        
        var searchMatch : Match = new Match();
        var searchMatchDate : MatchDate = new MatchDate();

        searchMatch.w1790286Club1Name = match.w1790286Club1Name;
        searchMatch.w1790286Club1Score = match.w1790286Club1Score;
        searchMatch.w1790286Club2Name = match.w1790286Club2Name;
        searchMatch.w1790286Club2Score = match.w1790286Club2Score;

        searchMatchDate.w1790286Day = match.w1790286MatchDate.w1790286Day;
        searchMatchDate.w1790286Month = match.w1790286MatchDate.w1790286Month;
        searchMatchDate.w1790286Year = match.w1790286MatchDate.w1790286Year;

        searchMatch.w1790286MatchDate = searchMatchDate;

        searchw1790286MatchList.push(searchMatch);

      }
    }
    for(var match1 of searchw1790286MatchList){
      this.w1790286SearchMatchListFinal.push(match1);
    }
  }

}
