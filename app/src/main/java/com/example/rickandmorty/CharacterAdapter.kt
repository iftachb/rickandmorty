package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(val activity: FragmentActivity,
                       val results: List<Results>
): RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(activity, view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        return holder.bind(results[position])
    }
}

class CharacterViewHolder(val activity: FragmentActivity, itemView : View): RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.tvName)
    private val image: ImageView = itemView.findViewById(R.id.ivImage)

    fun bind(result: Results) {
        name.text = result.name
        Glide.with(itemView.context).load(result.image).into(image)

        itemView.setOnClickListener {
            val ft: FragmentTransaction = activity.supportFragmentManager.beginTransaction()
            ft.addToBackStack("details")
            ft.setCustomAnimations(R.anim.slide_in,
                R.anim.fade_out,
                 R.anim.fade_in,
                R.anim.slide_out)
            ft.replace(R.id.llMainScreenContainer, CharacterDetailsScreenFragment.newInstance(
                layoutPosition
            )).commit ()
        }
    }

}
