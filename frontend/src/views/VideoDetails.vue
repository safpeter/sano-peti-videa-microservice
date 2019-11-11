<template> 
<div>
    <iframe width="640" height="360" :src="this.video.url" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
<ul>
  <li v-for="recommendation in recommendations"  :key="recommendation.id"> Rating: {{recommendation.rating}} Comment {{recommendation.comment}}  </li>
</ul>
<v-row align="center">
    <v-container  text-xs-center>
    <v-form align="center"
      ref="form"
      v-model="valid"
      :lazy-validation="lazy"
    >
      <v-text-field
        v-model="rating"
        label="Your Rating"
        required
      ></v-text-field>

      <v-text-field
        v-model="comment"
        label="Your Comment"
        required
      ></v-text-field>

      <v-btn
        color="success"
        class="mr-4"
        @click="sendRecommendation(this.videoo.id)"
        v-model="videoo"
      >Send Recommendation
      </v-btn>

    
    </v-form>
    </v-container>
  </v-row>
  </div>
</template>

<script>
import axios from "axios";

export default {
 
  name: "videodetails",
  data(){
    return{
        videoo:{}
    }
  },
  computed: {
    video() {
        return this.$store.state.video;
    },
    recommendations() {
      return this.$store.state.recommendations;
    }
  },
  methods:{
     sendRecommendation(id) {
       if (this.$refs.form.validate()) {
        this.snackbar = true;
      }
      this.$router.push("/videos/" + videoo.id);
      this.$store.dispatch("sendRecommendation", {
      name: this.rating,
      url: this.comment,
    });
     },
    goTo(){
      this.$router.push(`/videos/${this.video.id}/newcomment`)
    }
  }
};
</script>