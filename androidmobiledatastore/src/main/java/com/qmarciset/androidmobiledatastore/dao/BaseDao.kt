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
import androidx.room.Update

interface BaseDao<T> {

    val tableName: String

    /**
     * Inserts a list of entities
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(obj: List<T>)

    /**
     * Inserts an entity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    /**
     * Updates an entity
     */
    @Update
    fun update(obj: T)

    /**
     * Deletes an entity
     */
    @Delete
    fun delete(obj: T)

    /**
     * To be overridden
     */

    /**
     * Gets all entities
     */
    fun getAll(): LiveData<List<T>>

    /**
     * Gets an entity
     */
    fun getOne(id: String): LiveData<T>

    /**
     * Deletes table
     */
    fun deleteAll()

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
