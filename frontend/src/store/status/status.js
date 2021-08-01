import { getStatus, putStatus } from "../../api/index"

// state
const state = {
    uid: [],
    status: [],
    messgae: 'Status had been update'
}

// mutations
const mutations = {
    GET_STATE(state, status, uid) {
        state.status = status,
        state.uid = uid
    },
    PUT_STATE(state, status, uid, message) {
        state.status = status,
        state.uid = uid,
        state.message = message
    }
}

// actions
const actions = {
    GET_STATUS() {
        getStatus()
        .then(response => {
            uid.commit('GET_STATE',response.data);
        })
        .catch(error => {
            console.log(error)
        })
    },
    PUT_STATUS() {
        putStatus()
        .then(response => {
            uid.commit('PUT_STATE',response.data);
        })
        .catch(error => {
            console.log(error)
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
