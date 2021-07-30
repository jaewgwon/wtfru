import { createStore } from 'vuex'

export default createStore({
  state () {
    return {
      count: 0
    }
  },
  mutations: {
    increment (state) {
      state.count++
      console.log(state.count)
    }
  },
  actions: {
  },
  modules: {
  }
})
