import React from 'react';
import '../styles/cadastroVeiculo.css'

function CadastroVeiculo() {
    return (
        <>
            <div className="header"></div>

            <div className="section">
                <div className="container">
                    <h1 className="titulo">Cadastro de Veículos</h1>
                    <div className="form">
                        <div className="input">
                            <h3>Tipo de veículo</h3>
                            <input type="text" />
                        </div>
                        <div className="input">
                            <h3>Modelo de veículo</h3>
                            <input type="text" />
                        </div>
                    </div>
                    <div className="form">
                        <div className="input">
                            <h3>Marca do veículo</h3>
                            <input type="text" />
                        </div>
                        <div className="input">
                            <h3>Placa do veículo</h3>
                            <input type="text" />
                        </div>
                    </div>
                    <div className="form">
                        <div className="input">
                            <h3>Cliente</h3>
                            <input type="text" />
                        </div>
                        <div className="input">
                           
                           <button>Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </>

    );
}

export default CadastroVeiculo;