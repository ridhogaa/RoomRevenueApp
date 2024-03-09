package com.ergea.roomrevenueapp.presentation.adapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ergea.roomrevenueapp.databinding.ItemTableRowBinding
import com.ergea.roomrevenueapp.domain.model.RoomRevenue


class RowAdapter(private val itemClick: (RoomRevenue) -> Unit) :
    RecyclerView.Adapter<RowAdapter.RowViewHolder>() {

    private var items: MutableList<RoomRevenue> = mutableListOf()

    fun setItems(items: List<RoomRevenue>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val binding =
            ItemTableRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size


    class RowViewHolder(
        private val binding: ItemTableRowBinding,
        val itemClick: (RoomRevenue) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private val columnAdapter: ColumnAdapter by lazy {
            ColumnAdapter { data ->

            }
        }

        fun bindView(item: RoomRevenue) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                columnAdapter.setItems(value)
                binding.run {
                    txtTitle.text = key.value
                }
                setUpRecyclerViewValue()
            }
        }

        private fun setUpRecyclerViewValue() {
            binding.rvColumn.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = columnAdapter
                isNestedScrollingEnabled = false
            }
        }
    }

}