import { Injectable } from '@angular/core';

export interface Scouts{
  scoutName: string;
  dataCount: number;
}

export interface EmuGroup {
  emuGroupNumber: number;
  countEmuInGroup: number;
}

export interface Card {
  title: string;
  message: string;
}

export interface Squad {
  emuCounter: number;
  capName: string;
  solders: Solder[];
}

export interface Solder {
  name: string;
  weapon: string;
  kill: number;
}

@Injectable({
  providedIn: 'root'
})
export class DataStateService {

  constructor() { }
  cards: Card[] = [
    {title: 'Title for complain 1', message: 'Ненаввижу Эму'},
    {title: 'Title for complain 2', message: 'Очень сильно ненавижу эму они съели всё, что у меня есть, я возьму двустволу и уничто их сам, если вы не придёте'},
    {title: 'Title for complain 3', message: 'This is last card'},
    {title: 'Title for complain 4', message: 'Я ненавижу этих чёртовых птиц'},
    {title: 'Title for complain 5', message: 'This is last card'}
  ];

  squads: Squad[] = [
    {emuCounter: 20, capName: 'Антон', solders: [
        {name: 'Иван1', weapon: 'Томпсон', kill: 11},
        {name: 'Иван3', weapon: 'Томпсон', kill: 13},
        {name: 'Иван2', weapon: 'Томпсон', kill: 1},
        {name: 'Иван4', weapon: 'Резиновая уточка', kill: 900}
      ]},
    {emuCounter: 10, capName: 'Лёша', solders: [
        {name: 'Серёга1', weapon: 'Томпсон', kill: 11},
        {name: 'Иван2', weapon: 'Томпсон', kill: 13},
        {name: 'Серёга2', weapon: 'Томпсон', kill: 1},
        {name: 'Иван1', weapon: 'Резиновая уточка', kill: 900}
      ]},
    {emuCounter: 30, capName: 'Виктор', solders: [
        {name: 'Иван1', weapon: 'Томпсон', kill: 11},
        {name: 'Иван3', weapon: 'Томпсон', kill: 13},
        {name: 'Иван2', weapon: 'Томпсон', kill: 1}
      ]},
    {emuCounter: 20, capName: 'Данила', solders: [
        {name: 'Иван1', weapon: 'Пистолет', kill: 20},
        {name: 'Иван3', weapon: 'Томпсон', kill: 20},
        {name: 'Иван2', weapon: 'Гидра', kill: 20},
        {name: 'Иван4', weapon: 'Резиновая уточка', kill: 21}
      ]}
  ];

  scouts: Scouts[] = [
    {scoutName: 'Саня', dataCount: 32},
    {scoutName: 'Саня', dataCount: 8},
    {scoutName: 'Саня', dataCount: 17},
    {scoutName: 'Саня', dataCount: 89},
    {scoutName: 'Саня', dataCount: 3},
    {scoutName: 'Саня', dataCount: 2}
  ];

  emuGroups: EmuGroup[] = [
    {emuGroupNumber: 1, countEmuInGroup: 21},
    {emuGroupNumber: 2, countEmuInGroup: 45},
    {emuGroupNumber: 4, countEmuInGroup: 121},
    {emuGroupNumber: 6, countEmuInGroup: 41},
  ];

  getCards(): Card[]{
    return this.cards;
  }
  getSquad(): Squad[]{
    return this.squads;
  }
  getScouts(): Scouts[]{
    return this.scouts;
  }
  getEmuGroups(): EmuGroup[]{
    return this.emuGroups;
  }
  test(): void{
    alert(1);
  }
}
