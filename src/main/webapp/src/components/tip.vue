<template>
  <div class="tip" v-show="show">
    <div class="content">
      <slot name="body">Hello World!</slot>
    </div>
    <span class="close" @click="show = false">+</span>
  </div>
</template>

<script>
export default {

  props: ['show']

}
</script>

<style lang="sass">

.tip {
  position: relative;
  margin: 0 auto;
  min-height: 50px;
  box-shadow: 0 0 1em #CCC;
  background-color: #fff;
  top: 30px;
  max-width: 200px;

  .content {
    padding: 20px;
    font-size: 16px;
  }

  .close {
    position: absolute;
    display: block;
    top: -10px;
    right: 0px;
    font-size: 30px;
    transform: rotate(45deg);
    cursor: pointer;
  }
}

</style>
