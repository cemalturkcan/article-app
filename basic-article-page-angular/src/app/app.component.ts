import {Component, SkipSelf} from '@angular/core';
import {FetchServiceService} from "./services/data-services/fetch-service/fetch-service.service";
import {DateService} from "./services/data-services/format-services/date-service";
import {environment} from "../environments/environment.development";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'basic-article-page-angular';
  mainContent: any = {};
  leftBarItems: any = [];
  rightBarItems: any = [];
  topBarItems: any = [];
  activeMenuItem: any = {};
  mainContentChangedEvent(value: any) {
    this.mainContent = value;
    this.activeMenuItem = value;
  }

  constructor(@SkipSelf() private fetchService: FetchServiceService, @SkipSelf() private dateService: DateService) {}

  ngOnInit(): void {
    this.fetchService.getCategoryArticlesByDomainIdAndCategoryName(environment.domainId, environment.CategoryNames.leftBar).subscribe((data: any) => {
      this.leftBarItems = data.data.items;
      this.leftBarItems.forEach((item: any) => {
        item.article.created  = this.dateService.formatDate(item.article.created);
      });
    });
    this.fetchService.getCategoryArticlesByDomainIdAndCategoryName(environment.domainId, environment.CategoryNames.rightBar).subscribe((data: any) => {
      this.rightBarItems =  data.data.items;
      this.rightBarItems.forEach((item: any) => {
        item.article.created  = this.dateService.formatDate(item.article.created);
      });
    });
    this.fetchService.getCategoryArticlesByDomainIdAndCategoryName(environment.domainId, environment.CategoryNames.topBar).subscribe((data: any) => {
      this.topBarItems =  data.data.items;
      this.topBarItems.forEach((item: any) => {
        item.article.created = this.dateService.formatDate(item.article.created);
      });
    });
  }
}
