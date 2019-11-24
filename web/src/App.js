import React from 'react';
import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import {Link, Route, Switch, withRouter} from "react-router-dom";
import Button from "react-bootstrap/Button";
import {giraffeStore} from "./stores/GiraffeStore";
import {tokenStore} from "./stores/TokenStore";

import {observer} from "mobx-react";
import {Form, InputGroup} from "react-bootstrap";


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
          <Route exact path={"/"} render={()=><h1>Welcome</h1>}/>
          <Route render={()=><h2>noMatch - 404</h2>}/>
        </Switch>
          <ul>
          {giraffeStore.giraffes.map((giraffe,key)=>
              <li key={key}>{giraffe.name}</li>
          )}
          </ul>
        <Button onClick={()=>giraffeStore.giraffes.push("Elmer")}>Tilføj giraf</Button>
        <Button onClick={()=>giraffeStore.giraffes.pop()}>Fjern giraf</Button>

        <h2>Loginstatus = {tokenStore.state}</h2>
        <Form>
          <Form.Group>
            <Form.Control type="text"
                          value={tokenStore.logindata.username}
                          onChange={(e)=>tokenStore.logindata.username=e.target.value}
                          placeholder="Enter username"
            />
            <Form.Control type="text"
                          value={tokenStore.logindata.password}
                          placeholder="Enter password"
                          onChange={(e)=>tokenStore.logindata.password=e.target.value}
            />
          </Form.Group>
          <Button onClick={()=>tokenStore.doLogin()}>Login</Button>
          <Button onClick={()=>{window.deferredPrompt.prompt();}}>Installér som Native App</Button>
        </Form>
      </header>
    </div>
  );
}

const About = withRouter(({history,match})=>{
  console.log(history);
  console.log(match);
  return <div><h1>About {match.params.text}</h1>
    <Button onClick={()=>history.push("/")}>Go to front</Button>
  </div>
});


export default observer(App);
