<template>
  <div class="Cbal">
    <label>{{ getMsg }}</label>
    <br/>
    <button @click='onChangedMsg'>Click</button>
  </div>
</template>

<script>
export default {
  computed: {
    getMsg () {
      return this.$store.getters.getMsg
    }
  },
  method: {
    onChangedMsg () {
      this.$store.dispatch('callMutation', { newMsg: 'World!!' })
    }
  }
}
</script>

<style scoped>

</style>
