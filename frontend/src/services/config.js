import axios from 'axios'

const MESSAGE = "msg"
const MSG_SOURCE = "http://localhost:8080/lista"

class MsgService {
	getMsg(){
		return axios.get(`${MSG_SOURCE}`)
	}
}

export default new MsgService();

export const http = axios.create({
	baseURL: 'http://localhost:8080/'
})



