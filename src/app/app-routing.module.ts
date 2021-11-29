import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientListComponent } from './patient-list/patient-list.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import {UpdatePatientComponent} from './update-patient/update-patient.component';
import { identifierModuleUrl } from '@angular/compiler';
import { PatientDetailsComponent } from './patient-details/patient-details.component';


const routes: Routes = [
  {path: 'patient', component: PatientListComponent},
  {path: 'create-patient', component: CreatePatientComponent},
 {path: '', redirectTo: 'patient', pathMatch: 'full'},
 {path: 'update-patient/:id',component:UpdatePatientComponent},
 {path:'patient-details/:id',component:PatientDetailsComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
