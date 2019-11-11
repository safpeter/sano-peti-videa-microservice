<template>
  <v-row align="center">
    <v-container  text-xs-center>
    <v-form align="center"
      ref="form"
      v-model="valid"
      :lazy-validation="lazy"
    >
      <v-text-field
        v-model="name"
        label="Video Name"
        required
      ></v-text-field>

      <v-text-field
        v-model="url"
        label="Video URL"
        required
      ></v-text-field>

      <v-btn
        color="success"
        class="mr-4"
        @click="sendNewVideo"
      >Update Video
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
      nameRules: [
        v => !!v || 'Video Name is required',
      ],
      url: '',
      urlRules: [
        v => !!v || 'Video URL is required',
      ],
     
      checkbox:false,
      lazy: false,
    }),

    methods: {
       sendNewVideo() {
       if (this.$refs.form.validate()) {
        this.snackbar = true;
      }
      this.$router.push("/");
      this.$store.dispatch("sendNewvideo", {
      name: this.name,
      url: this.url,
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