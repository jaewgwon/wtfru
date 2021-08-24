<template>
  <div class="main-button">
    <b-button class="main-button-create" size="md" pill variant="primary" href="/create">Create Room</b-button>
    <b-button class="main-button-join" size="md" pill variant="success" href="/join">Join Room</b-button>
  </div>
</template>

<script>
export default {
  name: 'MainButton'
}
</script>

<style scoped>
@media screen and (max-width:575px){
  .main-button{
    padding-top: 10vh;
  }
  .main-button-join {
    margin-left: 4vw;
    padding-left: 21px;
    padding-right: 21px;
  }
}
@media screen and (min-width:576px) {
  .main-button {
    padding-top: 10vh;
  }
  .main-button-create {
    margin-right: 2vw;
    padding: 5px 20px 5px 20px;
    font-size: 20px;
  }
  .main-button-join {
    margin-left: 2vw;
    padding: 5px 31px 5px 31px;
    font-size: 20px;
  }
}
</style>
