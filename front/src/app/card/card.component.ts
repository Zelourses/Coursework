import { Component, OnInit, Input } from '@angular/core';
import {Card} from '../data-state.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input() card: Card;
  title = 'My Card Title';
  message = 'My sample text lwdsfdsfdsfds dsfds sdfdns sdfjs dfjsdf jdsf';

  constructor() { }

  ngOnInit(): void {
  }

}
