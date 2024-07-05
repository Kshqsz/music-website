const home = {
    state: {
        activeIndex: ""
    },
    getters: {
        activeIndex: state => state.activeIndex
    },
    mutations: {
        setActiveIndex: (state, activeIndex) => {state.activeIndex = activeIndex}
    }
}

export default home