package com.gunder.myservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {
    companion object {
        private val TAG = MyBoundService::class.java.simpleName
    }

    private var mBinder = MyBinder()
    private var startTime = System.currentTimeMillis()
    private var mTimer: CountDownTimer = object : CountDownTimer(100000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val elapsedTime = System.currentTimeMillis() - startTime
            Log.d(TAG, "onClick: $elapsedTime")
        }

        override fun onFinish() {

        }
    }

    internal inner class MyBinder : Binder() {
        val getService: MyBoundService = this@MyBoundService
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind")
        mTimer.start()
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG,"onUnBind")
        mTimer.cancel()
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind")
    }
}