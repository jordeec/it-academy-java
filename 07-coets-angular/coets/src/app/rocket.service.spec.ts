import { TestBed } from '@angular/core/testing';

import { InMemoryRocketService } from './InMemoryRocketService.service';

describe('RocketService', () => {
  let service: InMemoryRocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InMemoryRocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
