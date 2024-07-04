const song = {
    state: {
        listOfSongs: [],
        isPlay: false,
        url: '',
        id: ''
    },
    getters: {
        listOfSongs: state => state.listOfSongs,
        isPlay: state => state.isPlay,
        url: state => state.url,
        id: state => state.id
    },
    mutations: {
        setListOfSongs: (state, listOfSongs) => {state.listOfSongs = listOfSongs},
        setIsPlay: (state, isPlay) => {state.isPlay = isPlay},
        setUrl: (state, url) => {state.url = url},
        setId: (state, id) => {state.id = id}
    }
}
export default song