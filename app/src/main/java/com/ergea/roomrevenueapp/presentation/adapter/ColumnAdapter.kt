package com.ergea.roomrevenueapp.presentation.adapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ergea.roomrevenueapp.databinding.ItemTableColumnBinding


class ColumnAdapter(private val itemClick: (String) -> Unit) :
    RecyclerView.Adapter<ColumnAdapter.ColumnViewHolder>() {

    private var items: MutableList<String> = mutableListOf()

    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColumnViewHolder {
        val binding =
            ItemTableColumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColumnViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: ColumnViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ColumnViewHolder(
        private val binding: ItemTableColumnBinding,
        val itemClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: String) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    txtStatus.text = item
                }
            }

        }
    }

}