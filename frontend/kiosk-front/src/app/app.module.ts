import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { MenuComponent } from './menu/menu.component';
import { ReceiptComponent } from './receipt/receipt.component';
import { ThankYouPageComponent } from './thank-you-page/thank-you-page.component';
import { CartComponent } from './cart/cart.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { OAuthModule } from 'angular-oauth2-oidc';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    MenuComponent,
    ReceiptComponent,
    ThankYouPageComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    OAuthModule.forRoot({
      resourceServer: {
          allowedUrls: ['http://localhost:9001/food'],
          sendAccessToken: true
        }
      })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
