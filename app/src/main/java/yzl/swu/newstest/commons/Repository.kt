package yzl.swu.newstest.commons

import yzl.swu.newstest.model.NewsModel
import yzl.swu.newstest.utils.LocalDataLoader

class Repository private constructor(){
    private val orgDatas = mutableListOf<NewsModel>()
    var data:List<NewsModel> = listOf()
        get() {
            if (field.isEmpty()){
                loadData()
                field = ArrayList(orgDatas)
            }
            return field
        }
    //伴生对象 静态资源
    companion object{
        private val instance = Repository()
        fun getInstance() = instance
    }


    //获取数据的接口
    fun loadData():ArrayList<NewsModel>{
        //从本地获取数据
        orgDatas.addAll(LocalDataLoader().getData())
        return LocalDataLoader().getData()
    }

    //更改数据的接口
}