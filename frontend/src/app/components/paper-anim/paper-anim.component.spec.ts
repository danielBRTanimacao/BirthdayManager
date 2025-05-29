import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaperAnimComponent } from './paper-anim.component';

describe('PaperAnimComponent', () => {
  let component: PaperAnimComponent;
  let fixture: ComponentFixture<PaperAnimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaperAnimComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaperAnimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
