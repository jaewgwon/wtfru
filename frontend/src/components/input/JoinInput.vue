<template>
<div>
  <form @submit.prevent="submitForm">
    <b-row class="join-b-row" align-h="center">
      <b-col cols="12" md="8">
        <label class="join-input-title" for="input-title">Title</label>
        <b-form-input
          class="join-input"
          id="input-title"
          v-model.trim="$v.title.$model" :class="{ 'is-invalid':$v.title.$error }"
          placeholder="Enter your title"
        ></b-form-input>
        <div class="valid-feedback"></div>
        <div class="invalid-feedback">
          <span v-if="!$v.title.required">Title is required.</span>
          <span v-if="submitStatus === 'FAIL'">Please check the title and password again</span>
        </div>
      </b-col>
    </b-row>
    <b-row class="join-b-row" align-h="center">
      <b-col cols="12" md="8">
        <label class="join-input-password" for="input-password">Password</label>
        <b-form-input
          class="join-input"
          id="input-password"
          type="password"
          v-model.trim="$v.password.$model" :class="{ 'is-invalid':$v.password.$error }"
          placeholder="Enter your password"
        ></b-form-input>
        <div class="valid-feedback"></div>
        <div class="invalid-feedback">
          <span v-if="!$v.password.required">Password is required.</span>
        </div>
      </b-col>
    </b-row>
    <div class="join-components-button">
      <JoinButton/>
    </div>
  </form>
</div>
</template>

<script>
import JoinButton from '../../components/button/JoinButton.vue'
import { validationMixin } from 'vuelidate'
import { required } from 'vuelidate/lib/validators'
import { api } from '../../api/module/api'

export default {
  mixins: [validationMixin],
  name: 'JoinInput',
  data () {
    return {
      title: '',
      password: '',
      submitStatus: null
    }
  },
  components: {
    JoinButton
  },
  validations: {
    title: {
      required
    },
    password: {
      required
    }
  },
  methods: {
    async submitForm () {
      this.$v.$touch()
      const joinParam = {
        title: this.title,
        password: this.password
      }
      const response = await api.postSession(joinParam)
      if (this.$v.$invalid && !response.data && response.status !== 200) {
        this.submitStatus = 'FAIL'
      } else {
        this.submitStatus = 'SUCCESS'
        this.$router.push('/session/' + this.title)
      }
    }
  }
}
</script>

<style scoped>
@media screen and (min-width:576px) {
  .join-b-row {
    margin-bottom: 3vh;
  }
  .join-components-button {
    margin-top: 7vh;
  }
}
@media screen and (max-width: 575px) {
  .join-b-row {
    margin-bottom: 5vh;
  }
  .join-components-button {
    margin-top: 12vh;
  }
}
</style>
