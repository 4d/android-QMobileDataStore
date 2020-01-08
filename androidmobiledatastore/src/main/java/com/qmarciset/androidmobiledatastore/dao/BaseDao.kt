package com.qmarciset.androidmobiledatastore.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    val tableName: String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)

    /**
     * To be overridden
     */

    fun getAll(): LiveData<List<T>>

    fun getOne(id: String): LiveData<T>

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
