import React from 'react';
import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import {Link, Route, Switch, withRouter} from "react-router-dom";
import Button from "react-bootstrap/Button";
import {giraffeStore} from "./stores/GiraffeStore";
import {observer} from "mobx-react";

function App() {

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Glædelig DevOps! E19 - 5/9 - version 5
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Link to={"/about/giraffes"}>Look at About!</Link>
        <Switch>
          <Route path={"/about/:text"} component={About}/>
          <Route component={Default}/>
        </Switch>
        <ul>
          {giraffeStore.giraffes.map((giraffeName,key)=>
              <li key={key}>{giraffeName}</li>
          )}
          </ul>
        <Button onClick={()=>giraffeStore.giraffes.push("Elmer")}>Tilføj giraf</Button>
      </header>
    </div>
  );
}

const About = withRouter(({history, match})=>{
  console.log(history);
  console.log(match);
  return <div><h1>About {match.params.text}</h1>
    <Button onClick={()=>history.push("/")}>Go to front</Button>
  </div>
});

const Default = ()=><h2>noMatch - 404</h2>;

export default observer(App);
