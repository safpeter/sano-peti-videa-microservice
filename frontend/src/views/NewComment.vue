<template>
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
        @click="sendRecommendation(this.video.id)"
      >Send Recommendation
      </v-btn>

    
    </v-form>
    </v-container>
  </v-row>
</template>

<script>
  export default {
    data: () => ({
      valid: true,
      name: '',
      rateRules: [
        v => !!v || 'Rate this video',
      ],
      url: '',
      commentRules: [
        v => !!v || 'Write a comment',
      ],
     
      checkbox:false,
      lazy: false,
    }),

    methods: {
       sendRecommendation(id) {
       if (this.$refs.form.validate()) {
        this.snackbar = true;
      }
      this.$router.push("/videos/" + id);
      this.$store.dispatch("sendRecommendation", {
      name: this.rating,
      url: this.comment,
    });
    }
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
     
    };
</script>