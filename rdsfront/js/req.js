
const req = function (url, method, data, headers) {
    if (!headers) {
        headers = {
            "Content-Type": "application/json"
        }
    }
    return fetch(url, {
        method: method,
        headers: headers,
        body: JSON.stringify(data)
    }).then(res => {
        if (res.ok) {
            return res.json()
        }
        return Promise.reject(res)
    })
}


export {
    req
}