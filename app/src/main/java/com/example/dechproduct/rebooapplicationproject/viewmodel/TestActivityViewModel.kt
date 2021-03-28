package com.example.dechproduct.rebooapplicationproject.viewmodel

//This Class use for give the logic with our view mark that we will not contact with fragment directly
// !! CONCEPT !! ->  VIEWMODEL will contact with LIVEDATA and then PASS LIVEDATA to FRAGMENT (view model and fragment will not know each other)

/* ex)
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class TestActivityViewModel: ViewModel() {
                                                                                            //1 declare variable + create liveData that we want to use in Fragment

    private val apiService = TestActivityAPIService()                                       //service from retrofit
    private val compositeDisposable = CompositeDisposable()                                 //rxjava

    val  loadTestActivity        = MutableLiveData<Boolean>()                               //Live Data object -> MutableLiveData = can change data , ImmutableLive = can't change (read doc)
    val  testActivityResponse    = MutableLiveData<TestActivity>()
    val  testActivityLoadError   = MutableLiveData<Boolean>()


                                                                                            //2 Get Data from API in Kotlin (i used Rxjava) -> ถ้าไม่ดึง api ก็ไม่ต้องสนใจจ้า ยกตัวอย่างให้ดูตอนมันใช้ค่าจาก liveData ที่สร้างมาเฉยๆ

    fun  getTestActivityFromAPI(){
        loadTestActivity.value = true                                                       // use liveData that we have created and pass in function for check that api has load or not
        compositeDisposable.add(
                apiService.getTestActivity()
                        .subscribeOn(Schedulers.newThread())                                //Rx มีความยืดหยุ่นในการใช้งานสูงมาก จึงมีคำสั่งให้กำหนดได้ว่าจะคำสั่งทำงานใน Thread ไหน โดยกำหนดด้วยคำสั่ง subscribeOn -> subscribeOn(Schedules.io()) จะไปบอกให้ Observable เรียกคำสั่ง getXX บน Thread ที่อยู่ในรูปแบบของ Thread Pool แทน จึงแก้ปัญหา Block UI Thread ได้อย่างง่ายดาย
                        .observeOn(AndroidSchedulers.mainThread())                          //กำหนด Thread ให้กับ Subscriber จะใช้คำสั่ง observeOn -> กำหนดให้ Subscriber ส่งผลลัพธ์เข้ามาใน onNext, onCompleted และ onError โดยทำงานอยู่บน UI Thread (Main Thread) ทั้งหมด ** AndroidSchedulers.mainThread() เป็นคำสั่งของ RxAndroid , observeOn นั้นเป็นคำสั่งของ RxJava
                        .subscribeWith(
                                object : DisposableSingleObserver<TestActivity>(){
                                    override fun onSuccess(value: TestActivity?) {        // เมื่อ Observable ทำงานเสร็จหมดแล้ว Method นี้ก็จะถูกเรียกเพื่อให้รู้ว่า Observable ทำงานเสร็จแล้ว
                                        loadTestActivity.value = false                    // set livedata value = false (.value คือ setter เขียนง่ายโพด​!!)
                                        TestActivityResponse.value = value
                                        TestActivityLoadError.value = false
                                    }

                                    override fun onError(e: Throwable?) {                   //เมื่อคำสั่งที่ทำงานเกิดปัญหาใดๆก็ตาม จะเข้ามาที่ Method ตัวนี้แทน onNext และ onCompleted เพื่อที่จะได้จัดการกับ Error ที่เกิดขึ้น
                                        loadTestActivity.value = false
                                        testActivityLoadError.value = false
                                        e!!.printStackTrace()
                                    }
                                }
                        )
        )
    }





}

//Flow   x1) Navigation (res - Front)
     ->  x2) XML (res - Front)
     -> v/3)Fragment that you choose for show ui (Front + Back)        <-----|
                                                                             |swap ไปมา บางทีก็สร้าง viewModel ก่อน แล้วค่อยเอาไปแสดงที่ fragment
     -> v/4) ViewModel that handle logic (Back -> u must do this ja)   <-----|
        !! Database will use with room and repository so, in this time i will not do it ja
 */