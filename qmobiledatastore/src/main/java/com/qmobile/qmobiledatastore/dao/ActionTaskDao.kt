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
abstract class ActionTaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(obj: ActionTask): Long

    @Query("DELETE FROM ActionTask WHERE id = :taskID")
    abstract suspend fun deleteById(taskID: Long)

    @Query("SELECT * FROM ActionTask")
    abstract fun getAll(): LiveData<List<ActionTask>>

    @Query("DELETE FROM ActionTask")
    abstract suspend fun deleteAll()
}
