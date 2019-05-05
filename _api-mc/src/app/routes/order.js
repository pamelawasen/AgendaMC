const express = require('express');
const orderModel = require('../models/order');

const router = express.Router();

// Criar Pedido
router.post('/order', async (req, res) => {

    try {

        if(req.body._id){
           
            await orderModel.updateOne({ _id: req.body._id }, {
                $set: req.body
            })
            return res.status(200).send({message: 'Pedido alterado'});

        } 
        else {
        
            const order = await orderModel.create(req.body);
            return res.status(200).send(order);
        }        
        
    }
    
    catch(err){
        console.log(err);
        console.log(req.body);

    }
})

router.get('/get/order/:_id', async (req, res) =>{
    
    var _id = req.params;

    try{

        const order = await orderModel.findOne({_id, deleted: false})

        if(!order)
            return res.status(400).send('Pedido não encontrado!')
        
        return res.status(200).send(order);
    }

    catch(err){

    }
})


router.get('/get/orders', async (req, res) =>{ 

    try{

        var order = await orderModel.find()

        if(!order)
            return res.status(404).send({ message: 'Não há pedidos!' })

        return res.status(200).send(order)
    }

    catch(err){

    }

})

// Deletar Pedido
router.post('/delete/order/:_id', async (req, res) => {
    var { _id } = req.params;

    try{
        if( !await orderModel.findOne({ _id, deleted: false }))
            return res.status(404).send({ message: 'Pedido não encontrado!' })

        await orderModel.updateOne({ _id }, {
            $set: { deleted:true }
        })
        return res.status(200).send({ message: 'Pedido deletado!' })
    }

    catch(err){

    }
})

module.exports = app => app.use('/', router);