import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HandleError, HttpErrorHandler } from './http-error-handler.service';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Rocket } from './rocket/rocket';
import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class InMemoryRocketService implements InMemoryDbService {

  rocketUrl = 'api/rockets'; // URL to in memory api
  private handleError: HandleError;

  printToConsole(arg0: string) {
    console.log(arg0);

  }

  constructor(private http, httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('RocketService');
  }

  createDb(reqInfo?: RequestInfo): {} | Observable<{}> | Promise<{}> {
    let rockets = [{
        id: 1, code: 'Apollo XI', targetSpeed: 100, currentSpeed: 0, maxPropulsors: 3,
        propulsors: [
          { id: 1, maxPower: 10, currentPower: 0 },
          { id: 2, maxPower: 30, currentPower: 0 },
          { id: 3, maxPower: 80, currentPower: 0 }
        ]
      },
      {
        id: 1, code: 'Soyuz I', targetSpeed: 100, currentSpeed: 0, maxPropulsors: 6,
        propulsors: [
          { id: 1, maxPower: 30, currentPower: 0 },
          { id: 2, maxPower: 40, currentPower: 0 },
          { id: 3, maxPower: 50, currentPower: 0 },
          { id: 3, maxPower: 50, currentPower: 0 },
          { id: 3, maxPower: 30, currentPower: 0 },
          { id: 3, maxPower: 10, currentPower: 0 }
      ]
    }
    ]

    return rockets;
  }

}
