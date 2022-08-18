import { useCart } from "react-use-cart";
import React, { useState,useContext } from "react";
import axios from "axios";
import '../styles/Carrito.css';
import { useHistory } from "react-router-dom";
import { UsuarioContext } from "../context/UsuarioContext";


export default function Cart() {
  const { isEmpty, totalUniqueItems, items, updateItemQuantity, removeItem , updateItem } =
    useCart();
    const history = useHistory();
    const { userRenta} = useContext(UsuarioContext);
    

    const [datos, setDatos] = useState({
        id_maq: "",
        horas: "",
        fecha_inicio: "",
        id_renta:""
      });

      console.log(items)

      const handleInputChange = (event, id) => {
        
        updateItem(id, {
          [event.target.name] : event.target.value,
          id_renta: userRenta.id_renta 
        });
        console.log(items)
        
      };
    
      const enviarDatos = () => {
        const params = new URLSearchParams(items);
        
        
        axios
          .post("http://localhost:8060/cart/add", {params})
          .then((response) => console.log(response))
      .catch((err) => console.log(err.message));
      };

      

      

  if (isEmpty) return <h1 class="text-center mt-5">El carrito esta vacio</h1>;

  

 
  return (
    <>
      <h1 class="text-center mt-5">Maquinaria en el carrito: {totalUniqueItems}</h1>
        <div class="content mt-5">
      {items.map((item) => (
        <div class="d-flex justify-content-center">
          <div class="carta card bg-dark mb-3 text-white ">
            <div class="row g-0 ">
              <div class="col-md-4">
                <div class="imagen ">
                <img src={item.imagen} class="img"  />
                </div>
              </div>
              <div class=" col d-flex justify-content-center">
                <div class="fecha card-body">
                  <h5 class="card-title">{item.nombre}</h5>
                </div>
                
                <div class="fecha col mt-2" >
                  <label class="form-label">Fecha de Inicio</label>
                  <input
                    type="datetime-local"
                    class="form-control"
                    placeholder=""
                    aria-label="fecha de inicio"
                    name="fecha_inicio"
                    onChange={(e)=>{
                      handleInputChange(e,item.id)                    
                    }}
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
                    onChange={(e)=>{
                      handleInputChange(e,item.id)
                    }}
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
      <div class="d-flex justify-content-center mt-5">
      <button type="button" class="btn btn-warning" onClick={enviarDatos}>Procesar compra</button>
      </div>
    </>
  );
}
