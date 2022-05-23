/*
 * Created by Houssam Temanni on 23/2/2022.
 * My Company
 * Copyright (c) 2022 Houssam Temanni. All rights reserved.
 */

package com.qmobile.qmobiledatastore.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActionTaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: ActionTask): Long

    @Query("DELETE FROM ActionTask WHERE id = :taskID")
    suspend fun deleteById(taskID: Long)

    @Query("SELECT * FROM ActionTask")
    fun getAll(): LiveData<List<ActionTask>>

    @Query("DELETE FROM ActionTask")
    suspend fun deleteAll()
}
