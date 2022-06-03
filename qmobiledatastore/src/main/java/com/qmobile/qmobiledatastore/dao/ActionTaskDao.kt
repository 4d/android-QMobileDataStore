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

@Suppress("TooManyFunctions")
@Dao
interface ActionTaskDao {

    /**
     * GET
     */
    @Query("SELECT * FROM ActionTask")
    fun getAll(): LiveData<List<ActionTask>>

    @Query("SELECT * FROM ActionTask WHERE status = 'PENDING'")
    fun getAllPending(): LiveData<List<ActionTask>>

    @Query("SELECT * FROM ActionTask WHERE id = :taskID")
    fun getOne(taskID: String): LiveData<ActionTask>

    /**
     * INSERT
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: ActionTask): Long

    /**
     * DELETE
     */
    @Query("DELETE FROM ActionTask WHERE id = :taskID")
    suspend fun deleteOne(taskID: String)

    @Query("DELETE FROM ActionTask")
    suspend fun deleteAll()

    @Query("DELETE FROM ActionTask WHERE id in (:idList)")
    suspend fun deleteList(idList: List<String>)
}
