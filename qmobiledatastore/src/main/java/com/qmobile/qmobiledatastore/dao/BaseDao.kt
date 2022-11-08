/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

@Suppress("TooManyFunctions")
abstract class BaseDao<T : Any, U : Any> {

    /**
     * GET
     */
    abstract fun getOne(id: String): LiveData<T>

    abstract fun getAll(): LiveData<List<T>>

    abstract fun getAllFlow(sqLiteQuery: SupportSQLiteQuery): Flow<List<T>>

    abstract fun getAllPagingData(sqLiteQuery: SupportSQLiteQuery): PagingSource<Int, T>

    /**
     * INSERT
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(obj: U): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(obj: List<U>): List<Long>

    @Update
    abstract suspend fun update(obj: U)

    @Update
    abstract suspend fun updateAll(objList: List<U>)

    @Transaction
    open suspend fun insertOrUpdate(obj: U) {
        val id = insert(obj)
        if (id == -1L) {
            update(obj)
        }
    }

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
     * DELETE
     */
    abstract suspend fun deleteOne(id: String)

    abstract suspend fun deleteAll()
}
