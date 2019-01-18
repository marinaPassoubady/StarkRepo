import { Component } from '@angular/core';

@Component({
  selector: 'app-my-sold',
  templateUrl: './my-sold.component.html',
  styleUrls: ['./my-sold.component.css']
})
export class MySoldComponent {
  public dresseur;

  constructor() {
    this.dresseur = JSON.parse(localStorage.getItem('CurrentUser'));
  }


}
