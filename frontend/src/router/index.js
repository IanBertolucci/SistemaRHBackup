import Vue from 'vue'
import store from '../store'
import VueRouter from 'vue-router'
import routes from './routes'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})


export default router


// router.beforeEach((to, from, next) => {
//   // mapState('autenticacao', ['usuario'])
//   // let status = store.getters.status
//   // console.log(next)
//   if(to.path == '/login'){
//     next()
//   }
//   else if(to.path == '/'){
//     router.replace('/login')
//   }
//   else{
//     router.replace('/')
//   }
// })
