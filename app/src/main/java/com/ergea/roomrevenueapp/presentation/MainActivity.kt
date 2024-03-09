package com.ergea.roomrevenueapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ergea.roomrevenueapp.presentation.adapter.RowAdapter
import com.ergea.roomrevenueapp.data.network.api.model.RoomRevenueRequest
import com.ergea.roomrevenueapp.databinding.ActivityMainBinding
import com.ergea.roomrevenueapp.utils.getCurrentDate
import com.ergea.roomrevenueapp.utils.proceed
import com.ergea.roomrevenueapp.utils.showDatePickerDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val rowAdapter: RowAdapter by lazy {
        RowAdapter { data -> }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onFirstLaunch()
        initUiListener()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onFirstLaunch() {
        getData(getCurrentDate())
        setRecyclerViewTable()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initUiListener() {
        binding.run {
            tvDate.text = getCurrentDate()
            icRefresh.setOnClickListener {
                getData(tvDate.text.toString().trim())
            }
            icDate.setOnClickListener {
                this@MainActivity.supportFragmentManager.showDatePickerDialog {
                    tvDate.text = it
                    getData(it)
                }
            }
        }
    }

    private fun getData(date: String) = with(viewModel) {
        postRoomRevenue(
            RoomRevenueRequest(
                request = RoomRevenueRequest.Request(
                    0,
                    false,
                    false,
                    0,
                    0,
                    date
                )
            )
        )
    }

    private fun setRecyclerViewTable() {
        binding.rvTable.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@MainActivity.rowAdapter
            isNestedScrollingEnabled = false
        }
        setObserveDataTable()
    }

    private fun setObserveDataTable() = binding.run {
        viewModel.response.observe(this@MainActivity) {
            it.proceed(
                doOnSuccess = { result ->
                    pbLoading.isVisible = false
                    tvEmpty.isVisible = false
                    rvTable.isVisible = true
                    result.payload?.let { payload ->
                        rowAdapter.setItems(payload)
                    }
                },
                doOnLoading = {
                    pbLoading.isVisible = true
                    tvEmpty.isVisible = false
                    rvTable.isVisible = false
                },
                doOnError = { err ->
                    pbLoading.isVisible = false
                    tvEmpty.isVisible = true
                    rvTable.isVisible = false
                    tvEmpty.text = err.exception.toString()
                },
                doOnEmpty = {
                    pbLoading.isVisible = false
                    tvEmpty.isVisible = true
                    rvTable.isVisible = false
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}