import { TestBed } from '@angular/core/testing';

import { AuthLogginGuard } from './auth-loggin.guard';

describe('AuthLogginGuard', () => {
  let guard: AuthLogginGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthLogginGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
