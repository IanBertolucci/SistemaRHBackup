import * as tipos from './mutations-types'

export const ActionSetPerfil = ({ commit }, payload) => {
    commit(tipos.SET_PERFIL, payload)
}

export const ActionSetToken = ({ commit }, payload) => {
    commit(tipos.SET_TOKEN, payload)
}