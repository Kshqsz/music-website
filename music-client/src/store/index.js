import Vue from 'vue'
import Vuex from 'vuex'
import song from './song'
import user from './user'
import home from './home'

Vue.use(Vuex)

const store =  new Vuex.Store({
  modules: {
    song,
    user,
    home
  }
})

export default store