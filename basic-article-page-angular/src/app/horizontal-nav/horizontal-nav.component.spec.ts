import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorizontalNavComponent } from './horizontal-nav.component';

describe('TopBarComponent', () => {
  let component: HorizontalNavComponent;
  let fixture: ComponentFixture<HorizontalNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorizontalNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorizontalNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
