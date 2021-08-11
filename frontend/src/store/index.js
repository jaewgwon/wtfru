import Vue from 'vue'
import Vuex from 'vuex'

import LocationStore from './location'
import SessionStore from './session'
import StatusStore from './status'

Vue.use(Vuex)

export default new Vuex.Store({
  moduled: {
    location: LocationStore,
    session: SessionStore,
    status: StatusStore,
  }
})
