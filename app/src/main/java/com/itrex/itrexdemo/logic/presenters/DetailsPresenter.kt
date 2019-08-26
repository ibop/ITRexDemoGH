package com.itrex.itrexdemo.logic.presenters

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.InjectViewState
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.presentation.views.DetailsMvpView
import java.security.SecureRandom

@InjectViewState
class DetailsPresenter : BasePresenter<DetailsMvpView>() {

    /**
     * Generate data for chart
     */
    fun setDataForChart(
        chart1: LineChart,
        context: Context?
    ) {
        val xAxis = chart1.xAxis
        //X
        xAxis.axisMaximum = 20f
        xAxis.axisMinimum = 0f


        val values2 = ArrayList<Entry>()

        //generate random data
        val rnd = SecureRandom()
        for (i in 0..20) {
            values2.add(Entry(i.toFloat(), rnd.nextFloat() * 10f))
        }

        val dataSets = ArrayList<LineDataSet>()
        dataSets.add(getSet(values2, context)) // add the data sets

        // create a data object with the data sets
        val data = LineData(dataSets as List<ILineDataSet>?)
        data.setDrawValues(false)

        // set data
        chart1.data = data

        (context as Activity).runOnUiThread {
            chart1.invalidate()
            viewState.showFields(R.string.description)
        }
    }

    /**
     * UI settings
     */
    private fun getSet(
        values2: ArrayList<Entry>,
        context: Context?
    ): LineDataSet {
        val set1 = LineDataSet(values2, context?.getString(R.string.dataset))

        set1.mode = LineDataSet.Mode.HORIZONTAL_BEZIER

        //border of line (middle)
        set1.color = ContextCompat.getColor(context!!, R.color.white)

        set1.setDrawCircles(false)
        set1.lineWidth = 2f
        set1.circleRadius = 3f
        set1.fillAlpha = 255
        set1.valueTextColor = ContextCompat.getColor(context, R.color.white)
        set1.setDrawFilled(true)

        val drawable = ContextCompat.getDrawable(context, R.drawable.fade_red)
        set1.fillDrawable = drawable

        //above
        set1.highLightColor = Color.rgb(255, 255, 255)

        set1.setDrawCircleHole(false)

        return set1
    }

    /**
     * Show Data on the screen
     */
    fun initData(priceModel: PriceModel?) {
        if (priceModel == null) {
            return
        }

        viewState.setKey(priceModel.key)
        viewState.setValue(priceModel.value)
    }

    fun loadData(chart1: LineChart, context: Context?) {
        Thread(Runnable {
            //simulate loading from backend
            Thread.sleep(700)

            //simulate handling answer
            setDataForChart(chart1, context)

        }).start()
    }
}