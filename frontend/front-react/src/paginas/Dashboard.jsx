import React from "react";
import Cards from "../Components/Cards/Cards";
import Graficos from "../Components/graficos/Graficos";
import '../styles/dashboard.css';

function Dashboard(){
    
    return(
        <>
        <div className="header-dashboard">
        <Cards />   
           
        </div>
        <Graficos />
       
        </>
    );
}

export default Dashboard;