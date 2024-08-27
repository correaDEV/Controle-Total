import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarRendaComponent } from './atualizar-renda.component';

describe('AtualizarRendaComponent', () => {
  let component: AtualizarRendaComponent;
  let fixture: ComponentFixture<AtualizarRendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtualizarRendaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtualizarRendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
