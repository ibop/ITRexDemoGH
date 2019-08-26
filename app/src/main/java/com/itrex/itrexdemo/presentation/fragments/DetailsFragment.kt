package com.itrex.itrexdemo.presentation.fragments

import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.logic.presenters.DetailsPresenter
import com.itrex.itrexdemo.presentation.activities.MainActivity
import com.itrex.itrexdemo.presentation.views.DetailsMvpView
import kotlinx.android.synthetic.main.action_bar_layout.*
import kotlinx.android.synthetic.main.fragment_details_layout.*

class DetailsFragment : BaseMvpFragment<DetailsMvpView, DetailsPresenter>(), DetailsMvpView {

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_details_layout
    }

    override fun initActions() {
        initViews()
        presenter.initData((activity as MainActivity).priceModel)
    }

    private fun initViews() {
        setTitle()

        vListBack.setOnClickListener {
            activity?.onBackPressed()
        }

        presenter.setDataForChart(chart1, context)
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
}