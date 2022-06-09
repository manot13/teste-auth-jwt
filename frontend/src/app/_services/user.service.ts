import { UserAuthService } from './user-auth.service';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  PATH_OF_API = "http://localhost:8080";

  requestHeader = new HttpHeaders(
    { "No-Auth":"True"}
  );

  constructor(private httpclient: HttpClient,
    private userAuthService: UserAuthService) { }

  public login(loginData:any){
    return this.httpclient.post(this.PATH_OF_API + "/authenticate", loginData, { headers: this.requestHeader })
  }

  public roleMatch(allowedRoles:any): boolean{
    let isMatch = false;
    const userRoles:any = this.userAuthService.getRoles();

    if(userRoles != null && userRoles){
      for(let i = 0; i<userRoles.length; i++){
        for(let j=0; j<allowedRoles.length; j++){
          if(userRoles[i].roleName === allowedRoles[j]){
            isMatch = true;
            return isMatch;
          } else{
            return isMatch;
          }
        }
      }
    }
    return isMatch;
  }

}
