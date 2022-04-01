/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery

@Suppress("TooManyFunctions")
abstract class BaseDao<T : Any, U : Any> {

    /**
     * Inserts an entity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(obj: U): Long

    /**
     * Inserts a list of entities
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(obj: List<U>): List<Long>

    /**
     * Updates an entity
     */
    @Update
    abstract suspend fun update(obj: U)

    /**
     * Updates a list of entities
     */
    @Update
    abstract suspend fun updateAll(objList: List<U>)

    /**
     * Tries to insert an entity. If it already exists, updates it.
     */
    @Transaction
    open suspend fun insertOrUpdate(obj: U) {
        val id = insert(obj)
        if (id == -1L) {
            update(obj)
        }
    }

    /**
     * Tries to insert a list of entities. If an entity already exists, updates it.
     */
    @Transaction
    open suspend fun insertOrUpdateAll(objList: List<U>) {
        val insertResult = insertAll(objList)
        val updateList = mutableListOf<U>()

        for (i in insertResult.indices) {
            if (insertResult[i] == -1L) updateList.add(objList[i])
        }

        if (updateList.isNotEmpty()) updateAll(updateList)
    }

    /**
     * Deletes an entity
     */
    @Delete
    abstract suspend fun delete(obj: U)

    /**
     * To be overridden by custom Dao
     */

    /**
     * Gets an entity
     */
    abstract fun getOne(id: String): LiveData<T>

    /**
     * Gets all entities
     */
    abstract fun getAll(): LiveData<List<T>>

    /**
     * Get All with paging
     */
    abstract fun getAllPagedList(sqLiteQuery: SupportSQLiteQuery): DataSource.Factory<Int, T>

    abstract fun getAllPagingData(sqLiteQuery: SupportSQLiteQuery): PagingSource<Int, T>

    /**
     * Deletes an entity
     */
    abstract suspend fun deleteOne(id: String)

    /**
     * Deletes table
     */
    abstract suspend fun deleteAll()

    abstract fun getAll(sqLiteQuery: SupportSQLiteQuery): LiveData<List<T>>
}
