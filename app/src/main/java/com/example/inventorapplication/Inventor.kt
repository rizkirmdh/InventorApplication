package com.example.inventorapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Inventor(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
