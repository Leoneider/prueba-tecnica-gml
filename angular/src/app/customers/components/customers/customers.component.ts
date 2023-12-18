import { Component, Inject } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ClientService } from '../../../services/client.service';

import { AddClientComponent } from '../add-client/add-client.component';
import { Client } from '../../../models/IClient';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent {
  constructor(public dialog: MatDialog, private clientService: ClientService) { }

  displayedColumns: string[] = ['sharedKey', 'businessId', 'email', 'phone', 'dateAdd', 'actions'];
  dataSource: Client[] = [];

  ngOnInit(): void {
    this.clientService.getClients().subscribe((data) => {
      this.dataSource = data;
    })
  }


  openDialog() {
    const dialogRef = this.dialog.open(AddClientComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.clientService.getClients().subscribe((data) => {
        this.dataSource = data;
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
      })
    });
  }


}
