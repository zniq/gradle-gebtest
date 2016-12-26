package com.example.specs

import com.example.pages.ResultPage
import com.example.pages.TopPage
import geb.spock.GebReportingSpec
import spock.lang.Shared

class TopSpec extends GebReportingSpec {

    @Shared
    private TopPage currentPage

    def setup() {
        to TopPage
        currentPage = getPage()
    }

    def '初期表示確認'() {
        expect: 'ページを表示すると検索欄と検索ボタンが表示されている'
        currentPage.p.isDisplayed()
        currentPage.p.value() == ""
        currentPage.searchButton.isDisplayed()
    }


    def '検索できる'() {
        when: '検索欄にキーワードを入れて検索ボタンを押すと'
        currentPage.p = "google"
        currentPage.searchButton.click()
        waitFor { at ResultPage }
        then: '検索結果が表示される'
        ResultPage p = getPage()
        p.firstResultTitle.text() == "Google"

    }

}