import { TestBed } from '@angular/core/testing';

import { TokenSecurityServiceService } from './token-security-service.service';

describe('TokenSecurityServiceService', () => {
  let service: TokenSecurityServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenSecurityServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
