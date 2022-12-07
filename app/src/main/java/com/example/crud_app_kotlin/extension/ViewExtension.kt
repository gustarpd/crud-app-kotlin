package com.example.crud_app_kotlin.extension

import android.content.Context
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.hideKeboard() {
    val View = this.currentFocus
    if(View != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(View.windowToken, 0)
    }
}