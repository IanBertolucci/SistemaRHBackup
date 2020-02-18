<template>
	<div class="button">

		<v-btn
		rounded
		:large = "large"
		:small = "small"
		:color = "color"
		:fab = "fab"
		:width = "width"
		:disabled = "disabled"
		:outlined = "outlined"
		:text = "text"
		:icon = "icon"
		@click = "clicked"
		>
		<v-icon>

			{{ iconName  }}

		</v-icon>

		{{ nome }}

	</v-btn>

</div>
</template>

<script>
export default{
	name: 'Button',
	data() {
		return {

		}
	},
	props: {
		nome: {
			type: String,
			default: '',
		},
		large: {
			type: Boolean,
			default: false,
		},
		small: {
			type: Boolean,
			default: false,
		},
		fab: {
			type: Boolean,
			default: false,
		},
		iconName: {
			type: String,
			default: '',
		},
		icon: {
			type: Boolean,
			default: false,
		},
		color: {
			type: String,
			default: null,
		},
		width: {
			type: Number,
			default: null,
		},
		disabled: {
			type: Boolean,
			default: false,
		},
		text: {
			type: Boolean,
			default: false,
		},
		outlined: {
			type: Boolean,
			default: false,
		}
	},
	methods: {
		clicked() {
			this.$emit('msg', true);
		}
	}
}
</script>

<style>

</style>