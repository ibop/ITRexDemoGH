package com.itrex.itrexdemo.presentation.views

interface DetailsMvpView : BaseMvpView {
    fun setKey(key: String)
    fun setValue(value: Float)
    fun showFields(description: Int)
}