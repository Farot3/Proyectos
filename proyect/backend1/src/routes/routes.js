const express = require('express');

const router = express.Router();

const { Registro, GetUsers, Login, calficacion } = require('../controladores/ingreso');

const { DeleteUser, DeletePost } = require('../controladores/delete');

const { UpdateUser } = require('../controladores/update');

const { Publicar, GetPosts, reporteCategoria, Comentar, Like } = require('../controladores/posts');



router.post('/Registro', Registro)
router.post('/Login', Login)
router.get('/users', GetUsers)
router.delete('/delete_user', DeleteUser)
router.delete('/delete_post', DeletePost)
router.put('/update', UpdateUser)
router.post('/publicar', Publicar)
router.get('/posts', GetPosts)
router.get('/redcategoria', reporteCategoria)

router.post('/comentar', Comentar)
router.post('/like', Like)

router.post('/calificacion', calficacion)


module.exports = router