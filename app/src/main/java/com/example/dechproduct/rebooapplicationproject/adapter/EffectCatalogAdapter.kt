package com.example.dechproduct.rebooapplicationproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.model.MockEffectCatalogDataItem
import com.example.dechproduct.rebooapplicationproject.model.MockExampleDataItem
import kotlinx.android.synthetic.main.fragment_activity_sound_effect_catalog.view.*

class EffectCatalogAdapter(private val  exampleList: List<MockEffectCatalogDataItem>): RecyclerView.Adapter <EffectCatalogAdapter.EffectCatalogViewHolder>(){


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): EffectCatalogViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_activity_sound_effect_catalog , parent, false)
            return EffectCatalogViewHolder(itemView)
        }

        override fun onBindViewHolder(
            holder: EffectCatalogViewHolder,
            position: Int
        ) {
            val currentItem = exampleList[position]
            holder.imageView.setImageResource(currentItem.imageFix)
            holder.imageView2.setImageResource(currentItem.imagePlayFix)

            holder.textName.text = currentItem.textName
            holder.textPitch.text = currentItem.textPitch

        }

        override fun getItemCount() = exampleList.size

        class EffectCatalogViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.img_open_fix2
            val imageView2: ImageButton = itemView.btn_play2

            val textName: TextView = itemView.tv_name_add2
            val textPitch: TextView = itemView.tv_pitch_recommend
        }


    }

private fun ImageButton.setImageResource(imagePlayFix: String) {

}
