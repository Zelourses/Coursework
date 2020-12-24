import {Component, Input, OnInit} from '@angular/core';
import {Card} from '../data-state.service';


@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {
  @Input() cards: Card[];

  constructor() { }

  ngOnInit(): void {
  }

}
