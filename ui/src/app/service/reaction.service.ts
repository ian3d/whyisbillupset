import { Injectable } from '@angular/core';
import { Reaction } from '../model/reaction';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReactionService {

  private reactionUrl = 'http://localhost:8080/reaction/add';

  constructor(private http: HttpClient) { }

  addReaction(reasonId: string, liked: boolean) {
    const reaction = new Reaction();
    reaction.reasonId = reasonId;
    reaction.liked = liked;

    return this.http.post<Reaction>(this.reactionUrl, reaction)
      .pipe();
  }


  private handleError<T>(result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    }
  }
}
