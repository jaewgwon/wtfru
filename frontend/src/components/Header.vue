<template>
<div>
  <b-navbar variant="light">
    <b-navbar-brand href="/">WTFRU</b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">한국어</b-dropdown-item>
          <b-dropdown-item href="#">Engli</b-dropdown-item>
          <b-dropdown-item href="#">日本</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
export default {
  name: 'Header'
}
</script>
