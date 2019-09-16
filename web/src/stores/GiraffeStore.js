import {decorate, observable} from "mobx";

class GiraffeStore {
    giraffes = ["Marius","Melman"];
}
decorate(GiraffeStore,{
    giraffes: observable
});

export const giraffeStore = new GiraffeStore();