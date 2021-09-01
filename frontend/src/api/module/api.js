import { Key } from './key'
import { network } from './new-network'

const config = {
  headers: { Authorizatoin: `Bearer ${localStorage.token}` }
}

export const api = {
  postSession (host) {
    return network.post(Key.SESSION, {
      title: host.title,
      password: host.password
    })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem(JSON.stringify(response.data))
        }
        return response.data
      })
  },
  getSession (host) {
    return network.get(Key.SESSION, {
      title: host.title,
      password: host.password
    })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem(JSON.stringify(response.data))
        }
        return response.data
      })
  },
  deleteSession (host) {
    return network.delete(Key.SESSION, {
      uid: host.uid
    }, config)
  },
  getLocation () {
    return network.get(Key.LOCATION, null, config)
  },
  postLocation (client) {
    return network.post(Key.LOCATION, {
      latitude: client.latitude,
      longitude: client.longitude
    }, config)
  },
  patchLocation (client) {
    return network.patch(Key.LOCATION, {
      uid: client.uid
    }, config)
  },
  getStatus () {
    return network.get(Key.STATUS, null, config)
  },
  putStatus (host) {
    return network.put(Key.STATUS, {
      uid: host.uid,
      status: host.status
    }, config)
  }
}
