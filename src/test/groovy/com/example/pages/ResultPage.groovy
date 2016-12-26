package com.example.pages

import geb.Page

class ResultPage extends Page {
    static url = "https://search.yahoo.co.jp/search"
    static at = { title.contains("検索結果") }
    static content = {
        results { $('#WS2m div') }
        firstResult { results[0] }
        firstResultTitle { firstResult.$('h3 b') }
    }
}