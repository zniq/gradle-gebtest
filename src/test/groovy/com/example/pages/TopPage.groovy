package com.example.pages

import geb.Page

class TopPage extends Page {
    static url = "http://www.yahoo.co.jp"
    static at = { title == "Yahoo! JAPAN" }
    static content = {
        p  { $('input[name=\'p\']') }
        searchButton { $('#srchbtn') }
    }
}