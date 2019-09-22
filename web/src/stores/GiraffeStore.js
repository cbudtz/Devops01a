import {autorun, decorate, observable} from "mobx";
const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev

class GiraffeStore {
    giraffes = ["Loading giraffes"];

    constructor(props) {
        this.fetchGiraffes();
    }

    fetchGiraffes (){
        fetch(baseUrl + "rest/giraffes").then(
            (response)=> response.json().then(
                (json)=> this.giraffes=json
            )
        )
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