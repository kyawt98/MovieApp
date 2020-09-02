package com.kyawt.shimmertesting.view.exts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun Context.viewBinding(layoutRes: Int, container : ViewGroup) : View{
    return LayoutInflater.from(this).inflate(layoutRes,container,false)
}