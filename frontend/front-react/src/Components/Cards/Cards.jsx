import React from "react";
import './cards.css';
import iconDespesas from '../../assets2/img/dashboard/icone-despesas.png';
import iconReceitas from '../../assets2/img/dashboard/icone-receitas.png';
import iconSaldo from '../../assets2/img/dashboard/icone-total.png';


function Cards(){
    return(
    <div className="cards-dashboard">
        <div className="card">
            <div className="container-card">
                <div className="content-card">
                    <p>Saldo Atual</p>
                    <img src={iconSaldo} alt="saldo atual" />
                </div>
                <div className="valor">
                    <p>R$ 1.000,00</p>
                </div>
            </div>
        </div>
        <div className="card">
            <div className="container-card">
                <div className="content-card">
                    <p>Receitas</p>
                    <img src={iconReceitas} alt="receitas" />
                </div>
                <div className="valor">
                    <p>R$ 2.000,00</p>
                </div>
            </div>
        </div>
        <div className="card">
            <div className="container-card">
                <div className="content-card">
                    <p>Despesas</p>
                    <img src={iconDespesas} alt="despesas" />
                </div>
                <div className="valor">
                    <p>R$ -1.000,00</p>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Cards;