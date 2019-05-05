const mongoose = require("../../database/db.connect");
 
const model = new mongoose.Schema({
    client: {type:String,trim: true},
    adress:{type:String,trim: true},
    date: {type: Date, default: Date.now},
    typeService:{type:String,trim: true},
    
    
})

module.exports = mongoose.model("order", model);