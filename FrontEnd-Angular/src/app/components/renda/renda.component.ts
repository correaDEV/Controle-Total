import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { RendaService } from 'src/app/services/renda/renda.service';

@Component({
  selector: 'app-renda',
  templateUrl: './renda.component.html',
  styleUrls: ['./renda.component.scss']
})
export class RendaComponent implements OnInit {

  rendaForm!: FormGroup;
  listOfCategory: any[] = [
    "Salário",
    "Freelancer",
    "Investimento",
    "Ações",
    "Bitcoin",
    "Transferência Bancária",
    "YouTube",
    "Outro"
  ];
  rendas: any;

  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private router: Router,
    private rendaService: RendaService
  ) {}

  ngOnInit() {
    this.getAllrendas();
    this.rendaForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      description: [null, Validators.required],
      category: [null, Validators.required]
    });
  }

  submitForm() {
    if (this.rendaForm.valid) {
      this.rendaService.postRenda(this.rendaForm.value).subscribe(
        res => {
          this.message.success("Renda postada com sucesso!", { nzDuration: 5000 });
          this.getAllrendas();
        },
        error => {
          this.message.error("Erro ao postar renda", { nzDuration: 5000 });
        }
      );
    }
  }

  getAllrendas() {
    this.rendaService.getAllrendas().subscribe(
      (res: any) => {
        this.rendas = res;
      },
      (error: any) => {
        this.message.error("Erro ao buscar renda", { nzDuration: 5000 });
      }
    );
  }

  deleteRenda(id:number){
    this.rendaService.deleteRenda(id).subscribe(res=>{
      this.message.success("Renda deletada com sucesso!", { nzDuration: 5000 });
      this.getAllrendas();
    }, error=>{
      this.message.error("Erro ao deletar renda", { nzDuration: 5000 });
    })
  }
}
