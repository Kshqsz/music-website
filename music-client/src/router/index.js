import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import SongView from '@/views/SongView.vue'
import HomePageView from '@/views/HomePageView.vue'
import SingerView from '@/views/SingerView.vue'
import SingerDetail from '@/components/SingerDetail.vue'
import SearchResult from '@/components/SearchResult.vue'
import PersonDetail from '@/components/PersonDetail.vue'
import MyStar from '@/components/MyStar.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomeView,
    redirect: '/login',
    children: [
      { path: '/login', name: 'login', component: LoginView },
      { path: '/register', name: 'register', component: RegisterView },
      { path: '/song', name: 'song', component: SongView },
      { path: '/singer', name: 'singer', component: SingerView },
      { path: '/homePage', name: 'homePage', component: HomePageView },
      { path: '/singer-detail/:id', name:"singer-detail", component: SingerDetail},
      { path: '/searchResult', name: 'searchResult', component: SearchResult},
      { path: '/personDetail', name: 'personDetail', component: PersonDetail},
      { path: '/myStar', name: "myStar", component: MyStar},
    ]
  },
  {
    path: '/',
    redirect: '/home'
  }
]

const router = new VueRouter({
  routes
})

export default router
