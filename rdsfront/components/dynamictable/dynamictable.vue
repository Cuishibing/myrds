<template>
  <div style="overflow-x:auto; overflow-y:auto; max-height:800px">
    <table style="width:100%"> 
      <tr>
        <th v-for="column in columnNames" :key="column">{{ column }}</th>
      </tr>
      <tr v-for="row in rows" :key="row">
        <td v-for="d in row" :key="d">{{ d }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  props: ["tableData"],

  data() {
    return {
      columnNames: [],
      rows: [],
    };
  },

  methods: {},

  watch: {
    tableData: function (n, o) {
      if (n.code != 200) {
        return;
      }
      let data = n.data;
      this.columnNames = data.columnNames;
      this.rows = data.rows;
    },
  },
};
</script>

 <style scoped>
table td,
th {
  min-width: 50px;
}

table,
table tr th,
table tr td {
  border: 1px solid black;
  padding: 5px;
}
table {
  text-align: left;
  border-collapse: collapse;
}

th {
  background-color: antiquewhite;
}
</style>