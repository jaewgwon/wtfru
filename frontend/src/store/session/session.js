import { getSession, postSession, deleteSession } from '../../api/index'

// state
const STATE = {
  sessionId: [],
  uid: [],
  title: [],
  password: [],
  expired_date: [],
  link: [],
  status: [],
  accessToken: [],
  message: [],
  error: ''
}

// mutations
const MUTATIONS = {
  GET_HOST (state, title, link, status, uid, sessionId, password, accessToken) {
    state.title = title
    state.link = link
    state.status = status
    state.uid = uid
    state.sessionId = sessionId
    state.password = password
    state.accessToken = accessToken
  },
  POST_HOST (state, title, password, link, status, uid, sessionId) {
    state.title = title
    state.password = password
    state.link = link
    state.status = status
    state.uid = uid
    state.sessionId = sessionId
  },
  DELETE_HOST (state, uid, message) {
    state.uid = uid
    state.message = message
  },
  error (state, error) {
    return (state.error = error)
  }
}

// actions
const ACTIONS = {
  GET_SESSION (uid, context) {
    getSession()
      .then((response) => { uid.commit('GET_HOST', response.data) })
      .catch((error) => { context.commit('error', error) })
  },
  POST_SESSION (uid, context) {
    postSession()
      .then((response) => { uid.commit('POST_HOST', response.data) })
      .catch((error) => { context.commit('error', error) })
  },
  DELETE_SESSION (uid, context) {
    deleteSession()
      .then((response) => { uid.commit('DELETE_HOST', response.data) })
      .catch((error) => { context.commit('error', error) })
  }
}

export default {
  STATE,
  MUTATIONS,
  ACTIONS
}
