import { Key } from './key'
import { network } from './network'

const config = {
  headers: { Authorizatoin: `Bearer ${localStorage.token}` }
}

export const api = {
  postSession (host) {
    return network.post(Key.SESSION, {
      title: host.title,
      password: host.password
    })
  },
  postSessionJoin (host) {
    return network.get(Key.JOIN, {
      title: host.title,
      password: host.password
    })
  },
  getSession (host) {
    return network.get(Key.SESSION, {
      params: {
        title: host.title
      }
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
    })
  },
  patchLocation (client) {
    return network.patch(Key.LOCATION, {
      uid: client.uid,
      latitude: client.latitude,
      longitude: client.longitude
    })
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
