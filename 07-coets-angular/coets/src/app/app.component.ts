import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { InMemoryRocketService } from './InMemoryRocketService.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IT Academy\'s rocket science!';

  constructor(private http: HttpClient, private svc : InMemoryRocketService){
    svc.printToConsole("Hello from the rocket");
  }

  ngOnInit() {
    let obs = this.http.get('https://api.github.com/users/jordeec');
    obs.subscribe(()=> console.log("Got the response"));
  }
}
