<template>
	<div class="menu">
		<div class="menu-nav">
			<div class="menu-item menu-text"> <h1> {{ nome }} </h1></div>
			<div class="menu-buttons">
				<div class="menu-item menu-button">
					<Button
					iconName="mdi-bell-outline"
					v-bind:small="true"
					v-bind:fab="true"
					color="white"
					v-bind:text="true"
					/>
				</div>
				<div class="menu-item menu-button">
					<Button
					iconName="mdi-settings"
					v-bind:small="true"
					v-bind:fab="true"
					color="white"
					v-bind:text="true"
					/>
				</div>
				<div class="menu-item menu-button">
					<Button
					iconName="mdi-exit-to-app"
					v-bind:small="true"
					v-bind:fab="true"
					color="white"
					v-bind:text="true"
					@msg="logout"
					/>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import Button from '../utils/Button.vue';
	export default{
		name: 'Menu',
		data() {
			return {
			}
		},
		components: {
			Button
		},
		props: {
			nome: {
				type: String,
				required: true,
			},
		},
		methods: {
			logout() {
				console.log("Saiu!!!")
			}
		}
	}
</script>

<style>

</style>