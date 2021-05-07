package school.cactus.succulentshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import school.cactus.succulentshop.databinding.ItemProductBinding
import school.cactus.succulentshop.ProductAdapter.ProductHolder

class ProductAdapter: ListAdapter<Product, ProductHolder>(DIFF_CALLBACK) {

    var itemClickListener: (Product) -> Unit = {}

    class ProductHolder(
            private val binding:ItemProductBinding,
            private val itemClickListener: (Product) -> Unit
    ):RecyclerView.ViewHolder(binding.root){


        fun bind(product: Product){
            binding.titleText.text = product.title

            binding.priceText.text = product.price
            binding.imageView.setImageResource(product.imageUrl)

            Glide.with(binding.root.context)
                    .load(product.imageUrl)
                    .override(512)
                    .into(binding.imageView)

            binding.root.setOnClickListener {
                itemClickListener(product)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductHolder {

        val binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return ProductHolder(binding,itemClickListener)
    }




    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>(){
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        return holder.bind(getItem(position))
    }

}