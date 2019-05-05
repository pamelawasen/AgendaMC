const mongoose = require("../../database/db.connect");
const addressModel = require("./address");


const model = new mongoose.Schema({
    name: {type: String, trim: true, required: true},
    email: {type: String, trim: true, required: true},
    phone: {type: String, trim: true},
    cell_phone: {type: String, trim: true, required: true},
    cpf: {type: String, trim: true, required: true},
    address: {
        street: {type: String, trim: true, require: true},
        house_number: {type: Number, trim: true, require: true},
        zip_code: {type: String, trim: true, require: true},
        complement: {type: String, trim: true},
        district: {type: String, trim: true, require: true},
        city: {type: String, trim: true, require: true},
        _id: false
    },
    deleted: {type: Boolean, default: false}
})

module.exports = mongoose.model("client", model); //'client' <= nome da collection no mongo