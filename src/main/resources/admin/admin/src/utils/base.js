const base = {
    get() {
                return {
            url : "http://localhost:8080/springbootyjn76/",
            name: "springbootyjn76",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootyjn76/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "租房网站"
        } 
    }
}
export default base
