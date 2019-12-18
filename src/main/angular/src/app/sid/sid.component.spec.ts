import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidComponent } from './sid.component';

describe('SidComponent', () => {
  let component: SidComponent;
  let fixture: ComponentFixture<SidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
