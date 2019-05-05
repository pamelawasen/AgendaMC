const mongoose = require("../../database/db.connect");


const model = new mongoose.Schema({
    description: {type: String, trim: true, required: true},
    provider: {type: mongoose.Schema.Types.ObjectId, ref: 'provider', required: true},
    purchase_price: {type: String, trim: true, required: true},
    sale_price: {type: String, trim: true, required: true},
    stock: {type: Number, trim: true, required: true, default: 0},
    deleted: {type: Boolean, default: false},
})

module.exports = mongoose.model("product", model);