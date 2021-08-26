<template>
<div class="create">
  <b-container fluid="xl">
    <h1 class="create-session-name">Create Session</h1>
    <div class="create-components-input">
      <CreateInput/>
    </div>
  </b-container>
</div>
</template>

<script>
import CreateInput from '../components/input/CreateInput.vue'

export default {
  name: 'SessionCreateComponents',
  components: {
    CreateInput
  }
}
</script>

<style scoped>
.create-session-name {
  text-align: center;
}
@media screen and (min-width:576px) {
  .create {
    margin-top: 5vh;
  }
  .create-components-input {
    margin-top: 5vh;
  }
}
@media screen and (max-width: 575px) {
  .create {
    margin-top: 5vh;
  }
  .create-components-input {
    margin-top: 5vh;
  }
}
</style>
