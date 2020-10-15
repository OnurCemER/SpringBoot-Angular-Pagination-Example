import { Component, OnInit } from '@angular/core';
import {CityService} from '../city.service';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  page: number = 0;
  cities: Array<any>;
  pages: Array<number>;

  constructor(private cityService: CityService) { }

  ngOnInit(): void {
    this.getCities();
  }

  getCities(){
    this.cityService.getCities(this.page).subscribe(
      data => {
        console.log(data);
        this.cities = data['content'];
        this.pages = new Array<number>(data['totalPages']);
      },
      (error) => {
        console.log(error.error.message)
      }
    );
  }

  setPage(i, $event:any){
    event.preventDefault();
    this.page = i;
    this.getCities();
  }
}
