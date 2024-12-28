package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BusSchedule::class), version = 1, exportSchema = true)
abstract class RoutineDatabase:RoomDatabase() {
    abstract fun scheduleDao() :ScheduleDao

    companion object{
        @Volatile
        private var Instance: RoutineDatabase? = null

        fun getDatabase(context: Context): RoutineDatabase {
            // if the Instance is not null, return it, otherwise create a new database Instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    RoutineDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }

}