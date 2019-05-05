const express = require('express');
const router = express.Router();

const adminModel = require('../models/admin');
const bcrypt = require('bcrypt-nodejs');

router.post('/admin', async (req, res) => {
 
    try {

        const { email, password, _id } = req.body;

        //cria um hash da senha do admin
        var hash = await bcrypt.hashSync(password);
        req.body.password = hash;

        if(_id) {
            await adminModel.updateOne( { _id: _id } , { 
                $set: req.body 
            })
            return res.status(200).send({message: `${req.body.name} alterado com sucesso`})
        }
        else {
            if(await adminModel.findOne({ email, deleted: false }))
                return res.status(400).send({message: 'Email já em uso.'})

            await adminModel.create(req.body);
            return res.status(200).send({message: `${req.body.name} criado com sucesso`});  
        }

    }
    catch(err) {
        console.log(err);
    }
    
})


/*
* Rota para trazer os admins
 */
router.get('/get/admin', async(req, res) => {
    try{
        
        const admins = await adminModel.find({deleted: false});
        if(!admins)
            return res.status(404).send({message:  'Não existe administradores salvos.'});    
        
        return res.status(200).send(admins);
    }   
    catch(err){

    }
})


/*
* Rota para trazer o admin com respectivo ID
 */
router.get('/get/admin/:_id', async(req, res) => {
    try{
        
        const _id = req.params

        const admin = await adminModel.findById(_id);
        if(admin)
            return res.status(200).send(admin);
    }   
    catch(err){

    }
})


/*
* Rota para deletar o admin com respectivo ID
 */
router.post('/delete/admin/:_id', async(req, res) => {
    try{
        
        const _id = req.params 
        
        if( !await adminModel.findOne({_id, deleted: false}) )
            return res.status(404).send({message: 'Usuário não encontrado!'});    

        await adminModel.updateOne({_id}, {
            $set: {deleted: true}
        })

        return res.status(200).send({message: `Administrador deletado com sucesso`});
    }   
    catch(err){
        
    }
})

module.exports = app => app.use('/', router); 