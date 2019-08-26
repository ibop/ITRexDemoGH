package com.itrex.itrexdemo.logic.presenters

import com.arellomobile.mvp.InjectViewState
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.presentation.fragments.ListFragment
import com.itrex.itrexdemo.presentation.views.StartMvpView

@InjectViewState
class StartMvpPresenter : BasePresenter<StartMvpView>() {

    fun onNextClicked(search: String) {
        hideKeyboard()

        if (search.trim().isEmpty()) {
            showToast(R.string.empty_field)
            return
        }

        //open next fragment
        viewState.openListFragment(ListFragment::class.java)
    }
}