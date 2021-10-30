import { req } from '/js/req.js'
const host = 'http://localhost:8080'

const getAllDatabaseInfo = async () => {
    return await req(host + '/database/all', "GET")
}

const createDatabaseInfo = async (param) => {
    return await req(host + '/database/create', "POST", param)
}

const updateDatabaseInfo = async (param) => {
    return await req(host + '/database/update', "POST", param)
}

const deleteDatabaseInfo = async (param) => {
    return await req(host + '/database/delete', "POST", param)
}


export { getAllDatabaseInfo, createDatabaseInfo, updateDatabaseInfo, deleteDatabaseInfo }