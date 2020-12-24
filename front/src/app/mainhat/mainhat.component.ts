import { Component, OnInit } from '@angular/core';
import {DataStateService} from '../data-state.service';

@Component({
  selector: 'app-mainhat',
  templateUrl: './mainhat.component.html',
  styleUrls: ['./mainhat.component.css']
})
export class MainhatComponent implements OnInit {

  constructor(private srv: DataStateService) { }

  ngOnInit(): void {
  }

  test(event: any): void {
    console.log(this.srv.test());
  }
}
