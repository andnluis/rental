import axios from "axios";

const authToken = (token) => {
    if(token){
        axios.defaults.headers.common["Authorization"]=`${token}`;
    }else{
        delete axios.defaults.common["Authorization"];
    }
};

export default authToken;
