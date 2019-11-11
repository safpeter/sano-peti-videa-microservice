<template>
  <v-app  id="inspire">
   
    <v-app-bar
      app
      clipped-left
    >
      <v-icon mdi-videocam></v-icon>
      <v-toolbar-title  class="orange--text display-1" >VideoWatch</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn class="orange--text" text large to="/newVideo">Add Video</v-btn>
        <v-btn class="orange--text" text large to="/">Home</v-btn>

    </v-app-bar>

    <v-content>
           <router-view />
    </v-content>

    <v-footer app>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import home from "./views/Home";

  export default {
    name:"App",
    props: {
      source: String,
    },

    data: () => ({
      drawer: null,
    }),

    created () {
      this.$vuetify.theme.dark = true
    },
  }
</script>
