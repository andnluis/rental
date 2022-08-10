import React, { createContext, useState } from "react";

export const UsuarioContext = createContext();

export const UsuarioProvider = ({ children }) => {
  
  

  const [userData, setUserData] = useState(
    ()=> JSON.parse( window.sessionStorage.getItem('userData') )
  );

    console.log(userData);
  const [userVer, setUserVer] = useState(null);

  const setLocal = (userData) => {
        if (userData) {
          window.sessionStorage.setItem("userData", JSON.stringify(userData));
          setUserData(userData);
        }
        else  {
          window.sessionStorage.removeItem("userData");
        }
        
    }

  {/*function login(email, password) {
    setUsuario(data.usuario);
  }*/}



  return (
    <UsuarioContext.Provider
      value={{
        userData,
        setUserData,
        userVer,
        setUserVer,
        setLocal
        
      }}
    >
      {children}
    </UsuarioContext.Provider>
  );
}
