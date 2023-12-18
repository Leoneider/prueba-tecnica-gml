import { TestBed } from '@angular/core/testing';

import { ClientService } from './client.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Client } from '../models/IClient';




describe('ClientService', () => {
  let service: ClientService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClientService]
    });
    service = TestBed.inject(ClientService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return an Observable of Client[]', () => {
    const mockClients: Client[] = [
      { id: "1", name: 'John Doe', phone: '', email: '', startDate: '', endDate: '' },
      { id: "2", name: 'Jane Smith', phone: '', email: '', startDate: '', endDate: '' }
    ];

    service.getClients().subscribe(clients => {
      expect(clients).toEqual(mockClients);
    });

    const req = httpMock.expectOne('http://localhost:8080/client');
    expect(req.request.method).toBe('GET');
    req.flush(mockClients);
  });
});