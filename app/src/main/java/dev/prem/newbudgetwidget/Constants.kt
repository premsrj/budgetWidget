package dev.prem.newbudgetwidget

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

object Constants {
    const val PREF_KEY_MONTHLY_BUDGET: String = "MONTHLY_BUDGET"

    val dateFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")

    val simpleDateFormat: SimpleDateFormat =
        SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault())
}
