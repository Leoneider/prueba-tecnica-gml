import { Component, Inject } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ClientService } from '../../../services/client.service';

import { AddClientComponent } from '../add-client/add-client.component';
import { Client } from '../../../models/IClient';
import { FormControl } from '@angular/forms';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent {
  constructor(public dialog: MatDialog, private clientService: ClientService) { }

  displayedColumns: string[] = ['sharedKey', 'businessId', 'email', 'phone', 'dateAdd', 'actions'];
  dataSource: Client[] = [];
  dataClient:  Client[] = [];

  search = new FormControl('');

  ngOnInit(): void {
    this.clientService.getClients().subscribe((data) => {
      this.dataSource = data;
      this.dataClient = data;
    })

    this.search.valueChanges.pipe(debounceTime(300)).subscribe((value) => {
      if (!value) {
        this.dataSource = this.dataClient;
        return;
      }

      this.searchClient(value);
     
    });
  }

  searchClient(value:string) {
    this.clientService.getClientSharedKey(value).subscribe({
      next: (data) => {
        this.dataSource = [data];
      },
      error: () => {
        this.dataSource = [];
      }
    });
  }


  openDialog() {
    const dialogRef = this.dialog.open(AddClientComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.clientService.getClients().subscribe((data) => {
        this.dataSource = data;
        this.dataClient = data;
      })
    });
  }

  editCustomer(customer: Client) {
    const dialogRef = this.dialog.open(AddClientComponent, {
      data: customer,
    });

    dialogRef.afterClosed().subscribe(() => {
      this.clientService.getClients().subscribe((data) => {
        this.dataSource = data;
        this.dataClient = data;
      })
    });
  }


}
