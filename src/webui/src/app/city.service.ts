import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient) { }

  private baseUrl: string = "http://localhost:8080/api";

  getCities(page: number){
    return this.http.get(this.baseUrl + '/pagination?page='+page);
  }
}
