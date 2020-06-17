import { Component, OnInit } from '@angular/core';
import { Rocket } from './rocket';
import { InMemoryRocketService } from '../InMemoryRocketService.service';

@Component({
  selector: 'app-rocket',
  templateUrl: './rocket.component.html',
  styleUrls: ['./rocket.component.css']
})
export class RocketComponent implements OnInit {

  rockets: Rocket[];
  currentRocket: Rocket;
  svc: InMemoryRocketService;

  constructor() { }

  ngOnInit(): void {
    rockets = this.svc.createDb();
  }

}
