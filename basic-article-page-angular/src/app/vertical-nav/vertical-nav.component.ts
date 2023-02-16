import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-vertical-nav',
  templateUrl: './vertical-nav.component.html',
  styleUrls: ['./vertical-nav.component.css']
})
export class VerticalNavComponent {
  @Input() menuItems: any;
  @Input() activeMenuItem: any;
  @Output() menuItemChangeEvent = new EventEmitter<any>();

  itemChanged(value: any) {
    this.menuItemChangeEvent.emit(value);
  }
}
