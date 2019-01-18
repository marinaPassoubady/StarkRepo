import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MySoldComponent } from './my-sold.component';

describe('MySoldComponent', () => {
  let component: MySoldComponent;
  let fixture: ComponentFixture<MySoldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MySoldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MySoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
