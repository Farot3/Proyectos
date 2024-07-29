import React from 'react';
import Sidebar from './sidebar';
import ReporteCategorico from './graficapie';



function Reportes() {
 
    return (
        <div className="App">
            <Sidebar activeWindow="reportes" />
            <div className="content" style={{ overflowY: 'auto', maxHeight: '100vh' }}>
                <div style={{width: '500px', height: '500px', backgroundColor: 'white'}}>
                <h2 style={{ color: 'black'}}> Reporte Cantidad de posts por categorias</h2>
                <ReporteCategorico></ReporteCategorico>
                </div>
          </div>
       </div>

    )

}


export default Reportes;