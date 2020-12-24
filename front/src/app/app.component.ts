import { Component } from '@angular/core';
import {Card, EmuGroup, Squad, Scouts, DataStateService} from './data-state.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  numberShow = 0;
  index = 0;
  sizeTeam: number;
  cards: Card[];
  squads: Squad[];
  scouts: Scouts[];
  emuGroups: EmuGroup[];

  constructor(dataServ: DataStateService) {
    this.cards = dataServ.getCards();
    this.squads = dataServ.getSquad();
    this.scouts = dataServ.getScouts();
    this.emuGroups = dataServ.getEmuGroups();
    this.sizeTeam = this.squads.length;
  }

  addItem(newItem: number): void {
    alert(newItem);
  }

  removeItem(numberSquad: number): void {
    this.squads.splice(numberSquad, 1);
    this.sizeTeam = this.squads.length;
    // TODO: сообщить серверу
  }
}
