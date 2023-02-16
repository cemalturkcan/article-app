import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-horizontal-nav',
  templateUrl: './horizontal-nav.component.html',
  styleUrls: ['./horizontal-nav.component.css']
})
export class HorizontalNavComponent {
  @Input() menuItems: any;
  @Input() activeMenuItem: any;
  @Output() menuItemChangeEvent = new EventEmitter<any>();

  itemChanged(value: any) {
    this.menuItemChangeEvent.emit(value);
  }
}
