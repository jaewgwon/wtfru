import axios from "axios";

const service = axios.create({
    baseURL: "http://localhost:8080/",
})

service.interceptors.request.use(config => {
    if (localStorage.token) {
        config.headers['authorization'] = 'Bearer' + JSON.parse(localStorage.token)
    }
    return config
}, error => {
    return Promise.reject('Requset error', error)
})

service.interceptors.response.use(res => {
    if (200 <= res.status && 300 > res.status) {
        return res.data
    } else throw Error("HTTP ERROR", res.status)

}, error => {
    return Promise.reject('Response error', error)
})

export default service;