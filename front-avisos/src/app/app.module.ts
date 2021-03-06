import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoticeComponent } from './notice/notice.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {Router, RouterModule, Routes} from "@angular/router";
import {NoticeService} from "./notice/notice.service";
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from "@angular/forms";
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';




var routes: Routes = [{
  path: " ",
  component: NoticeComponent
}]

@NgModule({
  declarations: [
    AppComponent,
    NoticeComponent
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatCardModule,
    HttpClientModule,
    MatCheckboxModule,
    RouterModule.forRoot(routes),
    FormsModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule
  ],
  providers: [NoticeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
