<template>
  <div class="mask">
    <div class="mask-content">
      <ul>
        <li>
          <a @click="addTask(1)">
            <i class="fa fa-plane list-icon" aria-hidden="true"></i>
            <span>商务旅行</span>
          </a>
        </li>
        <li>
          <a @click="addTask(2)">
            <i class="fa fa-list-alt list-icon" aria-hidden="true"></i>
            <span>日常事务</span>
          </a>
        </li>
        <li>
          <a @click="addTask(3)">
            <i class="fa fa-list-ul list-icon" aria-hidden="true"></i>
            <span>预购清单</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { addTask } from '../vuex/actions'


</script>

<style lang="sass">
.mask {
  position: absolute;
  height: 100%;
  width: 100%;
  left: 0;
  top: 0;
  background-color: rgba(#fff, 0.8);

  .mask-content {
    position: absolute;
    width: 300px;
    height: 300px;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    margin: auto;

    ul {
      height: 100%;
      border: 1px solid #436EEE;

      li {
        height: 100px;
        line-height: 100px;
        text-align: center;

        a{
          display: block;
          height: 100%;
          width: 100%;
          cursor: pointer;

          &:hover {
            background-color: #436EEE;
            color: #fff;
          }

          span {
            margin-left: 10px;
          }
        }
      }
    }
  }
}
</style>
