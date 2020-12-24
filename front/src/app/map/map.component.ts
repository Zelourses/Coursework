import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit{
  selectedSquare = -1;

  ngOnInit(): void {
    setTimeout( () => {
      const elem = document.getElementById('tableMap');
      const masTd = elem.getElementsByTagName('td');
      for (let i = 0; i < 64; i++){
         masTd[i].setAttribute('data-index-number', String(i));
         masTd[i].onclick = () => {
           if (this.selectedSquare !== i) {
             if (-1 !== this.selectedSquare){
               masTd[this.selectedSquare].style.background = 'rgba(255, 255, 255, 0)';
             }
             this.selectedSquare = i;
             masTd[this.selectedSquare].style.background = 'rgba(255, 255, 255, 0.5)';
           }
         };
      }
    }, 1000 );
  }
}
