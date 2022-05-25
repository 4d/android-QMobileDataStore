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
import androidx.room.Transaction
import androidx.room.Update

@Suppress("TooManyFunctions")
@Dao
interface ActionTaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: ActionTask): Long

    @Query("DELETE FROM ActionTask WHERE id = :taskID")
    suspend fun deleteOne(taskID: Long)

    @Query("SELECT * FROM ActionTask")
    fun getAll(): LiveData<List<ActionTask>>

    @Query("SELECT * FROM ActionTask WHERE status = 'PENDING'")
    fun getAllPending(): LiveData<List<ActionTask>>

    @Query("SELECT * FROM ActionTask WHERE id = :taskID")
    fun getOne(taskID: Long): LiveData<ActionTask>

    @Query("DELETE FROM ActionTask")
    suspend fun deleteAll()

    /**
     * Inserts a list of entities
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(obj: List<ActionTask>): List<Long>

    /**
     * Updates an entity
     */
    @Update
    suspend fun update(obj: ActionTask)

    /**
     * Updates a list of entities
     */
    @Update
    suspend fun updateAll(objList: List<ActionTask>)

    /**
     * Tries to insert an entity. If it already exists, updates it.
     */
    @Transaction
    suspend fun insertOrUpdate(obj: ActionTask) {
        val id = insert(obj)
        if (id == -1L) {
            update(obj)
        }
    }

    /**
     * Tries to insert a list of entities. If an entity already exists, updates it.
     */
    @Transaction
    suspend fun insertOrUpdateAll(objList: List<ActionTask>) {
        val insertResult = insertAll(objList)
        val updateList = mutableListOf<ActionTask>()

        for (i in insertResult.indices) {
            if (insertResult[i] == -1L) updateList.add(objList[i])
        }

        if (updateList.isNotEmpty()) updateAll(updateList)
    }
}
