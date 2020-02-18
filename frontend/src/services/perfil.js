import { http } from './config.js'

export default {

	listar:() => {
		return http.get('perfil/')
	},

	autenticar:(perfil) => {
		let email = perfil.email,
			senha = perfil.senha;
		return http.post('login/', { email, senha });
	}

}