import {Component, Input, OnInit} from '@angular/core';
import {Solder} from '../data-state.service';

@Component({
  selector: 'app-solder',
  templateUrl: './solder.component.html',
  styleUrls: ['./solder.component.css']
})
export class SolderComponent implements OnInit {
  @Input() solder: Solder;
  @Input() solderNumber: number;

  constructor() { }

  ngOnInit(): void {
  }

  removeSolder(event: any): void{
    console.log(event.target);
  }
}
