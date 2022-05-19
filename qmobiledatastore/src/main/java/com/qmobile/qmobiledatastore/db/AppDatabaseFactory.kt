/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import timber.log.Timber

object AppDatabaseFactory {

    private const val DATABASE_NAME = "4d_sample_app_database"

    private lateinit var db: RoomDatabase

    @Suppress("UNCHECKED_CAST")
    fun <T : RoomDatabase> getAppDatabase(context: Context, roomDatabaseClass: Class<T>): T {
        if (!::db.isInitialized) {
            synchronized(RoomDatabase::class.java) {
                var builder = Room.databaseBuilder(
                    context.applicationContext,
                    roomDatabaseClass,
                    DATABASE_NAME
                )
                if (context.assets.list("databases")?.contains("static.db") == true) {
                    builder = builder.createFromAsset("databases/static.db")
                } else {
                    Timber.d("No embedded database")
                }
                db = builder.build()
            }
        }
        return db as T
    }

    fun close() {
        if (::db.isInitialized) {
            db.close()
        }
    }
}
