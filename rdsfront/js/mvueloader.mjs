import { loadModule } from '/js/vue3-sfc-loader.esm.mjs'

const options = {
    moduleCache: { vue: Vue },
    async getFile(url) {
        const res = await fetch(url)
        if (!res.ok)
            throw Object.assign(new Error(res.statusText + ' ' + url), { res })
        
        return {
            getContentData: (asBinary) => {
                if (asBinary) {
                    return res.arrayBuffer()
                } else {
                    return res.text()
                }
            }
        }


    },
    addStyle(textContent) {
        const style = Object.assign(document.createElement('style'), { textContent });
        const ref = document.head.getElementsByTagName('style')[0] || null;
        document.head.insertBefore(style, ref);
    }
}

const mvueloader = (url) => {
    return Vue.defineAsyncComponent(() => loadModule(url, options))
}

export { mvueloader }