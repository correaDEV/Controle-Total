import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
import { DespesaComponent } from './components/despesa/despesa.component';
import { AtualizacaoDespesaComponent } from './components/atualizacao-despesa/atualizacao-despesa.component';
import { RendaComponent } from './components/renda/renda.component';
import { AtualizarRendaComponent } from './components/atualizar-renda/atualizar-renda.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    DespesaComponent,
    AtualizacaoDespesaComponent,
    RendaComponent,
    AtualizarRendaComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DemoNgZorroAntdModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
