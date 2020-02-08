import { Component, OnInit } from '@angular/core';
import { ReasonService } from '../service/reason.service';
import { Reason } from '../model/reason';
import { ReactionService } from '../service/reaction.service';
import { Reaction } from '../model/reaction';


@Component({
  selector: 'app-reason',
  templateUrl: './reason.component.html',
  styleUrls: ['./reason.component.css']
})
export class ReasonComponent implements OnInit {
  reason: Reason;
  reaction: Reaction;

  constructor(private reasonService: ReasonService, private reactionService: ReactionService) { }

  ngOnInit() {
  }

  getReason(): void {
    this.reasonService.getReason()
      .subscribe(reason => this.reason = reason);
    this.reaction = null;
  }

  reactToReason(liked: boolean): void {
    if(!this.reaction) {
      this.reactionService.addReaction(this.reason.id, liked)
        .subscribe(reaction => this.reaction = reaction);
    }
  }
}
