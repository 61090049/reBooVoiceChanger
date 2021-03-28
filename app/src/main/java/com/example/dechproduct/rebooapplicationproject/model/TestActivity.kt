package com.example.dechproduct.rebooapplicationproject.model

//** when want to create model class ,we can use !! JSON To Kotlin Plugin !! in android studio -> 1) define class name 2) put json 3) finish
// This is model class i know that u can do, so fighting -> remember we mustn't write getter setter

/* ex) ตัวอย่างการใข้ model class

1) OnlyModel Class
data class TestActivity(
    val accessibility: Double?,
    val activity: String?,
    val key: String?,
    val link: String?,
    val participants: Int?,
    val price: Double?,
    val type: String?
):Parcelable

2) Model Class with ROOM Database + Parcelable

@Parcelize
@Entity(tableName = "fav_activity_table")
data class TestActivity(
        val accessibility: Double?,
        val activity: String?,
        val key: String?,
        val link: String?,
        val participants: Int?,
        val price: Double?,
        val type: String?
) : Parcelable{

    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    // สร้างไฟล์ dao ใน  package db ต่อ (ถ้าทำ room นะ)
}

 */