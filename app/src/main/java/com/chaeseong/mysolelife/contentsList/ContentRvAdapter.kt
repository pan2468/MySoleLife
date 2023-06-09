package com.chaeseong.mysolelife.contentsList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chaeseong.mysolelife.R

class ContentRvAdapter(val context: Context, val items: ArrayList<ContentModel>, val keyList: ArrayList<String>): RecyclerView.Adapter<ContentRvAdapter.Viewholder>() {

//	interface ItemClick{
//		fun onClick(view: View, position: Int)
//	}
//	var itemClick: ItemClick? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRvAdapter.Viewholder {
		val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
		return Viewholder(v)
	}

	override fun onBindViewHolder(holder: ContentRvAdapter.Viewholder, position: Int) {

//		if(itemClick != null){
//			holder.itemView.setOnClickListener { v ->
//				itemClick?.onClick(v, position);
//			}
//		}

		holder.bindItems(items[position])
	}

	override fun getItemCount(): Int {
		return items.size
	}

	inner class Viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

		fun bindItems(item: ContentModel) {

			itemView.setOnClickListener {
				Toast.makeText(context, item.title, Toast.LENGTH_LONG).show()
				val intent = Intent(context, ContentShowActivity::class.java)
				intent.putExtra("url",item.webUrl)
				itemView.context.startActivity(intent)
			}

		val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
		val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
		val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

			bookmarkArea.setOnClickListener {
				Toast.makeText(context, keyList.toString(), Toast.LENGTH_LONG).show()
			}

			contentTitle.text = item.title
			Glide.with(context)
				.load(item.imageUrl)
				.into(imageViewArea)


		}
	}
}