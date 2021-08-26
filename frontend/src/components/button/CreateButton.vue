<template>
<div class="button-wrapper">
  <b-button class="customized-button create-button" type="submit" size="lg" pill variant="success" href="">Create</b-button>
  <b-button class="customized-button close-button" size="lg" pill href="/">Close</b-button>
</div>
</template>

<script>
export default {
  name: 'Create-Button'
}
</script>

<style scope>
.button-wrapper {
  text-align: center;
}
.customized-button.close-button {
  margin-left: 1vw;
  background: transparent;
  color: #000000 !important;
  border: 1px solid #000000;
}
</style>
