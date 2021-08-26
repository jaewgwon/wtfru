<template>
<div class="create-button">
  <b-button class="create-button-create" type="submit" size="lg" pill variant="success" href="">Create</b-button>
  <b-button class="create-button-close" size="lg" pill href="/">Close</b-button>
</div>
</template>

<script>
export default {
  name: 'Create-Button'
}
</script>

<style scope>
.create-button {
  text-align: center;
}
@media screen and (min-width:576px) {
  .create-button-create {
    margin-right: 6vw;
  }
  .create-button-close {
    margin-left: 6vw;
  }
}
@media screen and (max-width: 575px) {
  .create-button-create {
    margin-right: 4vw;
  }
  .create-button-close {
    margin-left: 4vw;
  }
}
</style>
