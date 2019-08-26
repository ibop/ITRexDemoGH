package com.itrex.itrexdemo.presentation.activities

import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.presentation.fragments.StartFragment

class MainActivity : BaseActivity() {

    var priceModel: PriceModel? = null

    override fun openDefaultFragment() {
        openFragment(StartFragment::class.java, null)
    }
}
