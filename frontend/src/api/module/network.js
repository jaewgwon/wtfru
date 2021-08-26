import axios from 'axios'

const API_URL = 'http://localhost:8080/api/session'

export const network = {
  createSession (host) {
    return axios.post(API_URL, {
      title: host.title,
      password: host.password
    })
  },
  checkDuplicateTitle (host) {
    return axios.post(API_URL, {
      title: host.title
    })
  },
  joinSession (host) {
    return axios.post(API_URL, {
      title: host.title,
      password: host.password
    })
      .then(this.handleResponse)
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem('host', JSON.stringify(response.data))
        }
        return response.data
      })
  },
  outSession () {
    localStorage.removeItem('host')
  },
  handleResponse (response) {
    if (response.status === 401) {
      this.outSession()
      location.reload(true)
      const error = response.data && response.data.message
      return Promise.reject(error)
    }
    return Promise.resolve(response)
  }
}
