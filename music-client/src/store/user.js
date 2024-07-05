const user = {
    state: {
        isLogin: false
    },
    getters: {
        isLogin: state => state.isLogin
    },
    mutations: {
        setIsLogin: (state, isLogin) => {state.isLogin = isLogin}
    }
}

export default user