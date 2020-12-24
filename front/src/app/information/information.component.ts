import {Component, Input, OnInit} from '@angular/core';
import {Scouts} from '../data-state.service';
import {EmuGroup} from '../data-state.service';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit {
  @Input() scouts: Scouts[];
  @Input() emuGroups: EmuGroup[];
  squareNumber = 0;

  constructor() { }

  ngOnInit(): void {
    const elements = document.getElementsByTagName('li');
    setTimeout(
      () => {
        while (elements.length > 0) {
          elements[0].remove();    // TODO: Удали потом
        }
        const elemScout = document.getElementById('scoutsBody');
        const elemEmuGroup =  document.getElementById('emuBody');
        for (let i = 0; i < this.scouts.length; i++) {
          const liElemScout = document.createElement('li');
          liElemScout.innerText = this.scouts[i].scoutName + ' (' + this.scouts[i].dataCount + ')';
          elemScout.append(liElemScout);
        }
        for (let i = 0; i < this.emuGroups.length; i++){
          const liElemEmuGroup = document.createElement('li');
          liElemEmuGroup.innerText = 'Группа №' + this.emuGroups[i].emuGroupNumber + ' (' + this.emuGroups[i].countEmuInGroup + ' штук)';
          elemEmuGroup.append(liElemEmuGroup);
        }
      }, 1000
    );
  }

}
