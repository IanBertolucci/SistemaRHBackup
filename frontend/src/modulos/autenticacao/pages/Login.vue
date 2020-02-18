<template>
	<div class="principal">
		<div class="login">
			<div class="login-title">
				<Logo/>
			</div>
			<div class="login-content">
				<div class="">
					<p> {{ text }} </p>
					<div class="login-text-fild align-center">
						<v-text-field
						label="Nome de usuário ou e-mail"
						outlined
						rounded
						clearable
						v-model = "perfil.email"
						></v-text-field>
					</div>
					<div class="login-text-fild align-center">
						<v-text-field
						type='password'
						label="Digite sua senha"
						outlined
						rounded
						clearable
						v-model = "perfil.senha"
						></v-text-field>
					</div>
				</div>
				<div class="login-buttons">
					<div class="login-element align-center">
						<Button
						:nome="button_entrar"
						v-bind:large="true"
						color="primary"
						@msg="login"
						/>
					</div>
					<div class="login-element align-center">
						<Button
						:nome="button_registrar"
						v-bind:large="true"
						color="primary"
						v-bind:text="true"
						@msg="registrar"
						/>
					</div>
					<div class="login-element align-center">
						<Button
						:nome="button_esqueci"
						v-bind:large="true"
						color="primary"
						v-bind:text="true"
						@msg="esqueciMinhaSenha"
						/>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import Logo from '@/components/utils/Logo'
	import Button from '@/components/utils/Button'
	import Perfil from '@/services/perfil.js'
	import { mapActions } from 'vuex'

	export default{
		data() {
			return {
				perfil: {
					email: '',
					senha: '',
				},
				text: 'Preencha os dados abaixo para fazer login',
				button_entrar: 'Login',
				button_registrar: 'Registrar-se',
				button_esqueci: 'Esqueci minha senha',
			}
		},
		methods: {
			...mapActions('autenticacao', ['ActionSetPerfil']),
			login(e) {
				Perfil.autenticar(this.perfil).then(resposta => {
					console.log(resposta.headers)
					if(resposta.status == 200) {
						this.ActionSetPerfil(resposta.data)
						this.$router.push({name: 'home'});
					}
				});

			},
			registrar() {
				console.log("Registrar")
			},
			esqueciMinhaSenha() {
				console.log("Esqueci")
			}
	},
	components: {
		Logo, Button
	}
}
</script>

<style>
.space {
	padding: 100px;
}
</style>