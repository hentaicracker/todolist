<template>
  <div class="tip" v-show="show">
    <div class="content">
      <slot name="body">Hello World!</slot>
      <span class="close" @click="show = false">+</span>
    </div>
  </div>
</template>

<script>
export default {

  props: ['show']

}
</script>

<style lang="sass">

.tip {
  position: fixed;
  top: 30px;
  text-align: center;
  width: 100%;

  .content {
    position: relative;
    min-height: 50px;
    background-color: #fff;
    box-shadow: 0 0 1em #CCC;
    max-width: 200px;
    margin: 0 auto;
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
