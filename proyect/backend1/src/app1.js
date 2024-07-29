const express = require('express');
const cors = require('cors')


const app1 = express();

const bodyParser = require('body-parser'); 
app1.use(bodyParser.json({ limit: '15mb' }));

const PORT = 5000;

app1.use(express.json());
app1.use(cors())


const Router = require ("./routes/routes")
app1.use(Router);

app1.listen(PORT, () => {
     console.log(`Servidor corriendo en el puerto http://localhost:${PORT}`);
})

