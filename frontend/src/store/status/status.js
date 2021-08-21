import { getStatus, putStatus } from '../../api/index'

// state
const STATE = {
  uid: [],
  status: [],
  messgae: [],
  error: ''
}

// mutations
const MUTATIONS = {
  GET_STATE (state, status, uid) {
    state.status = status
    state.uid = uid
  },
  PUT_STATE (state, status, uid, message) {
    state.status = status
    state.uid = uid
    state.message = message
  },
  error (state, error) {
    return (state.error = error)
  }
}

// actions
const ACTIONS = {
  GET_STATUS (uid, context) {
    getStatus()
      .then((response) => { uid.commit('GET_STATE', response.data) })
      .catch((error) => { context.commit('error', error) })
  },
  PUT_STATUS (uid, context) {
    putStatus()
      .then((response) => { uid.commit('PUT_STATE', response.data) })
      .catch((error) => { context.commit('error', error) });
  }
}

export default {
  STATE,
  MUTATIONS,
  ACTIONS
}
