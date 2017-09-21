package com.mutant.snaprecycleview

import android.app.Activity
import android.graphics.Point
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_book.view.*
import model.Book

/**
 * Created by evanfang102 on 2017/9/21.
 */
class AdapterBook(private val activity: Activity, private val books: List<Book>) : RecyclerView.Adapter<AdapterBook.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_book, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val book = books[position]
        var params = holder?.itemView?.layoutParams
        params?.width = calculateItemWidth()
        holder?.itemView?.layoutParams = params
        params = holder?.imageViewBanner?.layoutParams
        params?.width = calculateItemWidth()
        holder?.imageViewBanner?.layoutParams = params
        Glide.with(activity).load(book.bannerUrl).placeholder(R.mipmap.ic_launcher).into(holder?.imageViewBanner)
        holder?.textViewName?.text = book.name
    }

    override fun getItemCount(): Int {
        return books.size
    }

    private fun calculateItemWidth(): Int {
        val display = activity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        // You can change denominator here to define how many items can be seen in one page
        return (size.x.toDouble() / 4.5).toInt()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewBanner: ImageView = itemView.imageView_banner
        val textViewName: TextView = itemView.textView_name
    }

}