import axios from 'axios'

const service = axios.create({
  baseURL: 'http://localhost:8080/'
})

service.interceptors.request.use(config => {
  if (localStorage.token) {
    config.headers.authorization = 'Bearer' + JSON.parse(localStorage.token)
  }
  return config
}, error => {
  return Promise.reject(error)
})

service.interceptors.response.use(res => {
  if (res.status >= 200 && res.status < 300) {
    return res.data
  } else throw Error('HTTP ERROR', res.status)
}, error => {
  return Promise.reject(error)
})

export default service
