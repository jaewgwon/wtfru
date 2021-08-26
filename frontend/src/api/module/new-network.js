import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/'
const service = axios.create({
  baseURL: BASE_URL
});

service.interceptors.request.use(config => {
  if (localStorage.token) {
    config.headers.authorization = 'Bearer' + JSON.parse(localStorage.token)
  }
  return config
}, error => {
  return Promise.reject(error)
});

service.interceptors.response.use(res => {
  if (res.status >= 200 && res.status < 300) {
    return res.data
  } else throw Error('HTTP ERROR', res.status)
}, error => {
  return Promise.reject(error)
});

export const network = {
  get(key, param) {
    if(param) {
      return service.get(BASE_URL + key, param)
    } else {
      return service.get(BASE_URL + key)
    }
  },
  post(key, param) {
    return service.post(BASE_URL + key, param)
  },
  patch() {
    return service.patch(BASE_URL + key, param)
  }
}