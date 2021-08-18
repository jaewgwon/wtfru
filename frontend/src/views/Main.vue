<template>
  <b-container fluid="xl">
    <div class="header">
      <div class="main-typography">
        <h1><strong>Welcome to WTFRU</strong></h1><br/>
        <h4>You can start creating sessions and locate your friends!!</h4>
      </div>
      <div class="main-button">
        <MainButton/>
      </div>
    </div>
    <MainGrid/>
  </b-container>
</template>

<script>
// @ is an alias to /src
import MainButton from '../components/button/MainButton.vue'
import MainGrid from '../components/grid/MainGrid.vue'

export default {
  name: 'MainComponents',
  components: {
    MainButton,
    MainGrid
  }
}
</script>

<style scoped>
@media screen and (min-width:576px) {
  .main-typography {
    margin-top: 15%;
  }
}
@media screen and (max-width: 575px) {
  .main-typography {
    margin-top: 35%;
  }
}

</style>
