<template>
  <div>
    <div class="data">
      <div class="box1">
        <i class="el-icon-user"></i>
        <div>
          <strong>{{ usernumber }}</strong>
          <br />
          用户总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-mic"></i>
        <div>
          <strong>{{ songnumber }}</strong>
          <br />
          歌曲总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-headset"></i>
        <div>
          <strong>{{ singernumber }}</strong>
          <br />
          歌手总数
        </div>
      </div>
      <div class="box1">
        <i class="el-icon-monitor"></i>
        <div>
          <strong>{{ 0 }}</strong>
          <br />
          视频总数
        </div>
      </div>
    </div>
    <div class="chart">
      <div class="box2">
        <div id="his"></div>
      </div>
      <div class="box2">
        <div id="pie2"></div>
      </div>
      <div class="box2">
        <div id="ma"></div>
      </div>
      <div class="box2">
        <PieIndex :data="usersexlist"></PieIndex>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import axios from "@/utils/axios";
import PieIndex from "@/components/PieIndex.vue";
export default {
  components: {
    PieIndex,
  },

  data() {
    return {
      usernumber: "1",
      songnumber: "1",
      singernumber: "1",
      mvnumber: "1",
      usersexlist: { man: 20, female: 10 },
      singersexlist: [],
      singersonglist: [],
      collectonsongslist: [],
    };
  },
  methods: {
    async countSex() {
      await axios.get("/admin/sexRatio").then((res) => {
        if (res.data.code === 0) {
          this.singersexlist = res.data.data;
          let len = this.singersexlist.length;
          for (var i = 0; i < len; i++) {
            if (this.singersexlist[i].sex == 1) {
              this.singersexlist[i].sex = "男";
            } else if (this.singersexlist[i].sex == 2) {
              this.singersexlist[i].sex = "女";
            }
          }
        }
      });
    },
    async singerSong() {
      await axios.get("/admin/singerSong").then((res) => {
        if (res.data.code === 0) {
          this.singersonglist = res.data.data;
        }
      });
    },
    async songStar() {
      await axios.get("/admin/countStar").then((res) => {
        if (res.data.code === 0) {
          this.collectonsongslist = res.data.data;
        }
      });
    },
    countUser() {
      axios.get("/admin/countUser").then((res) => {
        if (res.data.code === 0) {
          this.usernumber = res.data.data;
        }
      });
    },
    countSinger() {
      axios.get("/admin/countSinger").then((res) => {
        if (res.data.code === 0) {
          this.singernumber = res.data.data;
        }
      });
    },
    countSong() {
      axios.get("/admin/countSong").then((res) => {
        if (res.data.code === 0) {
          this.songnumber = res.data.data;
        }
      });
    },
    initPie2() {
      var myChart = echarts.init(document.getElementById("pie2"));
      myChart.setOption({
        title: {
          text: "歌手性别比",
          x: "center",
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          left: "left",
        },
        series: [
          {
            type: "pie",
            data: this.singersexlist.map((item) => ({
              value: item.cnt,
              name: item.sex,
            })),
            radius: "50%",
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0,0,0,0.5)",
              },
            },
          },
        ],
      });
    },
    inithi2() {
      const keys = this.singersonglist.map((item) => item.singerName);
      const values = this.singersonglist.map((item) => item.cnt);
      var myChart = echarts.init(document.getElementById("his"));
      myChart.setOption({
        title: {
          text: "歌手歌曲数",
          x: "center",
        },
        tooltip: {},
        xAxis: {
          type: "category",
          data: keys,
        },
        yAxis: {},
        series: [
          {
            name: "数量",
            type: "bar",
            data: values,
          },
        ],
      });
    },
    inithi1() {
      const keys = this.collectonsongslist.map((item) => item.songName);
      const values = this.collectonsongslist.map((item) => item.cnt);
      var myChart = echarts.init(document.getElementById("ma"));
      myChart.setOption({
        title: {
          text: "歌曲收藏榜",
        },
        tooltip: {},
        xAxis: {
          data: keys,
        },
        yAxis: {},
        series: [
          {
            name: "数量",
            type: "bar",
            data: values,
          },
        ],
      });
    },
  },
  async created() {
    this.countUser();
    this.countSinger();
    this.countSong();
    await this.countSex();
    await this.singerSong();
    await this.songStar();
    this.initPie2();
    this.inithi2();
    this.inithi1();
  },
};
</script>


<style scoped>
#ma {
  width: 600px;
  height: 300px;
}
#his {
  width: 600px;
  height: 300px;
}
#pie2 {
  width: 600px;
  height: 300px;
}
.data {
  display: flex;
  justify-content: space-between;
  padding: 0 60px;
}
i {
  font-size: 50px;
  margin-right: 50px;
}
.box1 {
  display: flex;
  border: 1px solid black;
  padding: 20px;
}
.chart {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  margin-top: 30px;
}
.box2 {
  margin-bottom: 30px;
  width: 600px;
  height: 300px;
  border: 1px solid black;
}
</style>