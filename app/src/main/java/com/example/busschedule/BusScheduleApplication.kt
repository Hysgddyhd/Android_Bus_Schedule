package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.RoutineDatabase
import com.example.busschedule.data.ScheduleDao

class BusScheduleApplication: Application() {
    val database: RoutineDatabase by lazy {
        RoutineDatabase.getDatabase(this)
    }
}