import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RocketComponent } from './rocket/rocket.component';
import { HttpClientModule } from '@angular/common/http';
import {environment} from './environment'
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDbService} from 'angular-in-memory-web-api';
import { InMemoryRocketService } from './InMemoryRocketService.service';


@NgModule({
  declarations: [
    AppComponent,
    RocketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    environment.production ?
    HttpClientInMemoryWebApiModule.forRoot(InMemoryRocketService, { delay: 100 }) : []
  ],
  providers: [RocketComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
