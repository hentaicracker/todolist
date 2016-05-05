<template>
  <div class="main-container">

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

    name: 'MainView',

    components: {
      sidebar,
      todolist,
      detail
    }
  }
</script>
