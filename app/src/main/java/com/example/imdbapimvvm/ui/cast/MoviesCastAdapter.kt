package com.example.imdbapimvvm.ui.cast

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbapimvvm.R
import com.example.imdbapimvvm.presentation.cast.MoviesCastRVItem

// Поменяли тип ViewHolder на более общий
class MoviesCastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Поменяли тип элементов на общий
    var items = emptyList<MoviesCastRVItem>()

    // Возвращаем нужный ViewType в зависимости
    // от типа элементов списка
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is MoviesCastRVItem.HeaderItem -> R.layout.list_item_header
            is MoviesCastRVItem.PersonItem -> R.layout.list_item_cast
        }
    }

    // Возвращаем нужный ViewHolder в зависимости
    // от viewType
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        R.layout.list_item_header -> MovieCastHeaderViewHolder(parent)
        R.layout.list_item_cast -> MovieCastViewHolder(parent)
        else -> error("Unknown viewType create [$viewType]")
    }

    // Биндим ViewHolder корректно, в зависимости
    // от viewType
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.layout.list_item_header -> {
                val headerHolder = holder as MovieCastHeaderViewHolder
                headerHolder.bind(items[position] as MoviesCastRVItem.HeaderItem)
            }

            R.layout.list_item_cast -> {
                val headerHolder = holder as MovieCastViewHolder
                headerHolder.bind(items[position] as MoviesCastRVItem.PersonItem)
            }

            else -> error("Unknown viewType bind [${holder.itemViewType}]")
        }
    }

    override fun getItemCount(): Int = items.size

}