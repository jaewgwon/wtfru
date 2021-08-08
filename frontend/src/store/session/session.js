import { getSession, postSession, deleteSession } from "../../api/index";

// state
const state = {
    sessionId: [],
    uid: [],
    title: [],
    password: [],
    expired_date: [],
    link: [],
    status: [],
    accessToken: [],
    message: 'The seesion has been deleted',
    error: ''
}

// mutations
const mutations = {
    GET_HOST(state, title, link, status, uid, sessionId, password, accessToken) {
        state.title = title,
        state.link = link,
        state.status = status,
        state.uid = uid,
        state.sessionId = sessionId,
        state.password = password,
        state.accessToken = accessToken
    },
    POST_HOST(state, title, password, link, status, uid, sessionId) {
        state.title = title,
        state.password = password,
        state.link = link,
        state.status = status,
        state.uid = uid,
        state.sessionId = sessionId
    },
    DELETE_HOST(state, uid, message) {
        state.uid = uid
        state.message = message
    },
    error(state, error) {
        return state.error = error
    }
}

// actions
const actions = {
    GET_SESSION() {
        getSession()
        .then(response => {
            uid.commit('GET_HOST',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    },
    POST_SESSION() {
        postSession()
        .then(response => {
            uid.commit('POST_HOST',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    },
    DELETE_SESSION() {
        deleteSession()
        .then(response => {
            uid.commit('DELETE_HOST',response.data);
        })
        .catch(error => {
            context.commit('error', error)
        })
    }
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
