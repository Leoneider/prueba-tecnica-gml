import { CommonModule } from "@angular/common";
import { Component, Inject } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MAT_DIALOG_DATA, MatDialog } from "@angular/material/dialog";
import { MatIconModule } from "@angular/material/icon";


import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { ClientService } from "../../../services/client.service";
import { Client } from "../../../models/IClient";


@Component({
  selector: 'app-add-client',
  standalone: true,
  imports: [CommonModule, MatFormFieldModule, MatInputModule, FormsModule, ReactiveFormsModule, MatIconModule, MatButtonModule],
  templateUrl: './add-client.component.html'
})
export class AddClientComponent {
  idClient = '';

  constructor(@Inject(MAT_DIALOG_DATA) public customer: Client, private formBuilder: FormBuilder, private clientService: ClientService, public dialog: MatDialog) { }


  ngOnInit(): void {

    if (!this.customer) {
      return;
    }

    this.idClient = this.customer.id;

    this.clientForm.patchValue({
      name: this.customer.name,
      phone: this.customer.phone,
      email: this.customer.email,
      startDate: this.customer.startDate,
      endDate: this.customer.endDate,
    });
  }

  clientForm = this.formBuilder.group({
    name: ['', Validators.required],
    phone: ['', Validators.required],
    email: ['', Validators.required],
    startDate: ['', Validators.required],
    endDate: ['', Validators.required],
  });

  addClient() {
    if (this.clientForm.invalid) {
      return;
    }

    if (this.idClient) {
      this.clientService.updateClient(this.idClient, this.clientForm.value).subscribe((data) => {

      });
    } else {
      this.clientService.addClient(this.clientForm.value).subscribe((data) => {
      });
    }
    this.dialog.closeAll();
  }
}