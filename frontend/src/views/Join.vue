<template>
<div class="join">
  <b-container fluid="xl">
    <h1 class="join-session-name">Join Session</h1>
    <div class="join-components-input">
      <JoinInput/>
    </div>
  </b-container>
</div>
</template>

<script>
import JoinInput from '../components/input/JoinInput.vue'

export default {
  name: 'SessionJoinComponents',
  components: {
    JoinInput
  }
}
</script>

<style scoped>
.join-session-name {
  text-align: center;
}
@media screen and (min-width:576px) {
  .join {
    margin-top: 5vh;
  }
  .join-components-input {
    margin-top: 5vh;
  }
}
@media screen and (max-width: 575px) {
  .join {
    margin-top: 5vh;
  }
  .join-components-input {
    margin-top: 5vh;
  }
  /* .join-components-button {
    margin-top: 20vw;
  } */
}
</style>
