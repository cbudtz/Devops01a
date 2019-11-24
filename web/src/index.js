import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {HashRouter} from "react-router-dom";
window.addEventListener('beforeinstallprompt', (e) => {
    // Stash the event so it can be triggered later.
    console.log("Got beforeinstallprompt");
    window.deferredPrompt = e;
});

ReactDOM.render(<HashRouter><App /></HashRouter>, document.getElementById('root'));

// window.addEventListener('beforeinstallprompt', (e) => {
//     // Stash the event so it can be triggered later.
//     console.log("PWA");
//     e.   prompt();
// });

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();


