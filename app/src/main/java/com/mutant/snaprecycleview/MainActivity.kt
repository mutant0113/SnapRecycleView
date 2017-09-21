package com.mutant.snaprecycleview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import model.Book

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var layoutManager = LinearLayoutManager(this@MainActivity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView_container.layoutManager = layoutManager

        var booksList: ArrayList<List<Book>> = arrayListOf()
        var booksInOnePage: ArrayList<Book> = arrayListOf()
        for (i in 0..99) {
            if (i % 4 == 0 && i != 0) {
                booksList.add(booksInOnePage)
                booksInOnePage = arrayListOf()
            }
            booksInOnePage.add(Book("https://i.imgur.com/o98jVpF.jpg", "Book ${i + 1}"))
        }
        booksList.add(booksInOnePage)

        recyclerView_container.adapter = AdapterContainer(this@MainActivity, booksList)
        val snapHelper = AlignLeftLinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView_container)
    }
}
