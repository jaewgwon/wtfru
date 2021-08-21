import { getLocation, postLocation, patchLocation } from '../../api/index'

// state
const STATE = {
  uid: [],
  locationId: [],
  timestamp: [],
  status: [],
  latitude: [],
  longitude: [],
  message: [],
  error: ''
}

// mutations
const MUTATIONS = {
  GET_CLIENT (state, status, uid, latitude, longitude, locationId, timestamp) {
    state.status = status
    state.uid = uid
    state.latitude = latitude
    state.longitude = longitude
    state.locationId = locationId
    state.timestamp = timestamp
  },
  POST_CLIENT (state, uid, latitude, longitude, locationId, timestamp, status) {
    state.uid = uid
    state.latitude = latitude
    state.longitude = longitude
    state.locationId = locationId
    state.timestamp = timestamp
    state.status = status
  },
  PATCH_CLIENT (state, message) {
    state.message = message
  },
  error (state, error) {
    return (state.error = error)
  }
}

// actions
const ACTIONS = {
  GET_LOCATION (uid, context) {
    getLocation()
      .then((response) => { uid.commit('GET_CLIENT', response.data) })
      .catch((error) => { context.commit('error', error) })
  },
  POST_LOCATION (uid, context) {
    postLocation()
      .then((response) => { uid.commit('POST_CLIENT', response.data) })
      .catch((error) => { context.commit('error', error) })
  },
  PATCH_LOCATION (uid, context) {
    patchLocation()
      .then((response) => { uid.commit('PATCH_CLIENT', response.data) })
      .catch((error) => { context.commit('error', error) })
  }
}

export default {
  STATE,
  MUTATIONS,
  ACTIONS
}
