package com.example.dechproduct.rebooapplicationproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.model.MockExampleDataItem
import kotlinx.android.synthetic.main.fragment_activity_sound_details.view.*


// Normal Adapter

class OpenAudioActivityAdapter(
        private val  exampleList: List<MockExampleDataItem>,
        private val listener: OnItemClickListener,
        ): RecyclerView.Adapter <OpenAudioActivityAdapter.OpenAudioViewHolder>(){


    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): OpenAudioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_activity_sound_details , parent, false)
        return OpenAudioViewHolder(itemView)

    }

    override fun onBindViewHolder(
            holder: OpenAudioViewHolder,
            position: Int
    ) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageFix)
        holder.imageView2.setImageResource(currentItem.imagePlayFix)

        holder.textName.text = currentItem.textName
        holder.textDate.text = currentItem.textDate.toString()
        holder.textTimeRecord.text = currentItem.timeRecord.toString()

//        if (position == 0){
//            holder.textName.setBackgroundColor(Color.YELLOW)
//        }else
//            holder.textName.setBackgroundColor((Color.GREEN))

    }

    override fun getItemCount()= exampleList.size

    inner class OpenAudioViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener{
        val imageView: ImageView = itemView.img_open_fix
        val textName: TextView = itemView.tv_name_add
        val textDate: TextView = itemView.tv_date_add
        val textTimeRecord: TextView = itemView.tv_time_record
        val imageView2: ImageButton = itemView.btn_playOpen

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            listener.onItemClick(position)
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    private fun ImageButton.setImageResource(imagePlayFix: String) {}



}
/* View Binding

class OpenAudioActivityAdapter(private val  fragment: Fragment): RecyclerView.Adapter<OpenAudioActivityAdapter.OpenAudioViewHolder>() {

    inner class OpenAudioViewHolder (val binding:FragmentActivitySoundDetailsBinding):
            RecyclerView.ViewHolder (binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenAudioViewHolder {
    return   OpenAudioViewHolder(
            FragmentActivitySoundDetailsBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false )
            )
    }


    //callback functiuon
    private val differCallback = object : DiffUtil.ItemCallback<MockExampleDataItem>(){
        override fun areItemsTheSame(oldItem: MockExampleDataItem, newItem: MockExampleDataItem): Boolean {
            return oldItem.textName == newItem.textName
        }

        override fun areContentsTheSame(oldItem: MockExampleDataItem, newItem: MockExampleDataItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onBindViewHolder(holder: OpenAudioViewHolder, position: Int) {
        val currAct = differ.currentList[position]

        holder.binding.apply {
            tvNameAdd.text = currAct.textName
            tvDateAdd.text = currAct.textDate.toString()
            tvTimeRecord.text = currAct.timeRecord.toString()
        }

        /* EX 1 About Fragment Direction --> ไป ลากโยงหน้าที่ไฟล์  nav_graph ให้หน้าไหนไปไหนก็จัดเลย
       holder.itemView.setOnClickListener{
             mView -> if (currAct.dataInModelClass !!.isNotBlank()) {
               val direction = XXFragmentDirections
                   .actionXXFragmentToActivityYYFragment(currAct)
               mView.findNavController().navigate(direction)
               //(fragment as FavoriteFragment)
           }
       }
       //Ex2
       holder.binding.ibMore.setOnClickListener {
            val popup = fragment.context?.let {
                PopupMenu(it,
                    holder.binding.ibMore
                )
            }

            popup?.menuInflater?.inflate(
                R.menu.menu_adapter_more,
                popup.menu
            )


            popup?.setOnMenuItemClickListener { item ->

                if (item.itemId == R.id.action_delete_fav_act) {
                    if (fragment is FavoriteFragment) {
                        fragment.deleteFavActivity(currAct)
                    }
                }
                true
            }
            popup?.show()
        }


         */

    }

    override fun getItemCount() = differ.currentList.size

}


*/



