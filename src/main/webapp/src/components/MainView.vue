<template>
  <div class="container">

    <sidebar></sidebar>
    <todolist></todolist>
    <detail></detail>

  </div>
</template>

<script>
  import sidebar from './sidebar'
  import todolist from './todolist'
  import detail from './detail'

  export default {
    components: {
      sidebar,
      todolist,
      detail
    }
  }
</script>
