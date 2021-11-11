import React from 'react';
import Table from '../Components/Table/TableFourFields';
import '../styles/extrato.css'

function Extrato() {
    return (
        <>
    <div class="top"></div>

<div class="filtro">
    <div class="container-filtro">
        <button class="exp-bt">Exportar arquivo</button>
        <div>
            <input type="checkbox" name="scales" id="scales"></input>
            <label >Cliente</label>
        </div>
        <div>
            <input type="checkbox" name="scales" id="scales"></input>
            <label >Valor</label>
        </div>
        <div class="text_fild-div">
            <i class="fa fa-search" aria-hidden="true"></i>
            <input type="text" class="text-filed"></input>
        </div>
        <button class="btn-aplicar">Filtrar</button>    
    </div>
</div>

        <div class="container">
            <Table/>
        </div>
        </>
    );

}
