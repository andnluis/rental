import React from 'react'
import Card from './Card'


function Cards({cartas}) {

    

    return (
      <div className="container d-flex justify-content-center align-items-center h-100 mt-5">
        <div className="row d-flex justify-content-center h-100 ">
          {cartas.map((carta) => (
            <div className="col-md-4 " key={carta.id_maq}>
              <Card carta={carta} />
            </div>
          ))}
        </div>
      </div>
    );
  }

export default Cards
