import { Router } from '@angular/router';
import { UserAuthService } from './../_services/user-auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(
    private userAuthService: UserAuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  public isLoggedIn(){
    return this.userAuthService.isLoggedIn();
  }

  public logout(){
    this.userAuthService.clear();
    this.router.navigate(['/home'])
  }

  //1:25:58

}
