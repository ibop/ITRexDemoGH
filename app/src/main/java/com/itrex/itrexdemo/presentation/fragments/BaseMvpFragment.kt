package com.itrex.itrexdemo.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.itrex.itrexdemo.logic.presenters.BasePresenter
import com.itrex.itrexdemo.presentation.activities.BaseActivity
import com.itrex.itrexdemo.presentation.views.BaseMvpView

abstract class BaseMvpFragment<V : BaseMvpView, P : BasePresenter<V>> : MvpAppCompatFragment(),
    BaseMvpView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun openFragment(fragmentClass: Class<out BaseMvpFragment<*, *>>) {
        openFragment(fragmentClass, null)
    }

    fun openFragment(fragmentClass: Class<out BaseMvpFragment<*, *>>, bundle: Bundle?) {
        (activity as BaseActivity).openFragment(fragmentClass, bundle)
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActions()
    }

    abstract fun initActions()

    override fun hideKeyboard() {
        (activity as BaseActivity).hideKeyboard()
    }

    /**
     * Show toast message
     */
    override fun showToast(resId: Int) {
        Toast.makeText(
            activity as Context,
            getString(resId),
            Toast.LENGTH_SHORT
        ).show()
    }
}