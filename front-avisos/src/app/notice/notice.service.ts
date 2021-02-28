import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { Notice } from './notice';


@Injectable({
  providedIn: 'root'
})
export class NoticeService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  private URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  createNotice(notice: Notice) : Promise<Notice> {
    return this.http.post(this.URL + "/notices",JSON.stringify(notice), {headers: this.headers})
      .toPromise()
      .then(res => {
        if (res) {return notice;} else {return null;}
      })
      .catch(this.handleError);
  }

  getNotices(){
    return this.http.get(this.URL + "/notices");
  }

  update(notice: Notice): Promise<Notice> {
    return this.http.put(this.URL + "/notices/" + notice.id,JSON.stringify(notice), {headers: this.headers})
      .toPromise()
      .then(res => {
        if (res) {return notice;} else {return null;}
      })
      .catch(this.handleError);
  }

  deleteNotice(noticeId : number){
    console.log("entered")
    return this.http.delete(this.URL + "/notices/" + noticeId, {headers: this.headers})
      .toPromise().then();
  }




  private handleError(err: any): Promise<any>{
    console.error(err);
    return Promise.reject(err.message || err);
  }
}
