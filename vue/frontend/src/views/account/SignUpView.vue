<template>
  <v-container>
    <sign-up-form @submit="onSubmit"/>
  </v-container>
</template>

<script>
import axios from "axios";
import SignUpForm from "@/components/account/SignUpForm";
export default {
  name: "SignUpView",
  components: {
    SignUpForm
  },
  methods: {
    onSubmit (payload) {
      const { email, password, city, street, addressDetail, zipcode } = payload;
      axios.post("http://localhost:8888/member/sign-up", {
        email, password, city, street, addressDetail, zipcode
      })
    }
  }
}
</script>

<style scoped>
</style>
