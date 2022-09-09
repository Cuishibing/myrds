let handlerMap = window.__handlerMap
if (handlerMap === null || handlerMap === undefined) {
  handlerMap = new Map()
  window.__handlerMap = handlerMap
}

const register = (key, h) => {
  let handlers = handlerMap.get(key)
  if (handlers === null || handlers === undefined) {
    handlers = []
    handlerMap.set(key, handlers)
  }
  handlers.push(h)
}

const notify = (key, data) => {
  let handlers = handlerMap.get(key)
  if (handlers) {
    handlers.forEach(h=>{
      h(data)
    })
  }
}


export {
  notify, register
}