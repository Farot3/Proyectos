import React, {useState, useEffect} from 'react';
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';

ChartJS .register(ArcElement, Tooltip, Legend);

const ReporteCategorico = () => {

    const [claves, setClaves] = useState([])
    const [valores, setValores] = useState([])

    useEffect(() => {
        //  setPosts(exampleData);
    
          const fetchData = async () => {
          try {
              const response = await fetch('http://localhost:5000/redcategoria', {
              method: 'GET',
            });
            if (response.ok) {
              const data = await response.json();
              console.log(data.countByCategory)
              setClaves(Object.keys(data.countByCategory))
              setValores(Object.values(data.countByCategory))
              
             }
             } catch (error) {
           console.error('Error al realizar la solicitud:', error);
          }
      };
    
    fetchData();
    
      }, [])

    const data= {
        labels: claves,
        datasets: [
            {
            label: '# of Votes',
            data: valores,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
            ],
            borderWidth: 1,
            },
        ],
    }

    return  (
        <div style={{width: '400px', height: '400px'}}>
            <Pie data = {data}/>
        </div>


    )
};

export default ReporteCategorico;