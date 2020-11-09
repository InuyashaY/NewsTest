package yzl.swu.newstest.commons

import yzl.swu.newstest.model.NewsModel

interface DataLoadInterface {
    fun getData():ArrayList<NewsModel>
}