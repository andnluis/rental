import React from 'react'
import './App.css'
import Barra from './components/barra';
import Registro from './components/registro';
import Inicio from './components/Inicio';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


function App() {
  return (
    <Router>
      <div className='App'>
        <Barra/>
        <div className='content'>
          <Switch>
            <Route exact path={'/'}>
              <Inicio/>
            </Route>
            <Route path={'/Registro'}>
              <Registro/>
            </Route>
            <Route path={'/Inicio'}>
              <Inicio/>
            </Route>
            <Route path={'/Inicio'}>
              <Inicio/>
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  )
}

export default App
