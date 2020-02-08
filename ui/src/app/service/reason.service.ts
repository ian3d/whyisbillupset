import { Injectable } from '@angular/core';
import { Reason } from '../model/reason';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReasonService {

  private reasonUrl = 'http://localhost:8080/reason';
  reason: Reason;

  constructor(private http: HttpClient) { }

  getReason(): Observable<Reason> {
    return this.http.get<Reason>(this.reasonUrl)
      .pipe(
        catchError(this.handleError<Reason>(
          new Reason({text: "Now I'm upset at the developer of this app.  It looks like the application's backend is having issues at the moment."})))
      );
  }

  private handleError<T>(result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    }
  }
}
