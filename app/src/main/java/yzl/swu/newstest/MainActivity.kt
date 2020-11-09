package yzl.swu.newstest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import yzl.swu.newstest.adapter.NewsAdapter
import yzl.swu.newstest.commons.Repository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //配置recyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //设置适配器     显示数据
        NewsAdapter().also {
            mRecyclerView.adapter = it

            //点击事件回调
            it.callBack = {position->
                val intent = Intent(this,DetailActivity::class.java).apply {
                    putExtra("newsModel",Repository.getInstance().data[position])
                }
                startActivity(intent)
            }
        }



    }
}