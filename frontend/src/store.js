import { createStore } from 'vuex'

export default createStore({
  state: {
    message: 'Hello'
  },
  mutations: {
    changeMessage (state, newMsg) {
      state.message = newMsg
    }
  },
  actions: {
    callMutation ({ state, commit }, { newMsg }) {
      commit('changeMessage', newMsg)
    }
  },
  getters: {
    getMsg (state) {
      return `${state.message} => Length : ${state.message.length}`
    }
  }
})
