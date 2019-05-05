const mongoose = require("../../database/db.connect");

const address = new mongoose.Schema({
    street: {type: String, trim: true, require: true},
    house_number: {type: Number, trim: true, require: true},
    zip_code: {type: String, trim: true, require: true},
    complement: {type: String, trim: true},
    district: {type: String, trim: true, require: true},
    city: {type: String, trim: true, require: true},
    _id: false
})

module.exports = address;