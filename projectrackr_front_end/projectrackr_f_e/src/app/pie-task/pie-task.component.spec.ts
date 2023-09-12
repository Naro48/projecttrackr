import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PieTaskComponent } from './pie-task.component';

describe('PieTaskComponent', () => {
  let component: PieTaskComponent;
  let fixture: ComponentFixture<PieTaskComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PieTaskComponent]
    });
    fixture = TestBed.createComponent(PieTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
