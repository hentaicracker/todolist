<template>
  <div id="detail-view">
    <div class="detail-header">
      <div class="detail-header-left">
        <label
          class="title-label"
          v-text="activeTask.task_name"
          @dblclick="titleEditing = true">
        </label>
        <input
          class="toggle-input"
          :value="activeTask.task_name"
          v-show="titleEditing = active ? true : titleEditing"
          v-focus="titleEditing = active ? true : titleEditing"
          @keyup.enter="doneEdit"
          @keyup.esc="cancelEdit"
          @blur="doneEdit">
        <label class="tag-label">
          <i class="fa fa-tag" aria-hidden="true"></i>
          <span>{{tag}}</span>
        </label>
      </div>
      <div class="detail-header-right">
        <div class="time">
          <label for="datePicker" title="设置日期">
            <i class="fa fa-calendar" aria-hidden="true"></i>
          </label>
          <input class="time-input" type="text" id="datePicker" v-pikaday="time" @change="changeTime">
        </div>
        <div class="place">
          <a v-link="'map'">
            <label for="placePicker" title="设置地点">
              <i class="fa fa-location-arrow" aria-hidden="true"></i>
            </label>
            <input class="time-input" type="text" id="placePicker" :value="activeTask.task_place">
          </a>
        </div>
        <!-- <div class="priority">
          <label for="priorityPicker" title="设置优先级">
            <i class="fa fa-exclamation" aria-hidden="true"></i>
          </label>
          <select class="priority-select" id="priorityPicker" :value="activeTask.task_priority">
            <option value="0">请选择任务优先级</option>
            <option value="1">一级</option>
            <option value="2">二级</option>
            <option value="3">三级</option>
          </select>
        </div> -->
      </div>
    </div>
    <div class="detail-content">
      <p @dblclick="contentEditing = true">{{activeTask.task_content ? activeTask.task_content : '任务内容，双击进行修改'}}</p>
      <textarea
        :value="activeTask.task_content"
        v-show="contentEditing"
        v-focus="contentEditing"
        @keyup.esc="cancelEdit"
        @blur="doneEdit">
      </textarea>
    </div>
    <div class="delete-btn">
      <i class="fa fa-pencil" aria-hidden="true" title="编辑" @click="contentEditing = true"></i>
      <i class="fa fa-floppy-o" aria-hidden="true" title="保存" @click="doneEdit"></i>
      <i class="fa fa-trash" aria-hidden="true" title="删除" @click="deleteTask"></i>
    </div>
  </div>
</template>

<script>
import { editTaskTitle, editTaskContent, deleteTask, toggleActive, addTime, showError, changePlace } from '../vuex/actions'

export default {

  vuex: {
    getters: {
      activeTask: state => state.activeTask,
      active: state => state.active
    },
    actions: {
      editTaskTitle,
      editTaskContent,
      deleteTask,
      toggleActive,
      addTime,
      showError
    }
  },

  data () {
    return {
      titleEditing: false,
      contentEditing: false
    }
  },

  computed: {
    time () {
      return this.activeTask.end_time ? this.activeTask.end_time.split(' ')[0] : ''
    },
    tag () {
      switch (this.activeTask.task_type) {
        case 1:
          return '行程管理'
          break;
        case 2:
          return '工作安排'
          break;
        case 3:
          return '生活事务'
          break;
        default:
          return
      }
    }
  },

  methods: {
    doneEdit (e) {
      let value = e.target.value.trim()
      if (value) {
        if (this.titleEditing) {
          this.editTaskTitle(value)
          this.titleEditing = false
        } else if (this.contentEditing) {
          this.editTaskContent(value)
          this.contentEditing = false
        }
      } else {
        if (this.activeTask.task_name === '') {
          this.showError('请输入标题！')
        } else {
          this.cancelEdit(e)
        }
      }
      this.toggleActive()
    },
    cancelEdit (e) {
      e.target.value = this.titleEditing ? this.activeTask.task_name : this.activeTask.task_content
      this.titleEditing = false
      this.contentEditing = false
      this.toggleActive()
    },
    changeTime (e) {
      let time = e && e.target.value.trim()
      this.addTime(time)
    }
  },

  directives: {
    focus (value) {
      if (value) {
        this.vm.$nextTick(() => {
          this.el.focus()
        })
      }
    }
  }

}
</script>
