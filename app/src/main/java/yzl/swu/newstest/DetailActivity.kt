package yzl.swu.newstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_detail.*
import yzl.swu.newstest.model.NewsModel
import yzl.swu.newstest.model.NewsType

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //接收传递过来的数据模型   解析并显示
        (intent.getSerializableExtra("newsModel") as NewsModel).apply {
            titleTextView.text = title
            if (type == NewsType.SINGLE_IMG){
                (imgsContainer.getChildAt(0) as ImageView).setImageResource(resIds[0])
            }else if(type == NewsType.THREE_IMG){
                for ((index,resId) in resIds.withIndex()){
                    (imgsContainer.getChildAt(index) as ImageView).setImageResource(resId)
                }
            }
        }
    }
}