import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { RendaService } from 'src/app/services/renda/renda.service';

@Component({
  selector: 'app-atualizar-renda',
  templateUrl: './atualizar-renda.component.html',
  styleUrls: ['./atualizar-renda.component.scss']
})
export class AtualizarRendaComponent {

  id:number = this.activatedRoute.snapshot.params['id'];
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
    private rendaService: RendaService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.rendaForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      description: [null, Validators.required],
      category: [null, Validators.required]
    });
    this.getRendaById();
  }

  getRendaById(){
    this.rendaService.getRendaById(this.id).subscribe(res=>{
      this.rendaForm.patchValue(res);

    }, error=>{
      this.message.error("Alguma coisa deu errado", { nzDuration: 5000});
    })
  }

  submitForm(){
    this.rendaService.atualizarRenda(this.id, this.rendaForm.value).subscribe(res=>{
      this.message.success("Renda atualizada com sucesso", { nzDuration: 5000});
      this.router.navigateByUrl("/renda")
    }, error=>{
      this.message.error("Erro ao atualizar renda", { nzDuration: 5000});
    })
  }

}

