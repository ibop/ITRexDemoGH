package com.itrex.itrexdemo.presentation.fragments

import android.text.Editable
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.logic.presenters.StartMvpPresenter
import com.itrex.itrexdemo.logic.utils.MyTextWatcher
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

        //next
        vBtnStartNext.setOnClickListener {
            presenter.onNextClicked(editText.text.toString())
        }

        //text change
        editText.addTextChangedListener(object : MyTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                presenter.onTextChanged(s.toString())
            }
        })
    }

    /**
     * Open next fragment
     */
    override fun openListFragment(javaClass: Class<ListFragment>) {
        openFragment(javaClass)
    }

    /**
     * show error message
     */
    override fun setError(errorResId: Int) {
        if (errorResId == 0) {
            vTiStartLayout.error = null
        } else {
            vTiStartLayout.error = getString(errorResId)
        }
    }
}