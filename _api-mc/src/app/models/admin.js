const mongoose = require("../../database/db.connect");


const model = new mongoose.Schema({
    name: {type: String, trim: true, required: true},
    email: {type: String, trim: true, required: true},
    password: {type: String, trim: true, required: true},
    deleted: {type: Boolean, default: false},
})

module.exports = mongoose.model("admin", model); //'admin' <= nome da collection no mongo