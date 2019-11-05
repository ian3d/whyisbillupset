import { Component, OnInit } from '@angular/core';
import { ReasonService } from '../reason.service';
import { Reason } from '../reason';

@Component({
  selector: 'app-reason',
  templateUrl: './reason.component.html',
  styleUrls: ['./reason.component.css']
})
export class ReasonComponent implements OnInit {
  reason: Reason;
  constructor(private reasonService: ReasonService) { }

  ngOnInit() {
  }

  getReason(): void {
    this.reasonService.getReason()
      .subscribe(reason => this.reason = reason);
  }
}
