package com.example.movieapp102

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

object AppExecutors {

	private val instance: AppExecutors = getInstance()

	fun getInstance(): AppExecutors {
		return instance
	}

	private val mNetworkIO: ScheduledExecutorService = Executors.newScheduledThreadPool(3);

	fun networkIO() = mNetworkIO
}

