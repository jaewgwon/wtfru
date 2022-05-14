<template>
<div class="button-wrapper">
  <b-button class="customized-button create-button" type="submit" size="lg" pill variant="primary" href="">Create</b-button>
  <b-button class="customized-button close-button" size="lg" pill href="/">Close</b-button>
</div>
</template>

<script>
export default {
  name: 'Create-Button'
}
</script>

<style scoped>
.customized-button.create-button{
  padding: 12px 24px;
}
</style>
