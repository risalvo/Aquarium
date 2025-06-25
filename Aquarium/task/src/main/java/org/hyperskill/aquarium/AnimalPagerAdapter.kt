package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimalPagerAdapter(
    private val imageList: List<String>,
    private val nameList: List<String>,
    private val descriptionList: List<String>
) : RecyclerView.Adapter<AnimalPagerAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.image_view)
        private val nameTextView: TextView = view.findViewById(R.id.tv_name)
        private val descriptionTextView: TextView = view.findViewById(R.id.tv_description)

        fun bind(imageUrl: String, name: String, description: String) {
            nameTextView.text = name
            descriptionTextView.text = description

            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.page_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(imageList[position], nameList[position], descriptionList[position])
    }

    override fun getItemCount(): Int = imageList.size
}