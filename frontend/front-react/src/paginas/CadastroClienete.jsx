import React from 'react';
import Button from '../Components/Button/Button';
import '../styles/cadastroCliente.css'

function cadastroCliente() {
    return (
        <>
            <div className="header"></div>

            <div className="section">
                <div className="container">
                    <h1 className="titulo">Cadastro de Clientes</h1>
                    <div className="form">
                        <div className="input">
                            <h3>Nome</h3>
                            <input type="text" />
                        </div>
                        <div className="input">
                            <h3>Telefone</h3>
                            <input type="text" />
                        </div>
                    </div>
                    <div className="form">
                        <div className="input">
                            <h3>Email</h3>
                            <input type="text" />
                        </div>
                        <div className="input">
                          <Button/>
                        </div>
                    </div>
                   
                </div>
            </div>
        </>

    );



}

export default cadastroCliente;