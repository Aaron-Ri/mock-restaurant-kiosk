import { TestBed } from '@angular/core/testing';

import { FoodFetcherService } from './food-fetcher.service';

describe('FoodFetcherService', () => {
  let service: FoodFetcherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodFetcherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
