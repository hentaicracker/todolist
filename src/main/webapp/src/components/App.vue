<template>
  <div>
    <router-view transition transition-mode="out-in"></router-view>
  </div>
</template>

<script>
import store from '../vuex/store'

export default {
  store
}
</script>
