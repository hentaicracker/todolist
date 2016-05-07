export const addTask = makeAction('ADD_TASK')
export const toggleTask = makeAction('TOGGLE_TASK')
export const editTask = makeAction('EDIT_TASK')
export const deleteTask = makeAction('DELETE_TASK')
export const updateActiveTask = makeAction('SET_ACTIVE_TASK')

function makeAction (type) {
  return ({ dispatch }, ...args) => dispatch(type, ...args)
}
