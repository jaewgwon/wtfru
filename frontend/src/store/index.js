import Vue from 'vue'
import Vuex from 'vuex'

import LocationStore from './location/location'
import SessionStore from './session/session'
import StatusStore from './status/status'

Vue.use(Vuex)

export default new Vuex.Store({
  moduled: {
    location: LocationStore,
    session: SessionStore,
    status: StatusStore
  }
})
