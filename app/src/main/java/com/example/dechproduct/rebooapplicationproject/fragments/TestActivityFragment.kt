package com.example.dechproduct.rebooapplicationproject.fragments

/* ทำ TestActiivityViewModel เสร็จแล้วก็มาทำ TestActiivityfragment ต่อ

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class TestActivityFragment: Fragment(R.layout.fragment_test_activity) {                                        //** 1. เอา fragment หน้านั้นๆ มาพาสค่าไปเลย  ex)fragment_test_activity.xml

    private var _binding: FragmentTestActivityBinding? = null                                                  //** 3. สร้าง object _binding สำหรับใช้กับ fragment ของเรา (class FragmentRandomActivityBinding? มาจาก ViewBinding ไม่ต้องไปสน ดูชื่อพอ )
    private val binding get() = _binding!!                                                                     //** 4. สร้าง object เพื่อเรียกใช้ binding ใครอยากได้ view กะเอาตัวนี้ไป
    private lateinit var mTestActivityViewModel: TestActivityViewModel                                         //** 6. สร้่าง viewmodel object สำหรับเอาไว้ใช้งานข้อมูลจาก ​ViewModel ของหน้านั้นๆ นั้นๆใน fragment เรา

    private var mProgressDialog: Dialog? = null                                                                //optional test activity 1)-> ถ้าอยากสร้าง progress bar ในหน้านี้ แบบให้มันหมุนติ๊วๆ ก็เรียกเลย


 */
    override fun onCreateView(                                                                                  //Important -> เวลาจะใช้งาน fragment จะประกาศใน onCreateView
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                                                                                                                //2 ยังไม่ต้อง return เอาออกก่อน      ตัวที่เอาออก -> return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentTestActivityBinding.inflate( inflater, container, false)                             //** 5. กำหนด object ของ FragmentTestActivityBinding เข้าไปใน  onCreateView
        return binding.root                                                                                     // .root ใช้สำหรับ return ตัว fragment มันเอง (fragment_test_activity.xml)

    }

     override fun onDestroy() {                                                                                  //Important Fragment Lifecycle
        super.onDestroy()
        _binding = null
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {                                       // ** 7.Implement onViewCreated
      super.onViewCreated(view, savedInstanceState)
      viewModel = (activity as MainActivity).viewModel

      mTestActivityViewModel = ViewModelProvider(this)                                                          // **7.1 เอา viewmodel objectหน้านั้นๆ ที่ประกาศ ใน 6 มาใช้ใน onViewCreated นั้นละ -> syntax) xxViewmodel = ViewModelProvider(this).get(XXActivityViewModel::class.java)
            .get(TestActivityViewModel::class.java)

      mTestActivityViewModel.getTestActivityFromAPI()                                                           // 7.2 พอผูก viewmodel เข้ามากับ ใน fragment แล้ว จะให้ object viewmodel มันทำอะไรก็ทำไป ในที่นี้ให้มันไป call function  get data จาก api
      testActivityViewModelObserver()                                                                           // ** 8 สร้าง function testActivityViewModelObserver()  สำหรับ observer viewmodel ของเรา ว่่ามันทำอะไรอยู่บ้าง

      binding.swipeRefresh.setOnRefreshListener {                                                               // Optional เวลาสมมติต้องการเลื่อนลงแล้วให้มีปุ่ม refresh ก็จะให้ object binding ที่สร้างจาก view binding (FragmentTestActivityBinding)  มาทำการ call swipeRefresh (คือ R.id androidx.swiperefreshlayout.widget.SwipeRefreshLayou ใน xml)
            mTestActivityViewModel.getTestActivityFromAPI()                                                         // และก็ ใช้ function setonRefreshListener ของ swipelayout ->  พอมีการเลื่อน swipe ลงแล้วทำอะไร ? -> ก็จะ ให้ viewmodel object ของ fragment นี้ ไป call function get data จาก api ใหม่
        }

        saveFavAct()
    }


    private fun testActivityViewModelObserver() {                                                               //** 8.1 สร้าง function
            mTestActivityViewModel.testActivityResponse.observe(                                                //** 8.2
                viewLifecycleOwner, { testActivity ->
                    testActivity?.let {

                        currActivity = it

                        if (binding.swipeRefresh.isRefreshing) {
                            binding.swipeRefresh.isRefreshing = false
                        }
                        binding.tvActivity.text = it.activity
                        binding.tvType.text = it.type
                        binding.tvAccessibility.text = it.accessibility.toString()
                        binding.tvParticipants.text = it.participants.toString()
                        binding.tvPrice.text = it.price.toString()
                        color()

                        if (it.link.isNullOrBlank()) {
                            binding.btnSeeMoreDetails.visibility = View.GONE
                        } else {
                            binding.btnSeeMoreDetails.visibility = View.VISIBLE
                            showActivityDetails(it)
                        }
                    }

                }
            )

            mTestActivityViewModel.testActivityLoadingError.observe(
                viewLifecycleOwner,
                { dataError ->
                    dataError?.let {
                        Log.e(
                            "aaa", "testDishViewModelObserver: $dataError"
                        )
                        if (binding.swipeRefresh.isRefreshing) {
                            binding.swipeRefresh.isRefreshing = false
                        }
                    }
                })

            mTestActivityViewModel.loadTestActivity.observe(viewLifecycleOwner, { loadTestDish ->
                loadTestDish.let {
                    if (loadTestDish && !binding.swipeRefresh.isRefreshing) {
                        showProgressDialog()
                    } else {
                        hideProgressDialog()
                    }
                }
            })

        }



}

 */