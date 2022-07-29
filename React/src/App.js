import React from 'react'
import './App.css'
import Barra from './components/barra';
import Registro from './components/registro';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


function App() {
  return (
    <Router>
      <div className='App'>
        <Barra/>
        <div className='content'>
          <Switch>
            <Route path={'/'}>
              <Registro/>
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  )
}

export default App
