import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalEditableComponent } from './modal-editable.component';

describe('ModalEditableComponent', () => {
  let component: ModalEditableComponent;
  let fixture: ComponentFixture<ModalEditableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalEditableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalEditableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
