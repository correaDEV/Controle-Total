import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizacaoDespesaComponent } from './atualizacao-despesa.component';

describe('AtualizacaoDespesaComponent', () => {
  let component: AtualizacaoDespesaComponent;
  let fixture: ComponentFixture<AtualizacaoDespesaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtualizacaoDespesaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtualizacaoDespesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
