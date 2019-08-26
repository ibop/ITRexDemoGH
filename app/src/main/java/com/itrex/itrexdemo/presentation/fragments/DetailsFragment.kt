package com.itrex.itrexdemo.presentation.fragments

import android.content.Context
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.logic.presenters.DetailsPresenter
import com.itrex.itrexdemo.presentation.views.DetailsMvpView
import kotlinx.android.synthetic.main.action_bar_layout.*
import kotlinx.android.synthetic.main.fragment_details_layout.*

class DetailsFragment : BaseFragment<DetailsMvpView, DetailsPresenter>(), DetailsMvpView {

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_details_layout
    }

    override fun initActions() {
        initViews()
        presenter.initData(arguments)
    }

    private fun initViews() {
        setTitle()

        vListBack.setOnClickListener {
            activity?.onBackPressed()
        }

        presenter.loadData(chart1, activity as Context)
    }

    /**
     * Title of the screen
     */
    private fun setTitle() {
        vTitle.text = getString(R.string.details)
    }

    override fun setKey(key: String) {
        vTvKeyDetails.text = key
    }

    override fun setValue(value: Float) {
        vTvValueProduct.text = String.format("%.2f", value)
    }

    override fun showFields(resIdString: Int) {
        animate(vDetailsLayout)
        vPrDetails.visibility = View.GONE
        vSvDetailsText.visibility = View.VISIBLE
        vChartLayout.visibility = View.VISIBLE
        vTvDescTitle.visibility = View.VISIBLE
        vTvDescription.text = getString(resIdString)
    }
}