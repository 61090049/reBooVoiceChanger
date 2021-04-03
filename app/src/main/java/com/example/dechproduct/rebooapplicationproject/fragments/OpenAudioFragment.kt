package com.example.dechproduct.rebooapplicationproject.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.adapter.OpenAudioActivityAdapter
import com.example.dechproduct.rebooapplicationproject.model.MockExampleDataItem
import kotlinx.android.synthetic.main.fragment_open_audio.*


/* View Binding Recycler
class OpenAudioFragment : Fragment(R.layout.fragment_open_audio) {

    private var _binding: FragmentOpenAudioBinding? = null
    private val binding get() = _binding!!
    private lateinit var mFavActivityAdapter: OpenAudioActivityAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOpenAudioBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = (activity as MainActivity).viewModel    <-- set viewModel Here

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        mFavActivityAdapter = OpenAudioActivityAdapter(this)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mFavActivityAdapter
        }
        /*
        viewModel.allFavActivities.observe(viewLifecycleOwner, { list ->

            list?.let {
                mFavActivityAdapter.differ.submitList(it)
                updateUI(it)
            }
        })
        */
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}


 */
//Normal

class OpenAudioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_open_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exampleDataItem = generateAudioList(500)
        recycler_view.adapter = OpenAudioActivityAdapter(exampleDataItem)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)
    }



    //Mock เฉยๆ ให้ back ไป แยก algo แล้วเอาเข้า viewmodel เองเน้อ
    private fun generateAudioList(size:Int) : List<MockExampleDataItem>{
        val list = ArrayList <MockExampleDataItem>()
        for (i in 0 until size){
            val drawable = when (i%3){
                0 -> R.drawable.ic_favorite
                1 -> R.drawable.ic_home
                else -> R.drawable.ic_music
            }
            val item = MockExampleDataItem(drawable, "Item $i", "Audio List Song Record",2,12.22)
            list += item
        }
        return list


    }

    override fun onDestroy() {
        super.onDestroy()
    }


}

