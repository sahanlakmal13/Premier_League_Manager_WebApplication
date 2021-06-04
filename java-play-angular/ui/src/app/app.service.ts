import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

@Injectable()
export class AppService {
  private serviceUrl = '/api/summary';
  private dataPostTestUrl = '/api/postTest';
  private footballUrl = '/api/footballclubs';
  private matchlUrl = '/api/generatematch';

  constructor(private http: HttpClient) {
  }

  public getFootBallClubs(){
    return this.http.get(this.footballUrl);
  }

  public getMatches(){
    return this.http.get(this.matchlUrl);
  }

  public getWelcomeMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }
 
  public sendData(): Observable<any> {
    return this.http.post(this.dataPostTestUrl, {});
  }
}
