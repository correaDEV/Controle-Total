import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RendaComponent } from './renda.component';

describe('RendaComponent', () => {
  let component: RendaComponent;
  let fixture: ComponentFixture<RendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RendaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
