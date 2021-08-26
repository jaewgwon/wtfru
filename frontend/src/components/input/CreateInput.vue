<template>
<div>
  <form @submit.prevent="submitForm">
    <b-row class="create-b-row" align-h="center">
      <b-col cols="12" md="8">
        <label class="create-input-title" for="input-title">Title</label>
        <b-form-input
          class="create-input"
          id="input-title"
          type="text"
          v-model.trim="$v.title.$model" :class="{ 'is-invalid':$v.title.$error, 'is-valid':!$v.title.$invalid }"
          @blur="checkDuplicate"
          placeholder="Enter your title"
        ></b-form-input>
        <div class="valid-feedback">Your Title is valid.</div>
        <div class="invalid-feedback">
          <span v-if="!$v.title.required">Title is required.</span>
          <span v-if="!$v.title.minLength">Title must have at least {{$v.title.$params.minLength.min}} letters.</span>
          <span v-if="!$v.title.maxLength">Title must have at most {{$v.title.$params.maxLength.max}} letters.</span>
          <span v-if="!availableTitle">Title not available.</span>
        </div>
      </b-col>
    </b-row>
    <b-row class="create-b-row" align-h="center">
      <b-col cols="12" md="8">
        <label class="create-input-password" for="input-password">Password</label>
        <b-form-input
          class="create-input"
          id="input-password"
          type="password"
          v-model.trim="$v.password.$model" :class="{ 'is-invalid':$v.password.$error, 'is-valid':!$v.password.$invalid }"
          placeholder="Enter your password"
        ></b-form-input>
        <div class="valid-feedback">Your password is valid.</div>
        <div class="invalid-feedback">
          <span v-if="!$v.password.required">Password is required.</span>
          <span v-if="!$v.password.numeric">This Password number only numeric accepted.</span>
          <span v-if="!$v.password.minLength">Title must have at least {{$v.password.$params.minLength.min}} letters.</span>
          <span v-if="!$v.password.maxLength">Title must have at most {{$v.password.$params.maxLength.max}} letters.</span>
        </div>
      </b-col>
    </b-row>
    <b-row class="create-b-row" align-h="center">
      <b-col cols="12" md="8">
        <label class="create-input-password-repeatpassword" for="input-password-repeatpassword">Repeat Password</label>
        <b-form-input
          class="create-input"
          id="input-password-repeatpassword"
          type="password"
          v-model.trim="$v.repeatpassword.$model" :class="{ 'is-invalid':$v.repeatpassword.$error, 'is-valid': (password != '') ? !$v.repeatpassword.$invalid : '' }"
          placeholder="Enter your password repeat"
        ></b-form-input>
        <div class="valid-feedback">Your Password is identical.</div>
        <div class="invalid-feedback">
          <span v-if="!$v.repeatpassword.sameAsPassword">Passwords must be identical.</span>
        </div>
      </b-col>
    </b-row>
    <div class="create-components-button">
      <CreateButton/>
    </div>
  </form>
</div>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, numeric, minLength, maxLength, sameAs } from 'vuelidate/lib/validators'
import CreateButton from '../../components/button/CreateButton.vue'
import { network } from '../../api/module/network'

export default {
  mixins: [validationMixin],
  name: 'CreateInput',
  data () {
    return {
      title: '',
      password: '',
      repeatpassword: '',
      submitstatus: null,
      availableTitle: true
    }
  },
  validations: {
    title: {
      required,
      minLength: minLength(3),
      maxLength: maxLength(50)
    },
    password: {
      required,
      numeric,
      minLength: minLength(4),
      maxLength: maxLength(4)
    },
    repeatpassword: {
      sameAsPassword: sameAs('password')
    }
  },
  methods: {
    async submitForm () {
      this.$v.$touch()
      const createSessionParams = {
        title: this.title,
        password: this.password
      }
      const response = await network.createSession(createSessionParams)
      if (this.$v.$invalid && this.availableTitle === false && response.status !== 200) {
        this.submitstatus = 'FAIL'
        this.availableTitle = false
      } else {
        this.submitstatus = 'SUCCESS'
        this.availableTitle = true
        this.$router.push('/join')
      }
    },
    async checkDuplicate () {
      const checkDuplicateParams = {
        title: this.title
      }
      const response = await network.checkDuplicateTitle(checkDuplicateParams)
      // Title 중복체크
      if (!response.data) {
        this.availableTitle = false
      } else {
        this.availableTitle = true
      }
    }
  },
  components: {
    CreateButton
  }
}
</script>

<style scoped>
@media screen and (min-width:576px) {
  .create-b-row {
    margin-bottom: 3vh;
  }
  .create-components-button {
    margin-top: 7vh;
  }
}
@media screen and (max-width: 575px) {
  .create-b-row {
    margin-bottom: 5vh;
  }
  .create-components-button {
    margin-top: 12vh;
  }
}
</style>
