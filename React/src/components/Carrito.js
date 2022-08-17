import { CartProvider, useCart } from "react-use-cart";
import React, { Fragment, useState, useContext } from "react";
import axios from "axios";
import '../styles/Carrito.css';

export default function Cart() {
  const { isEmpty, totalUniqueItems, items, updateItemQuantity, removeItem } =
    useCart();

    const [datos, setDatos] = useState({
        id_maq: "",
        fecha: "",
        horas: "",
        id_prop: "",
        clave: "",
      });

      const handleInputChange = (event) => {
        console.log(event.target.value);
        setDatos({
          ...datos,
          [event.target.name]: event.target.value,
        });
      };
    
      const enviarDatos = (event) => {
        const fecha = new Date(datos.f_nac);
        const parseToString = (date) => {
          return `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
        };
        const newDatos = {
          ...datos,
          f_nac: parseToString(fecha),
        };
        const params = new URLSearchParams(newDatos);
    
        axios
          .post("http://localhost:8080/usuario/cliente/add", params)
          .then((response) => console.log(response))
          .catch((err) => console.log(err.message));
      };

  if (isEmpty) return <p>Your cart is empty</p>;

  

 
  return (
    <>
      <h1 class="text-center mt-5">Cart ({totalUniqueItems})</h1>
        <div class="content mt-5">
      {items.map((item) => (
        <div class="d-flex justify-content-center">
          <div class="carta card bg-dark mb-3 text-white ">
            <div class="row g-0 ">
              <div class="col-md-4">
                <img src={""} class="img-fluid rounded-start" alt="..." />
              </div>
              <div class=" col d-flex justify-content-center">
                <div class="fecha card-body">
                  <h5 class="card-title">{item.nombre}</h5>
                </div>
                
                <div class="fecha col mt-2" >
                  <label class="form-label">Fecha de Inicio</label>
                  <input
                    type="date"
                    class="form-control"
                    placeholder=""
                    aria-label="fecha de inicio"
                    name="fecha"
                    onChange={handleInputChange}
                  />
                </div>
                <div class="fecha col mt-2">
                  <label class="form-label">Horas alquiladas</label>
                  <input
                    type="number"
                    class="form-control"
                    placeholder="X"
                    aria-label="Horas alquiladas"
                    name="horas"
                    onChange={handleInputChange}
                  />
                </div>
                <div class="fecha col d-flex justify-content-center ">
                  <button class="boton bg-warning" onClick={() => removeItem(item.id)}>X</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
      </div>
    </>
  );
}
