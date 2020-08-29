import request from '@/utils/request'
export default {
    getList:function(params) {
        return request({
            url: '/goods/category/list',
            method: 'get',
            params
        })
    },
    add:function(params) {
        return request({
            url: '/goods/category',
            method: 'post',
            params
        })
    },
    update:function(params) {
        return request({
            url: '/goods/category',
            method: 'PUT',
            params
        })
    },
    remove:function(id) {
        return request({
            url: '/goods/category',
            method: 'delete',
            params: {
                id: id
            }
        })
    }
}
