const express = require('express');
const productModel = require('../models/product');
const providerModel = require('../models/provider');
const router = express.Router();

// Criar Produto
router.post('/create/product', async (req, res) => {

    try{    
        var { description, _id } = req.body
        console.log(_id)
        if(_id) {s
            await productModel.updateOne({ _id }, {
                $set: req.body
            })
            return res.status(200).send({message: 'Produto alterado'});
        }
        else {
            if(await productModel.findOne({ description, deleted: false }))
                return res.status(400).send({message: 'Produto ja existento com essa descrição'});
            
            await productModel.create(req.body);
            return res.status(200).send({message: 'Produto criado'});
        }
    }   

    catch(err){
        console.log('err', err)
    }
})

// Ler Todos Produto Ativo
router.get('/get/products', async (req, res) =>{

    try{
        
        await productModel.find({deleted: false})
        .populate('provider')
        .exec(function(err, product) {
            if (product) {
               
                return res.status(200).send(product)                
            }
            else {
                return res.status(400).send({message: 'Produtos não encontrados!'})
            }
        })
    
    }

    catch(err){

    }
})

// Ler Produto Individuais Ativo
router.get('/readOne/product/:_id', async (req, res) =>{
    var _id = req.params;
    console.log(req.params)
    try{
        await productModel.findOne({ _id, deleted: false})
        .populate('provider')
        .exec(function(err, product) {
            if (product) {
                console.log('Response is ' + product);
                return res.status(200).send(product)                
            }
            else {
                return res.status(404).send({message: 'Produto não encontrado!'})
            }
        })
         
    }

    catch(err){
        console.log(err)
    }
})

// Ler Produto Deletado
router.post('/readDel/product', async (req, res) =>{
    var del = await productModel.find({deleted:true}) 

    try{
        if( del.length == 0 )
        return res.status(400).send({message: 'Não há produtos deletados.'})

        const product = await productModel.find({ deleted: true })
        return res.status(200).send(product)
    }

    catch(err){

    }
})

// Deletar Produto
router.put('/delete/product', async (req, res) => {
    var { _id } = req.body;

    try{
        var product = await productModel.findOne({ _id, deleted: false })
        
        if(!product)
            return res.status(404).send({message: 'Produto não encontrado'})

        if(product.stock > 0) 
            return res.status(400).send({message: 'Não é permitido excluir produtos disponíveis em estoque.'})
        
        await productModel.updateOne({_id}, {
            $set: {deleted:true}
        })
        return res.status(200).send({message: 'Produto deletado!'})
    }

    catch(err){

    }
})

module.exports = app => app.use('/', router);