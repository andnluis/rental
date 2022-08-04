import React from "react";
import PropTypes from "prop-types";

import "../styles/Card.css";

function Card({ id_maq, id_man, id_prop, n_serie, disponible,id_tipo, pph, ubicacion, modelo_motor, potencia, peso }) {

  const tiposDeMaquina = {
    1 : "Bulldozer",
    2 : "Motoniveladora",
    3 : "Cargador frontal",
    4 : "Retroexcavadora",
    5 : "Dragalina",
    6 : "Excavadora",
    7 : "Cargadora",
    8 : "Camión",
    9 : "Camión Articulado",
    10 : "Volqueta",
    11 : "Rodillo de neutomatico",
    12 : "Compactadores de placa",
    13 : "Rodillo de rueda lisa",
    14 : "Planta de hormigon",
    15 : "Mezcladora",
    16 : "Hormigonera",
    17 : "Volquetas de concreto",
    18 : "Bombas de hormigon",
    19 : "Elevadores",
    20 : "Equipo de inyeccion",
    21 : "Elevador fijo",
    22 : "Elevador móvil",
    23 : "Carretilla elevadora",
    24 : "Grua de neutomatico",
    25 : "Grua sobra camión",
    26 : "Grua montada en oruga",
    27 : "Grua estacionaria",
    28 : "Grua para transporte",
    29 : "Acabados hormigón",
    30 : "Plantas de asfalto",
    31 : "Pavimentadora de asfalto",
    32 : "Equipos de transporte de escombro",
    33 : "Tuneladoras",
    34 : "Generadores",
    35 : "Equipo de soldadura",
    36 : "Equipos de bombeo y deshidratación",
    37 : "Equipos de colocación de tubería"
  }


  console.log(tiposDeMaquina[id_tipo])


  return (
    <div className="card text-center bg-dark animate__animated animate__fadeInUp">
      <div className="overflow">
        <img src={""} alt="a wallpaper" className="card-img-top" />
      </div>
      <div className="card-body text-light">
        <h4 className="card-title">{n_serie}</h4>
        <p className="card-text text-secondary">
          <p >Tipo de maquina: </p>
        </p>
        <a
          href={"#!"}
          target="_blank"
          className="btn btn-outline-secondary border-0"
          rel="noreferrer"
        >
          Go to {}
        </a>
      </div>
    </div>
  );
}

Card.propTypes = {
  title: PropTypes.string.isRequired,
  text: PropTypes.string,
  url: PropTypes.string,
  imageSource: PropTypes.string
};

export default Card
