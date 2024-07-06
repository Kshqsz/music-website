const singer = {
    state: {
        searchSingerList: []
    },
    getters: {
        searchSingerList: state => state.searchSingerList
    },
    mutations: {
        setSearchSingerList: (state, searchSingerList) => {state.searchSingerList = searchSingerList}
    }
}
export default singer