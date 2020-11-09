package yzl.swu.newstest.model

import java.io.Serializable


//枚举类型  在此使用不太规范，其实用常量更好
enum class NewsType(i: Int) {
    SINGLE_IMG(9),
    THREE_IMG(1)
}
//数据模型
data  class NewsModel(val title:String,
                      val resIds:IntArray,
                      var like:Int,
                      var author:String,
                      val type:NewsType
):Serializable