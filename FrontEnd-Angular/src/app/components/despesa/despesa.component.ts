import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { DespesaService } from 'src/app/services/despesa/despesa.service';

@Component({
  selector: 'app-despesa',
  templateUrl: './despesa.component.html',
  styleUrls: ['./despesa.component.scss']
})
export class DespesaComponent implements OnInit {

  despesaForm!: FormGroup;
  listOfCategory: any[] = [
    "Educação",
    "Alimentação",
    "Saúde",
    "Assinaturas",
    "Comidas para Viagem",
    "Vestuário",
    "Viagens",
    "Trabalho",
    "Contas de Casa",
    "Outros"
  ];

  despesas: any;
  id: any;

  constructor(
    private fb: FormBuilder,
    private despesaService: DespesaService,
    private message: NzMessageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id')!; // Pegando o ID da rota
    this.getAllDespesas();
    this.despesaForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required]
    });

    if (this.id) {
      this.despesaService.getDespesaById(this.id).subscribe(res => {
        this.despesaForm.patchValue(res);
      });
    }
  }

  submitForm() {
    if (this.despesaForm.valid) {
      if (this.id) {
        // Se existir ID, atualiza a despesa
        this.despesaService.atualizacaoDespesa(this.id, this.despesaForm.value).subscribe(
          res => {
            this.message.success('Despesa atualizada com sucesso!', { nzDuration: 5000 });
            this.router.navigate(['/despesa']);
          },
          error => {
            this.message.error("Erro ao atualizar despesa", { nzDuration: 5000 });
          }
        );
      } else {
        // Se não existir ID, cria uma nova despesa
        this.despesaService.postDespesa(this.despesaForm.value).subscribe(
          res => {
            this.message.success('Despesa criada com sucesso!', { nzDuration: 5000 });
            this.router.navigate(['/despesa']);
          },
          error => {
            this.message.error("Erro ao criar despesa", { nzDuration: 5000 });
          }
        );
      }
    }
  }
  
  

  getAllDespesas() {
    this.despesaService.getAllDespesas().subscribe(res => {
      this.despesas = res;
      console.log(this.despesas);
    });
  }

  atualizacaoDespesa(id: number) {
    this.router.navigateByUrl(`/despesa/${id}/edit`);
  }

  deleteDespesa(id: number) {
    this.despesaService.deleteDespesa(id).subscribe(res => {
      this.message.success('Despesa deletada com sucesso!', { nzDuration: 5000 });
      this.getAllDespesas();
    }, error => {
      this.message.error("Erro ao deletar despesa", { nzDuration: 5000 });
    });
  }
}
