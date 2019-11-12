package com.example.notepad.model

import android.os.Parcelable
import android.widget.TextView
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelNote(val text:String, val title:String) : Parcelable