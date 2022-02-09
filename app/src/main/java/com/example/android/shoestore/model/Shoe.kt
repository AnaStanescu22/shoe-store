package com.example.android.shoestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(val name: String, val size: Double, val company: String, val description: String,
                val images: List<String> = mutableListOf()) : Parcelable