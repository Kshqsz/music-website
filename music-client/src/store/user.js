const user = {
    state: {
        isLogin: false,
        userId: 0,
        username: "",
        user: {},
        //token: "",
        starList: [],
        avatar: "",
    },
    getters: {
        isLogin: state => state.isLogin,
        userId: state => state.userId,
        username: state => state.username,
        user: state => state.user,
        starList: state => state.starList,
        avatar: state => state.avatar,
        //token: state => state.token
    },
    mutations: {
        setAvatar: (state, avatar) => {state.avatar = avatar},
        setIsLogin: (state, isLogin) => {state.isLogin = isLogin},
        setUserId: (state, userId) => {state.userId = userId},
        setUsername: (state, username) => {state.username = username},
        setUser: (state, user) => {state.user = user},
        setStarList: (state, starList) => {state.starList = starList},
       // setToken: (state, token) => {state.token = token}
    }
}

export default user