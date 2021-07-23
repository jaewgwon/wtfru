import axios from "axios";

const service = axios.create({
    baseURL: "http://localhost:3000/",
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
    if (res.status === 200) {
        return res.data
    }
    return 
}, error => {
    return Promise.reject('Response error', error)
})

export default service;