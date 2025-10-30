const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootu4nad998/",
            name: "springbootu4nad998",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的农产品溯源系统"
        } 
    }
}
export default base
