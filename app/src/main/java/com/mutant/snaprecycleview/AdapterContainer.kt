package com.mutant.snaprecycleview

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_recycler_view.view.*
import model.Book

/**
 * Created by evanfang102 on 2017/9/21.
 */
class AdapterContainer(private val activity: Activity, private val booksList: List<List<Book>>) : RecyclerView.Adapter<AdapterContainer.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val books = booksList[position]
        var layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        holder?.recyclerView?.layoutManager = layoutManager
        holder?.recyclerView?.adapter = AdapterBook(activity, books)
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.recyclerView_book
    }

}
