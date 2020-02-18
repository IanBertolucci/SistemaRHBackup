<template>
	<div class="logo">
		<div class="logo-tipografia logo-principal">
			<span class="logo-imagem"></span>
			<h1 >{{ titulo }}</h1>
		</div>
		<div class="logo-tipografia logo-secundario">
			<h2> {{ subtitulo }} </h2>
		</div>
	</div>
</template>

<script>
export default{
	name: 'Logo',
	data() {
		return {
			titulo: 'Seleciona.',
			subtitulo: 'Seleção e Recrutamento'
		}
	},

}
</script>

<style>

</style>