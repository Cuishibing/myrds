<template>
  <div>
    <iframe
      id="editor_frame"
      src="/editor/editor.html"
      style="width: 100%; height: 500px"
    />
    <button @click="runSql">运行</button>
    <m-dynamictable :tableData="sqlRunResult" />
  </div>
</template>


<script>
import { executeSql } from "/js/api.mjs";
import { mvueloader } from "/js/mvueloader.mjs";

export default {
  props: ["dbId"],
  components: {
    "m-dynamictable": mvueloader("/dynamictable/dynamictable.vue"),
  },
  data() {
    return {
      sqlRunResult: undefined,
    };
  },
  methods: {
    runSql() {
      let content = window.frames[0].getValue();
      if (!content || content == "") {
        return;
      }

      console.info("run sql:" + content);

      executeSql({
        databaseInfoId: this.dbId,
        sql: content,
      }).then((data) => {
        console.info(data);
        this.sqlRunResult = data;
      });
    },
  },
  mounted() {
    console.info(this.dbId);
  },
};
</script>