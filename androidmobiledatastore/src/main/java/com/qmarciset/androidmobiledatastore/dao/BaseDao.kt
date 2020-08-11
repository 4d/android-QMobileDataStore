/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update

@Suppress("TooManyFunctions")
abstract class BaseDao<T> {

    abstract val tableName: String

    /**
     * Inserts an entity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: T): Long

    /**
     * Inserts a list of entities
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAll(obj: List<T>): List<Long>

    /**
     * Updates an entity
     */
    @Update
    abstract fun update(obj: T)

    /**
     * Updates a list of entities
     */
    @Update
    abstract fun updateAll(objList: List<T>)

    /**
     * Tries to insert an entity. If it already exists, updates it.
     */
    @Transaction
    open fun insertOrUpdate(obj: T) {
        val id = insert(obj)
        if (id == -1L) update(obj)
    }

    /**
     * Tries to insert a list of entities. If an entity already exists, updates it.
     */
    @Transaction
    open fun insertOrUpdateAll(objList: List<T>) {
        val insertResult = insertAll(objList)
        val updateList = mutableListOf<T>()

        for (i in insertResult.indices) {
            if (insertResult[i] == -1L) updateList.add(objList[i])
        }

        if (updateList.isNotEmpty()) updateAll(updateList)
    }

    /**
     * Deletes an entity
     */
    @Delete
    abstract fun delete(obj: T)

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
     * Deletes an entity
     */
    abstract fun deleteOne(id: String)

    /**
     * Deletes table
     */
    abstract fun deleteAll()

    // custom query definition
    //    fun customQuery()

    // Get All Entities from Table
    //    fun getAll(): LiveData<List<T>> {
    //        val query = SimpleSQLiteQuery(
    //            "SELECT * FROM $tableName"
    //        )
    //        Timber.d("query sql = ${query.sql}")
    //        return doGetAll(query)
    //    }
    //
    //    @RawQuery(observedEntities = [Employee::class, Service::class])
    //    fun doGetAll(query: SupportSQLiteQuery): LiveData<List<T>>

    // Get Entity with given id from Table
    //    fun getOne(id: String): LiveData<T> {
    //        val query = SimpleSQLiteQuery(
    //            "SELECT * FROM $tableName WHERE __KEY = \"$id\""
    //        )
    //        Timber.d("query sql = ${query.sql}")
    //        return doGetOne(query)
    //    }
    //
    //    @RawQuery(observedEntities = [Employee::class, Service::class])
    //    fun doGetOne(query: SupportSQLiteQuery): LiveData<T>

    // Delete all Entities from Table
    //    fun deleteAll() {
    //        val query = SimpleSQLiteQuery(
    //            "DELETE FROM $tableName"
    //        )
    //        doDeleteAll(query)
    //    }
    //
    //    @RawQuery(observedEntities = [Employee::class, Service::class])
    //    fun doDeleteAll(query: SupportSQLiteQuery): Boolean
}
