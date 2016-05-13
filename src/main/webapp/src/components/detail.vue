<template>
  <div id="detail-view">
    <div class="detail-header">
      <label
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
      <div class="time">
        <label for="datePicker" title="设置日期">
          <i class="fa fa-calendar" aria-hidden="true"></i>
        </label>
        <input class="time-input" type="text" id="datePicker" v-pikaday="defaultDate" @change="addTime(defaultDate)">
      </div>
    </div>
    <div class="detail-content">
      <p @dblclick="contentEditing = true">{{activeTask.task_content}}</p>
      <textarea
        :value="activeTask.task_content"
        v-show="contentEditing"
        v-focus="contentEditing"
        @keyup.enter="doneEdit"
        @keyup.esc="cancelEdit"
        @blur="doneEdit">
      </textarea>
    </div>
    <div class="delete-btn">
      <i class="fa fa-pencil" aria-hidden="true" title="编辑" @click="contentEditing = true"></i>
      <i class="fa fa-floppy-o" aria-hidden="true" title="保存"></i>
      <i class="fa fa-trash" aria-hidden="true" title="删除" @click="deleteTask"></i>
    </div>
  </div>
</template>

<script>
import { editTaskTitle, editTaskContent, deleteTask, toggleActive, addTime } from '../vuex/actions'

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
      addTime
    }
  },

  data () {
    return {
      titleEditing: false,
      contentEditing: false,
      defaultDate: ''
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
        this.cancelEdit(e)
      }
      this.toggleActive()
    },
    cancelEdit (e) {
      e.target.value = this.titleEditing ? this.activeTask.task_name : this.activeTask.task_content
      this.titleEditing = false
      this.contentEditing = false
      this.toggleActive()
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
