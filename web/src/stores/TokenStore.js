import {decorate, observable} from "mobx";
const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev

const Loginstates = {LOGGINGIN:"Loading", LOGGEDOUT:"Logout", LOGGEDIN:"LoggedIn"};
class TokenStore {
    state = Loginstates.LOGGEDOUT;
    token = null;
    logindata = {username:"",password:""};

    constructor() {
    }

    doLogin() {
        this.state=Loginstates.LOGGINGIN;
        fetch(baseUrl + "rest/login",{
            method:"POST",
            body:JSON.stringify(this.logindata),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            (response)=> {
                debugger;
                response.text().then(
                (token)=> {
                    console.log("Got Token: " + token)
                    this.token=token;
                    debugger;
                    this.state=Loginstates.LOGGEDIN;}

            )}
        ).catch(()=>this.state = Loginstates.LOGGEDOUT )
    }
}


decorate(TokenStore,{
    state: observable,
    token: observable,
    logindata:observable

});

export const tokenStore = new TokenStore();