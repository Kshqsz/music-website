const song = {
    state: {
        listOfSongs: [],
        isPlay: false,
        url: '',
        id: '',
        playButtonUrl: '#icon-bofang',
        volume: 0, // 音量
        duration: 0, // 音乐时长
        curTime: 0, // 当前音乐的播放位置
        changeTime: 0, // 指定播放时刻
        autoNext: true, // 用于触发自动播放下一首
        title: '', //  歌名
        artist: '', //  歌手名
        picUrl: '', // 歌曲图片
    
        /** 音乐列表信息 */
        currentPlayList: [], // 当前播放列表
        songDetails: null, // 单个歌单信息
        currentPlayIndex: -1, // 当前歌曲在歌曲列表的位置
        searchSongList: [],
    },
    getters: {
        searchSongList: state => state.searchSongList,
        title: state => state.title,
        artist: state => state.artist,
        picUrl: state => state.picUrl,
        listOfSongs: state => state.listOfSongs,
        isPlay: state => state.isPlay,
        url: state => state.url,
        id: state => state.id,
        lyric: (state) => state.lyric,
        playButtonUrl: (state) => state.playButtonUrl,
        volume: (state) => state.volume,
        duration: (state) => state.duration,
        curTime: (state) => state.curTime,
        changeTime: (state) => state.changeTime,
        autoNext: (state) => state.autoNext,
    
        currentPlayList: (state) => state.currentPlayList,
        songDetails: (state) => state.songDetails,
        currentPlayIndex: (state) => state.currentPlayIndex,
    },
    mutations: {
        setSearchSongList: (state, searchSongList) => {state.searchSongList = searchSongList},
        
        setTitle: (state, title) => {state.title = title},

        setPicUrl: (state, picUrl) => {state.picUrl = picUrl},

        setArtist: (state, artist) => {state.artist = artist},

        setListOfSongs: (state, listOfSongs) => {state.listOfSongs = listOfSongs},
        
        setPlayButtonUrl: (state, playButtonUrl) => {state.playButtonUrl = playButtonUrl},

        setIsPlay: (state, isPlay) => {state.isPlay = isPlay},

        setUrl: (state, url) => {state.url = url},

        setId: (state, id) => {state.id = id},

        setAutoNext: (state, autoNext) => {state.autoNext = autoNext;},

        setLyric: (state, lyric) => {state.lyric = lyric;},

        setPlayBtnIcon: (state, playBtnIcon) => {state.playBtnIcon = playBtnIcon;},

        setVolume: (state, volume) => {state.volume = volume;},

        setDuration: (state, duration) => {state.duration = duration;},
        
        setCurTime: (state, curTime) => {state.curTime = curTime;},

        setChangeTime: (state, changeTime) => {state.changeTime = changeTime;},

        setCurrentPlayList: (state, currentPlayList) => {state.currentPlayList = currentPlayList;},

        setSongDetails: (state, songDetails) => {state.songDetails = songDetails;},
        
        setCurrentPlayIndex: (state, currentPlayIndex) => {state.currentPlayIndex = currentPlayIndex;},
    }
}
export default song