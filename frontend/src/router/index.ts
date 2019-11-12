import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/newvideo",
    name: "newvideo",
    component: () =>
      import("../views/NewVideo.vue")
  },
  {
    path: "/videos/:id",
    name: "videodetails",
    component: () =>
      import("../views/VideoDetails.vue")
  },
 
 
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
