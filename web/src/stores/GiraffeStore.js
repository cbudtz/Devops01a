import {decorate, observable} from "mobx";
import {tokenStore} from "./TokenStore";


const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev


const states = {LOADING:"LOAD", DONE:"DONE", FAILED:"FAILED"}
class GiraffeStore {
    state = states.DONE;
    giraffes = ["Loading giraffes"];

    constructor(props) {
        this.fetchGiraffes();
    }

    fetchGiraffes (){
        const token = tokenStore.token;
        this.loading = states.LOADING;
        fetch(baseUrl + "rest/giraffes", {
            headers: {
                Authorization: token
            }
        }).then(
            (response)=> response.json().then(
                (json)=> {
                    this.giraffes=json;
                    this.state=states.DONE;}
            )
        ).catch(()=>this.state = states.FAILED )
    }


    async fetchGiraffes3(){
        try {
            let resp = await fetch(baseUrl + "rest/giraffes");
            let json = await resp.json();
            this.giraffes = json;
        } catch (e){
            this.giraffes = ["Loading failed :("];
        }
    }


}




decorate(GiraffeStore,{
    giraffes: observable
});

export const giraffeStore = new GiraffeStore();