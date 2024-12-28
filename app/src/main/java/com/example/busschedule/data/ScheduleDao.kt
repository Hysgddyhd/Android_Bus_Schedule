package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("Select * from Schedule order by arrival_time asc")
    fun getAllRoutine() : Flow<List<BusSchedule>>

    @Query("Select * from Schedule where stop_Name= :stopName order by arrival_time asc")
    fun getRoutineByName(stopName:String ): Flow<List<BusSchedule>>
}