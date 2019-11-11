<template>
 <v-container>
    <ul class="orange--text" >
      <li v-for="video in videos"  :key="video.id" @click="goTo(video.id)">{{video.id}} ----------------- {{video.name}}  </li>
    </ul>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "home",
  data() {
    return {
      videos: [],
    };
  }, 
  components: {},

  methods: {
    goTo(id) {
      this.$router.push("/videos/" + id);
      this.$store.dispatch("getAVideo", id);
      this.$store.dispatch("getRecommendation", id);  
    },
     submit: function() {
      this.tempMessage = "";
    }
  },
   created() {
    axios
      ({
        method: "GET",
         url: "http://localhost:8760/videos/all",
         headers: {
          "Access-Control-Allow-Origin" : "*",
           "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
        "Access-Control-Allow-Headers": "*",
          "Content-Type" :  "application/json",
            "cache-control": "no-cache",
            "Access-Control-Allow-Credentials":"true",
         }
      })
      .then(response => (this.videos = response.data));

  }

};
</script>