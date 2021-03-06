import axios from "axios"
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    allVideos:[],
    result:"false",
    video:{},
    recommendations: [],
    newRecommendation : {}
  },
  mutations: {
    setVideo(state, video){
      state.video = video
    },
    setResult(state, result){
      state.result = result
    },
    setRecommendation(state, recommendations){
      state.recommendations = recommendations
    },
    setNewRecommendation(state, recommendation){
        state.newRecommendation = recommendation
    },
  },
  actions: {
    getAVideo(context, id){
      axios({
        method:"GET",
        url:`http://localhost:8760/videos/video/${id}`,
        headers:{
        "Access-Controll-Allow-Origin" : "*",
        "cache-control" : "no-cache",
        "Content-Type" : "application/json"
        }
      })
      .then(response => (context.commit("setVideo", response.data)));
    },
    getRecommendation(context, id){
      axios({
        method:"GET",
        url:`http://localhost:8760/videos/recommendation/${id}`,
        headers:{
        "Access-Controll-Allow-Origin" : "*",
        "cache-control" : "no-cache",
        "Content-Type" : "application/json"
        }
      })
      .then(response => (context.commit("setRecommendation", response.data)));
    },
    sendNewvideo(context, sendForm){
      axios({
        method:"POST",
        url:`http://localhost:8760/videos/add`,
        data:sendForm,
        headers:{
        "Access-Controll-Allow-Origin" : "*",
        "cache-control" : "no-cache",
        "Content-Type" : "application/json"
        }
      })
      .then(response => (context.commit("setAllVideos", response.data)));
    },
    sendRecommendation(context,sendForm){
      axios({
        method:"POST",
        data:sendForm,
        url:`http://localhost:8760/videos/newrecommendation/${sendForm.id}`,
        headers:{
        "Access-Controll-Allow-Origin" : "*",
        "cache-control" : "no-cache",
        "Content-Type" : "application/json"
        }
      })
      .then(response => (context.commit("setNewRecommendation", response.data)));
    }

  },
  modules: {}
});
