<template>
<div class="button-wrapper">
  <b-button class="customized-button join-button" type="submit" size="lg" pill variant="success" href="">Join</b-button>
  <b-button class="customized-button close-button" size="lg" pill href="/">Close</b-button>
</div>
</template>

<script>
export default {
  name: 'JoinButton'
}
</script>

<style scoped>
.customized-button.join-button {
  padding: 12px 30px;
}
</style>
