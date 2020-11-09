package yzl.swu.newstest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yzl.swu.newstest.DetailActivity
import yzl.swu.newstest.MainActivity
import yzl.swu.newstest.R
import yzl.swu.newstest.commons.Repository
import yzl.swu.newstest.model.NewsType

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    //回调点击事件
    var callBack:((Int)->Unit) = {position->}

    //创建一个Item  使用inflate解析布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        LayoutInflater.from(parent.context).apply {
            val view = if (viewType == 0) inflate(R.layout.news_item_type_one,parent,false)
                    else inflate(R.layout.news_item_type_two,parent,false)
            return NewsViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Repository.getInstance().data[position].apply {
            //获取数据  与控件进行绑定
            holder.titleTextView.text = title
            holder.likeTextView.text = "${like}评论"
            holder.authorTextView.text = author
            if (type == NewsType.SINGLE_IMG){
                holder.iconImageView?.setImageResource(resIds[0])
            }else{
                for ((index,resId) in resIds.withIndex()){
                    (holder.imageContainer.getChildAt(index) as ImageView).setImageResource(resId)
                }
            }
        }

        //点击事件
        holder.itemView.setOnClickListener{
            callBack(position)
        }


    }

    //获取view的类型
    override fun getItemViewType(position: Int): Int {
        return Repository.getInstance().data[position].type.ordinal
    }

    //确认有多少行
    override fun getItemCount(): Int {
        return Repository.getInstance().data.size
    }



    //ViewHolder
    class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val iconImageView:ImageView? = itemView.findViewById<ImageView>(R.id.iconImageView)
        val authorTextView = itemView.findViewById<TextView>(R.id.authorTextView)
        val likeTextView = itemView.findViewById<TextView>(R.id.likeTextView)
        val imageContainer = itemView.findViewById<LinearLayout>(R.id.imgsContainer)
    }
}