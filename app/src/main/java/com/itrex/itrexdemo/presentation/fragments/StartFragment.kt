package com.itrex.itrexdemo.presentation.fragments

import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.logic.presenters.StartMvpPresenter
import com.itrex.itrexdemo.presentation.views.StartMvpView
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * Start fragment
 */
class StartFragment : BaseMvpFragment<StartMvpView, StartMvpPresenter>(), StartMvpView {

    @InjectPresenter
    lateinit var presenter: StartMvpPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_start
    }

    override fun initActions() {
        initViews()
    }

    private fun initViews() {
        vBtnStartNext.setOnClickListener {
            presenter.onNextClicked(editText.text.toString())
        }
    }

    /**
     * Openning next fragment
     */
    override fun openListFragment(javaClass: Class<ListFragment>) {
        openFragment(javaClass)
    }
}