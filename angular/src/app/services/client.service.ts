import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; // Import the Observable class
import { Client } from '../models/IClient';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>('http://localhost:8080/client');
  }

  addClient(client: any) {
    return this.http.post('http://localhost:8080/client', client);
  }

  updateClient(id:string, client: any) {
    return this.http.put(`http://localhost:8080/client/${id}`, client);
  }

  getClientSharedKey(sharedKey: string): Observable<Client> {
    return this.http.get<Client>(`http://localhost:8080/client/${sharedKey}`);
  }

  
}
