package com.example.kotlinapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class FlowerModel (
    var name:String,
    var price: Int,
    var image: Int
        ): Parcelable