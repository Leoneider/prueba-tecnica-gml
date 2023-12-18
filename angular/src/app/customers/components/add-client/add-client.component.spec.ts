import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AddClientComponent } from './add-client.component';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { FormBuilder } from '@angular/forms';
import { ClientService } from '../../../services/client.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


describe('AddClientComponent', () => {
  let component: AddClientComponent;
  let fixture: ComponentFixture<AddClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddClientComponent, HttpClientTestingModule, BrowserAnimationsModule],
      providers: [
        { provide: MAT_DIALOG_DATA, useValue: {} },
        { provide: FormBuilder, useClass: FormBuilder },
        { provide: ClientService, useClass: ClientService },
        { provide: MatDialog, useClass: MatDialog },

      ]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
