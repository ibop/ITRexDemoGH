package com.itrex.itrexdemo.presentation.fragments

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.logic.adapters.PriceAdapter
import com.itrex.itrexdemo.logic.presenters.ListPresenter
import com.itrex.itrexdemo.presentation.activities.MainActivity
import com.itrex.itrexdemo.presentation.views.ListMvpView
import kotlinx.android.synthetic.main.action_bar_layout.*
import kotlinx.android.synthetic.main.fragment_list_layout.*

class ListFragment : BaseMvpFragment<ListMvpView, ListPresenter>(), ListMvpView {

    @InjectPresenter
    lateinit var presenter: ListPresenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_list_layout
    }

    override fun initActions() {
        initViews()
    }

    private fun initViews() {
        setTitle()
        initList()
        vListBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setTitle() {
        vTitle.text = getString(R.string.details)
    }

    private fun initList() {
        vRvPrices.layoutManager = LinearLayoutManager(context)
        vRvPrices.adapter = PriceAdapter(presenter.getListData(), View.OnClickListener {
            (activity as MainActivity).priceModel = it.tag as PriceModel
            openFragment(DetailsFragment::class.java)
        })
    }
}