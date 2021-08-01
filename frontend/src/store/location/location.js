import { getLocation, postLocation, patchLocation } from "../../api/index"

// state
const state = {
    uid: [],
    locationId: [],
    timestamp: [],
    status: [],
    latitude: [],
    longitude: [],
    message: 'The Location has been updated',
    error: ''
}

// mutations
const mutations = {
    GET_CLIENT(state, status, uid, latitude, longitude, locationId, timestamp) {
        state.status = status,
        state.uid = uid,
        state.latitude = latitude,
        state.longitude = longitude,
        state.locationId = locationId,
        state.timestamp = timestamp
    },
    PUT_CLIENT(state, uid, latitude, longitude) {
        state.uid = uid,
        state.latitude = latitude,
        state.longitude = longitude
    },
    PUT_CLIENT(state, uid, latitude, longitude, message) {
        state.uid = uid,
        state.latitude = latitude,
        state.longitude = longitude,
        state.message = message
    },
    error(state, error) {
        return state.error = error
    }
}

// actions
const actions = {
    GET_LOCATION() {
        getLocation()
        .then(response => {
            uid.commit('GET_CLIENT',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    },
    POST_LOCATION() {
        postLocation()
        .then(response => {
            uid.commit('PUT_CLIENT',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    },
    PATCH_LOCATION() {
        patchLocation()
        .then(response => {
            uid.commit('PUT_CLIENT',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    },
}

// getters
const getters = {

}

export default {
  state,
  mutations,
  actions,
  getters
}
