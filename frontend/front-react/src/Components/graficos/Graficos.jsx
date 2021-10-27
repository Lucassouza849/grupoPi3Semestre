import React from "react";
import './graficos.css';
import Chart from 'react-apexcharts';


function Graficos(){

    //grafico em pizza
    const mockData = {
        series: [477138, 499928, 444867],
        labels: ['Saldo', 'Despesas', 'Receitas']
    }
    
    const options = {
        legend: {
            show: false
        }
    }

    //grafico em barra
    const optionsBar = {
        xaxis: {
            categories: ['', '']
        },
        yaxis: {
            show: false
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '20%',          
                }
        },
        legend: {
            show: false
        },
        fill:{
            colors: ['#0bf332', '#F3340B'],
        },
     
    };
    
    const mockDataBar = {
        labelsTwo: {
            categories: ['Receitas', 'Despesas']
        },
        seriesTwo: [

            {
                name: "Receitas",
                data: [43.6],
                               
            },
            {
                name: "Despesas",
                data: [63.6],
                               
            }
        ],
    
      
    };

    

    
    return(
        <>
        <div className="graficos">

            <div className="container-grafico-bar">
                <div className="titulo-grafico">
                    <h4>Balanço mensal</h4>
                </div>
    
                <Chart className = "chart-bar"
                    options={{ ...optionsBar, labelsTwo: mockDataBar.labelsTwo}}
                    series={mockDataBar.seriesTwo}
                    type="bar"
                    height="280px" width="300px" />
                
                
            </div>
            

            <div className="container-grafico">
                <div className="titulo-grafico">
                    <h4>Receitas Por Categoria</h4>
                </div>
    
                <Chart
                    options={{ ...options, labels: mockData.labels}}
                    series={mockData.series}
                    type="donut"
                    height="280px" />
        
            </div>
        </div>                      
        </>
    );
}

export default Graficos;