<template>
  <div id="pie"></div>
</template>

<script>
import * as echarts from "echarts";

export default {
  props: ["data"],
  mounted() {
    var myChart = echarts.init(document.getElementById("pie"));
    myChart.setOption({
      title: {
        text: "用户性别比",
        x: "center",
      },
      series: [
        {
          type: "pie",
          data: [
            {
              value: this.data.man,
              name: "男",
            },
            {
              value: this.data.female,
              name: "女",
            },
          ],
          tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)",
          },
          radius: "50%",
        },
      ],
    });
  },
};
</script>

<style scoped>
#pie {
  width: 600px;
  height: 300px;
}
</style>
