const req = function (url, method, data, headers) {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: method,
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: data => {
                resolve(data)
            },
            error: data => {
                reject(data)
            }
        })
    })
}


export {
    req
}