import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {HashRouter} from "react-router-dom";
import {render} from '@testing-library/react';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<HashRouter><App /></HashRouter>, div);
  ReactDOM.unmountComponentAtNode(div);
});

test('Calculates', ()=>{
  const div = document.createElement('div');
  const {getByText} = render(<HashRouter><App/></HashRouter>, div);
  console.log(getByText(/Startside/));


})


test('Calculates correctly',()=>{
  expect(2+2).toBe(4);
})