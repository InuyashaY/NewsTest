package yzl.swu.newstest.utils

import yzl.swu.newstest.R
import yzl.swu.newstest.commons.DataLoadInterface
import yzl.swu.newstest.model.NewsModel
import yzl.swu.newstest.model.NewsType

class LocalDataLoader: DataLoadInterface {
    override fun getData(): ArrayList<NewsModel> {
        return initData()
    }


    fun initData(): ArrayList<NewsModel>{
        val data = ArrayList<NewsModel>()
        val images = intArrayOf(R.drawable.xc,R.drawable.bzhw,R.drawable.zgl)
        NewsModel("阳光露脸好运直涨！本周12星座运势详细解析", intArrayOf(R.drawable.xz),0,"星座控",NewsType.SINGLE_IMG).also { data.add(it) }
        NewsModel("王者荣耀：有哪些法师根本不怕刺客？三段位移的诸葛亮不是最强", images,0,"王者荣耀论坛",NewsType.THREE_IMG).also { data.add(it) }
        NewsModel("波什：科比早跟我说过会赢奥斯卡 他比别人更有远见", intArrayOf(R.drawable.kb),0,"NBA学社",NewsType.SINGLE_IMG).also { data.add(it) }
        NewsModel("王者荣耀：有哪些法师根本不怕刺客？三段位移的诸葛亮不是最强", images,0,"王者荣耀论坛",NewsType.THREE_IMG).also { data.add(it) }
        NewsModel("游戏宅男变身修仙大佬！《我是大神仙》动画定档！", intArrayOf(R.drawable.dm),0,"动漫吧",NewsType.SINGLE_IMG).also { data.add(it) }

        return data
    }
}