package com.padc.ponnya.wechat.utils

import java.util.concurrent.TimeUnit

val times: List<Long> = arrayListOf(
    TimeUnit.DAYS.toMillis(365),
    TimeUnit.DAYS.toMillis(30),
    TimeUnit.DAYS.toMillis(1),
    TimeUnit.HOURS.toMillis(1),
    TimeUnit.MINUTES.toMillis(1),
    TimeUnit.SECONDS.toMillis(1))
val timesString = arrayListOf("year", "month", "day", "hour", "minute", "second")

fun Long.toDuration(): String {
    val res = StringBuffer()
    for (i in times.indices) {
        val current = times[i]
        val temp = this / current
        if (temp > 0) {
            res.append(temp).append(" ").append(timesString[i])
                .append(if (temp != 1L) "s" else "").append(" ago")
            break
        }
    }
    return if ("" == res.toString()) "0 seconds ago" else res.toString()
}