import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopTasksComponent } from './top-tasks.component';

describe('TopTasksComponent', () => {
  let component: TopTasksComponent;
  let fixture: ComponentFixture<TopTasksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TopTasksComponent]
    });
    fixture = TestBed.createComponent(TopTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
