import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DespesaComponent } from './components/despesa/despesa.component';
import { AtualizacaoDespesaComponent } from './components/atualizacao-despesa/atualizacao-despesa.component';
import { RendaComponent } from './components/renda/renda.component';
import { AtualizarRendaComponent } from './components/atualizar-renda/atualizar-renda.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

const routes: Routes = [
  {path: "", component: DashboardComponent},
  {path: "despesa", component: DespesaComponent},
  {path: "renda", component: RendaComponent},
  {path: "despesa/:id/edit", component: AtualizacaoDespesaComponent},
  {path: "renda/:id/edit", component: AtualizarRendaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
