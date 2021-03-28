package com.example.dechproduct.rebooapplicationproject.fragments

/* ทำ TestActiivityViewModel เสร็จแล้วก็มาทำ TestActiivityfragment ต่อ

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class TestActivityFragment: Fragment(R.layout.fragment_test_activity) {                                        //** 1. เอา fragment หน้านั้นๆ มาพาสค่าไปเลย  ex)fragment_test_activity.xml

    private var _binding: FragmentRandomActivityBinding? = null                                                //** 3. สร้าง object _binding สำหรับใช้กับ fragment ของเรา (class FragmentRandomActivityBinding? มาจาก ViewBinding ไม่ต้องไปสน ดูชื่อพอ )
    private val binding get() = _binding!!                                                                     //** 4. สร้าง object เพื่อเรียกใช้ binding ใครอยากได้ view กะเอาตัวนี้ไป


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                                                                                                                //2 ยังไม่ต้อง return เอาออกก่อน      เอาออก -> return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRandomActivityBinding.inflate( inflater, container, false)                           //** 5. กำหนด object ของ FragmentRandomActivityBinding เข้าไปใน  onCreateVoew
        return binding.root

    }
}

 */