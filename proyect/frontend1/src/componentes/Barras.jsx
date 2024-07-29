import React from "react";
import { Line } from 'react-chartjs-2';
import {    Chart,    CategoryScale,    LinearScale,   PointElement,  LineElement,    Title,    Tooltip,    Legend,  } from 'chart.js';

  
Chart.register(    CategoryScale,    LinearScale,    PointElement,    LineElement,    Title,    Tooltip,    Legend  );


const EjemploLineas = () => {

    const data = {
        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo'],
        datasets: [
            {
                label: 'ventas',
                data: [12,19,3,5,2],
                borderColor: 'rgb(75,192,192)',
                backgroundColor: 'rgb(75, 192, 192, 0.2)', 
            },
        ],
    }

    return(
        <div style={{width: '500px', height: '500px', backgroundColor: 'white'}}>
            <h2>Gráfica de ejemplo de ventas</h2>
            <Line data = {data}/>
        </div>
    )
}
export default EjemploLineas;
