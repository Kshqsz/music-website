import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '@/views/LoginIndex.vue'
import layout from '@/views/LayoutIndex.vue'
import singer from '@/views/SingerIndex.vue'
import song from '@/views/SongIndex.vue'
import user from '@/views/UserIndex.vue'
import home from '@/views/HomeIndex.vue'




Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/layout',
    name: 'home',
    component: layout,
    children: [
      {path: '/home', component: home},
      {path: '/singer', component: singer},
      {path: '/song' , component: song},
      {path: '/user', component: user}
    ]
  }
 
]

const router = new VueRouter({
  routes
})

export default router
