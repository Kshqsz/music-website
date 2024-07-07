const user = {
    state: {
        isLogin: false,
        userId: 0,
        username: "",
        user: {},
        //token: "",
        starList: [],
    },
    getters: {
        isLogin: state => state.isLogin,
        userId: state => state.userId,
        username: state => state.username,
        user: state => state.user,
        starList: state => state.starList,
        //token: state => state.token
    },
    mutations: {
        setIsLogin: (state, isLogin) => {state.isLogin = isLogin},
        setUserId: (state, userId) => {state.userId = userId},
        setUsername: (state, username) => {state.username = username},
        setUser: (state, user) => {state.user = user},
        setStarList: (state, starList) => {state.starList = starList},
       // setToken: (state, token) => {state.token = token}
    }
}

export default user