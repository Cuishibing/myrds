<template>
  <div>
    <iframe
      id="editor_frame"
      src="/components/editor/editor.html"
      style="width: 100%; height: 500px"
    />
    <h4>
      <button @click="runSql">运行</button>
      <button>复制</button>
    </h4>
    <m-dynamictable :tableData="sqlRunResult" />
  </div>
</template>


<script>
import { executeSql } from "/js/api.mjs";
import { mvueloader } from "/js/mvueloader.mjs";

export default {
  props: ["dbId"],
  components: {
    "m-dynamictable": mvueloader("/components/dynamictable/dynamictable.vue"),
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