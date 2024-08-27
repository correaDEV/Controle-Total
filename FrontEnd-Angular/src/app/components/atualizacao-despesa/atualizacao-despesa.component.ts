import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { DespesaService } from 'src/app/services/despesa/despesa.service';

@Component({
  selector: 'app-atualizacao-despesa',
  templateUrl: './atualizacao-despesa.component.html',
  styleUrls: ['./atualizacao-despesa.component.scss']
})
export class AtualizacaoDespesaComponent implements OnInit {

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
    "Outros"
  ];
  id: number = this.activatedRoute.snapshot.params['id'];

  constructor(
    private fb: FormBuilder,
    private despesaService: DespesaService,
    private message: NzMessageService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.despesaForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required]
    });
    this.getDespesaById();
  }

  getDespesaById() {
    this.despesaService.getDespesaById(this.id).subscribe(
      res => {
        this.despesaForm.patchValue(res);
      },
      error => {
        this.message.error('Algo deu errado ao buscar a despesa.', { nzDuration: 5000 });
      }
    );
  }

  submitForm() {
    if (this.despesaForm.valid) {
      this.despesaService.atualizacaoDespesa(this.id, this.despesaForm.value).subscribe(
        res => {
          this.message.success('Despesa atualizada com sucesso.', { nzDuration: 5000 });
          this.router.navigateByUrl('/despesas');
        },
        error => {
          this.message.error('Erro ao atualizar despesa.', { nzDuration: 5000 });
        }
      );
    } else {
      this.message.error('Por favor, preencha todos os campos corretamente.', { nzDuration: 5000 });
    }
  }
}
