<template>
  <div class="home">
  	<Menu v-bind:nome="nome"/>
  	<!-- <div class="navbar">
  	</div> -->
    <Navbar />

  </div>
</template>

<script>

  import Menu from '@/components/utils/Menu.vue'
  import Navbar from '@/components/utils/Navbar.vue'
  import { mapState } from 'vuex'

  export default {
    name: 'home',
    components: {
     Menu, Navbar
   },
   data() {
     return {
       nome: "Um usuário de teste"
     }
   },
   computed: {
     ...mapState('autenticacao', ['perfil']),
    // nome() {
    //   return this.usuario.nome
    // }
  }
}
</script>
