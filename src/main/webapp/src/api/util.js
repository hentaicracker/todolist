export default {
  checkoutData (data) {
    if ((typeof data) == 'string') {
      return JSON.parse(data)
    } else if ((typeof data) == 'object') {
      return eval(data)
    }
  }
}
