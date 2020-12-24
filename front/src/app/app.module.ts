import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MapComponent} from './map/map.component';
import { MainhatComponent } from './mainhat/mainhat.component';
import { ComplaintsComponent } from './complaints/complaints.component';
import { CardComponent } from './card/card.component';
import { SquadComponent } from './squad/squad.component';
import { SolderComponent } from './solder/solder.component';
import { InformationComponent } from './information/information.component';

import {DataStateService} from './data-state.service';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    MainhatComponent,
    ComplaintsComponent,
    CardComponent,
    SquadComponent,
    SolderComponent,
    InformationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [DataStateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
