<template>
	<div class="navbar">
		<div class="navbar-logo align-center">
			<Logo />
		</div>
		<div class="">
			<div class="nav-item align-center">
				<Button
				:nome="botao_criar"
				v-bind:large="true"
				color="primary"
				@msg="novoProcesso"
				/>
			</div>
			<div class="nav-itens">
				<v-list-item-group v-model="item" color="primary">
					<v-list-item
					v-for="(item, i) in itens"
					:key="i"

					@click="mudarPagina(item.acao)"
					>
					<span class="barra"></span>
					<v-list-item-icon>
						<v-icon v-text>{{ item.icon }}</v-icon>
					</v-list-item-icon>

					<v-list-item-content>
						<v-list-item-title v-text>{{ item.nome }}</v-list-item-title>
					</v-list-item-content>
					</v-list-item>
				</v-list-item-group>
			</div>
			<div class="align-center">
				<Button
				iconName="mdi-arrow-collapse-left"
				v-bind:large="true"
				v-bind:fab="true"
				color="primary"
				v-bind:text="true"
				@msg="logout"
				/>
			</div>
		</div>
	</div>
</template>
<script>
	import Logo from './Logo.vue'
	import Button from './Button.vue'

	export default{
		name: 'Navbar',
		data() {
			return {
				botao_criar: 'Criar novo processo seletivo',
				itens: [
					{
						nome: 'Inicio',
						icon: 'mdi-home',
						acao: 'pag-inicio'
					},
					{
						nome: 'Processos em andamento',
						icon: 'mdi-format-list-bulleted',
						acao: 'pag-processo'
					},
					{
						nome: 'Histórico de processos',
						icon: 'mdi-history',
						acao: 'pag-processos'
					},
					{
						nome: 'Histórico de participantes',
						icon: 'mdi-account-multiple',
						acao: 'pag-participantes'
					},
					{
						nome: 'Resultados',
						icon: 'mdi-chart-areaspline-variant',
						acao: 'pag-resultados'
					},
				]
			}
		},
		components: {
			Logo, Button
		},
		methods: {
			novoProcesso(){
				console.log("Novo Processo")
			},
			logout(){
				console.log("Saiu")
			},
			mudarPagina(e){
				console.log(e)
			}
		}
	}
</script>
<style>
</style>