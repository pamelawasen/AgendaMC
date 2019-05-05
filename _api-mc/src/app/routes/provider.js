const express = require('express');
const providerModel = require('../models/provider');
const productModel = require('../models/product');

const router = express.Router();


/*
* Rota para criaçao de um novo fornecedor
*/
router.post('/provider', async (req, res) => {
    //desestruturação no req.body
    const { email, cnpj, _id } = req.body;
    
    try{
        
        if(_id) {
            await providerModel.updateOne( { _id: _id } , { 
                $set: req.body 
            })
            return res.status(200).send({message: `Fornecedor alterado com sucesso`})
        } 
        else {
            if( await providerModel.findOne({cnpj}) )
                return res.status(400).send({message: 'CNPJ já cadastrado.'}); //caso tenha o mesmo cnpj no banco envia msg de erro e codigo 400

            //cria o fornecedor com os dados enviados pelo req.body
            const provider = await providerModel.create(req.body);
            //retorna status 200 e o fornecedor criado
            return res.status(200).send(provider);
        }
        
        

    }
    catch(err){
        //aqui vamos validar os erros

    }
})

/*
* Rota para deletar um  fornecedor
*/
router.post('/delete/provider/:_id', async (req, res) => {
    //desestruturação no req.params
    var { _id } = req.params;
    
    try {

        var provider = await providerModel.findById({ _id, deleted: false });
        //verifica se existe um fornecedor com o id passado
        if(!provider)
            return res.status(404).send({message: 'Fornecedor não encontrado'});//caso nao existe manda msg de erro      

        await providerModel.updateOne({_id}, {
            $set: {deleted: true}
        })

        return res.status(200).send({message: "Fornecedor deletado com sucesso"})

    }
    catch(err){
        //aqui vamos validar os erros

    }
})

/*
* Rota para trazer o fornecedor com respectivo ID
 */
router.get('/get/provider/:_id', async(req, res) => {
    try{
        
        const { _id } = req.params

        const provider = await providerModel.findOne({ _id, deleted: false });
        if(!provider)
            return res.status(404).send({message: 'Fornecedor não encontrado!'});

        return res.status(200).send(provider);
    }   
    catch(err){

    }
})


/*
* Rota para trazer todos os fornecedores
 */
router.get('/get/providers', async(req, res) => {
    
    try{

        const provider = await providerModel.find({ deleted: false });
        if(!provider)
            return res.status(404).send({message: 'Nenhum fornecedor encontrado'});

        return res.status(200).send(provider);
    }   
    catch(err){

    }
})

module.exports = app => app.use('/', router); 