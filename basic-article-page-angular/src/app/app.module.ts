import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HorizontalNavComponent } from './horizontal-nav/horizontal-nav.component';
import { MainContentComponent } from './main-content/main-content.component';
import { VerticalNavComponent } from './vertical-nav/vertical-nav.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HorizontalNavComponent,
    MainContentComponent,
    VerticalNavComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
