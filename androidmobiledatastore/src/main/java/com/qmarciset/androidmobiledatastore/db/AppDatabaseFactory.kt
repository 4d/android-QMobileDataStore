/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.qmarciset.androidmobiledatastore.DATABASE_NAME

object AppDatabaseFactory {

    // For Singleton instantiation
    @Volatile
    var INSTANCES = mutableMapOf<Class<*>, Any>()

    /**
     * Returns instanced database or builds a new one
     */
    @Suppress("UNCHECKED_CAST")
    fun <T : RoomDatabase> getAppDatabase(context: Context, roomDatabaseClass: Class<T>): T {
        val tempInstance = INSTANCES[roomDatabaseClass] as? T
        tempInstance?.let {
            return it
        }

        synchronized(this) {
            return buildDatabase(context, roomDatabaseClass)
        }
    }

    /**
     * Builds database
     */
    private fun <T : RoomDatabase> buildDatabase(
        context: Context,
        roomDatabaseClass: Class<T>
    ): T {
        val instance = Room.databaseBuilder(
            context.applicationContext,
            roomDatabaseClass,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                }
            })
            .build()
        INSTANCES[roomDatabaseClass] = instance
        return instance
    }

    /**
     * Destroys given database
     */
    fun <T : RoomDatabase> destroyDatabase(roomDatabaseClass: Class<T>) {
        INSTANCES.remove(roomDatabaseClass)
    }

    /**
     * Destroys all databases
     */
    fun destroyDatabases() {
        INSTANCES.clear()
    }
}
