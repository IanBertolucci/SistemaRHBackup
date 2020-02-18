import * as tipos from './mutations-types'

export default {
    [tipos.SET_PERFIL] (state, payload) {
        state.perfil = payload
    },
    [tipos.SET_TOKEN] (state, payload) {
        state.token = payload
    }
}