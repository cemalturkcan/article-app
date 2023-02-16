import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FetchServiceService {

  constructor(private http: HttpClient) { }

  getDomainByDomainId(domainId: string) {
    return this.http.get('api/domains/filter?' + 'id='  + domainId);
  }
  getCategoryArticlesByDomainIdAndCategoryName(domainId: string, categoryName: string) {
    return this.http.get('api/category-articles/filter?' + 'categoryName=' +  categoryName + '&domainId=' + domainId);
  }
}
