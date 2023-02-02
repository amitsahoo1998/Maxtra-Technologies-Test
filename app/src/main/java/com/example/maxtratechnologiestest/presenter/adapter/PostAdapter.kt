package com.example.maxtratechnologiestest.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.maxtratechnologiestest.data.model.Data
import com.example.maxtratechnologiestest.data.model.DataX
import com.example.maxtratechnologiestest.databinding.PostListItemBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

class PostAdapter : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    var type: String? = null

    private val callback = object : DiffUtil.ItemCallback<DataX>() {
        override fun areItemsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, callback)

    inner class MyViewHolder(private val itemBinding: PostListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: DataX) {
            itemBinding.post = data
            /*val currentTime = Calendar.getInstance().time
            val date = article.publishedAt
            val format  = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val localDate = LocalDateTime.parse(date, format)
            val timeInMilliseconds: Long =
                localDate.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            val hour = TimeUnit.MILLISECONDS.toHours(currentTime.time-timeInMilliseconds).toString()
            itemBinding.tvPublishedAt.text = "$hour hours ago"
            if(article.urlToImage!=null) {
                Glide.with(itemBinding.ivArticleImage.context).load(article.urlToImage)
                    .into(itemBinding.ivArticleImage)
            }else{
                itemBinding.ivArticleImage.setImageDrawable(R.drawable.tesla_image.toDrawable())
            }
            itemBinding.root.setOnClickListener {
                itemClickListener?.let {
                    it(article)
                }
            }
            itemBinding.saveBtn.setOnClickListener{
                newsSaveListener?.let {
                    it(article)
                }
            }
            itemBinding.fevBtn.setOnClickListener {
                newsDeleteListener?.let {
                    it(article)
                }
            }
        }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: PostListItemBinding =
            PostListItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}