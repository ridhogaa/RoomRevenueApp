package com.ergea.roomrevenueapp.utils

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

const val SLASH_DATE_FORMAT = "dd/MM/yyyy"

fun FragmentManager.showDatePickerDialog(
    executeResult: (date: String) -> Unit,
) {
    val dateFormat = SimpleDateFormat(SLASH_DATE_FORMAT, Locale.getDefault())
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setTextInputFormat(dateFormat)
            .build()
    datePicker.addOnPositiveButtonClickListener {
        executeResult(dateFormat.format(it))
    }
    datePicker.addOnNegativeButtonClickListener {
        datePicker.dismiss()
    }
    datePicker.addOnCancelListener {
        datePicker.dismiss()
    }
    datePicker.show(this, "DATE")
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentDate(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern(SLASH_DATE_FORMAT) // Choose your desired date format
    return currentDate.format(formatter)
}