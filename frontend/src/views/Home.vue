<template>
  <div class="home">
    <HelloWorld msg="Welcome to WTFRU vue2 project!!"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
