import Vue from 'vue'
import Vuex from 'vuex'
import song from './song'
import user from './user'
import home from './home'
import singer from './singer'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    song,
    user,
    home,
    singer
  },
  state: {
    token: '',
  },
  getters: {
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    },
  },
})

export default store