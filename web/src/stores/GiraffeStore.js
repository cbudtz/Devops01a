import {decorate, observable} from "mobx";

export default class GiraffeStore {
    giraffes = ["Marius","Melman"];
}
decorate(GiraffeStore,{
    giraffes: observable
});