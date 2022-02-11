package com.example.android.shoestore.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.ItemShoeBinding
import com.example.android.shoestore.model.Shoe

class ShoeRecyclerAdapter : RecyclerView.Adapter<ShoeRecyclerAdapter.ShoeViewHolder>() {
    private var shoes: List<Shoe> = emptyList()
    private lateinit var binding: ItemShoeBinding

    fun setShoe(data: List<Shoe>) {
        this.shoes = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoeViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_shoe, parent, false
        )
        return ShoeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoes = shoes[position]
        holder.bindShoe(shoes)
    }

    override fun getItemCount() = shoes.size

    class ShoeViewHolder(private val binding: ItemShoeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindShoe(shoe: Shoe) {
//            binding.image.setImageResource(shoes.images)
            binding.nameTextView.text = shoe.name
            binding.sizeTextView.text = shoe.size.toString()
            binding.companyTextView.text = shoe.company
            binding.descriptionTextView.text = shoe.description
        }
    }
}