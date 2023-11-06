const express = require('express');
const mongoose = require('mongoose');
require("dotenv").config();

//Importamos las rutas
const userRoutes = require("./routes/users");


const app = express();
const port = process.env.PORT || 9000;


//middlewares
app.use(express.json());
app.use('/api', userRoutes);





//routes

app.get('/', (req, res) => {
    res.send('Welcome to de API');
});

// MongoDb Connection 

mongoose.connect(process.env.MongoDbB_URI)
    .then(() => console.log('Connectado a la Base de datos'))
    .catch((err) => console.error(err)
    );

app.listen(port, () => console.log('Server is running on port', port));