import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Link, Route, Switch, withRouter} from "react-router-dom";

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
          <Route component={Default}></Route>
        </Switch>
      </header>
    </div>
  );
}

const About = withRouter(({history, match})=>{
  console.log(history);
  console.log(match);
  return <div><h1>About {match.params.text}</h1>
    <button onClick={()=>history.push("/")}>Go to front</button>
  </div>
})

const Default = ()=><h2>noMatch - 404</h2>;

export default App;
