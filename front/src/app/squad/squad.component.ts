import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Squad} from '../data-state.service';


@Component({
  selector: 'app-squad',
  templateUrl: './squad.component.html',
  styleUrls: ['./squad.component.css']
})
export class SquadComponent implements OnInit {
  @Input() squad: Squad;
  @Input() squadNumber: number;
  @Output() newItemEvent = new EventEmitter<number>();
  @Output() newItemEvent3 = new EventEmitter<number>();
  hidden = false;
  showInPut = false;
  arrow = '\\/';
  addSymbol = '+';
  solderName = '';
  solderWeapon = '';
  solderKill = '';
  constructor() { }

  ngOnInit(): void {
  }

  hideSolders(): void {
    if (this.hidden){
      this.arrow = '\\/';
    } else {
      this.arrow = '/\\';
    }
    this.hidden = ! this.hidden;
  }

  showInputField(): void{
    if (this.showInPut){
      this.addSymbol = '+';
    } else {
      this.addSymbol = '-';
    }
    this.showInPut = !this.showInPut;
  }

  removeItem(value: number): void {
    this.newItemEvent3.emit(value);
  }

  addSolder(): void {
    this.solderName = '';
    this.solderWeapon = '';
    this.solderKill = '';
  }
}
