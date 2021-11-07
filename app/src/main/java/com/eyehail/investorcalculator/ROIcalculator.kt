package com.eyehail.investorcalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.lang.Math.random
import kotlin.random.Random

class ROIcalculator : AppCompatActivity() {
    var data: List<Float> = List(12) { Random.nextFloat() }
    val monthnames: List<String> = listOf("Jan", "Feb", "Mar", "Apr", "May", "June", "July",
        "Aug", "Sep", "Oct", "Nov", "Dec")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roicalculator)
        //val data = (40000..130000).map { Random.nextInt(to - from) + from }.asList()

        setupPieChart()



    }
    fun setupPieChart() {
        val pieEntryies = ArrayList<PieEntry>()
        for (i in 0 until data.size) {

            pieEntryies.add(PieEntry(data[i], monthnames[i]))
        }
        var dataSet = PieDataSet(pieEntryies, "Some random digits")
        val MY_COLORS = intArrayOf(
            Color.rgb(192, 0, 0),
            Color.rgb(255, 0, 0),
            Color.rgb(255, 192, 0),
            Color.rgb(127, 127, 127),
            Color.rgb(146, 208, 80),
            Color.rgb(0, 176, 80),
            Color.rgb(79, 129, 189)
        )
        val colors = ArrayList<Int>()

        for (c in MY_COLORS) colors.add(c)

        dataSet.colors = colors
        val dataNew: PieData = PieData(dataSet)


        //get the chart
        val chart: PieChart = findViewById<PieChart>(R.id.roichart)
        chart.setData(dataNew)
        chart.invalidate()

    }
}