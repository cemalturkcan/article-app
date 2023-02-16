import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.css']
})
export class MainContentComponent {
  @Input() mainContent: any = {};

  isEmptyObject(obj:any) {
    return (obj && (Object.keys(obj).length === 0));
  }
}
