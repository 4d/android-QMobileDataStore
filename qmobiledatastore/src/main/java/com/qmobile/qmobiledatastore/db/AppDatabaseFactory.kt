/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import timber.log.Timber
import com.qmobile.qmobiledatastore.utils.DATABASE_NAME

object AppDatabaseFactory {

    // For Singleton instantiation
//    @Volatile
//    var INSTANCES = mutableMapOf<Class<*>, Any>()

    lateinit var db: RoomDatabase

    /**
     * Returns instanced database or builds a new one
     */
//    @Suppress("UNCHECKED_CAST")
//    fun <T : RoomDatabase> getAppDatabase(context: Context, roomDatabaseClass: Class<T>): T {
//        val tempInstance = INSTANCES[roomDatabaseClass] as? T
//        tempInstance?.let {
//            return it
//        }
//
//        synchronized(this) {
//            return buildDatabase(context, roomDatabaseClass)
//        }
//    }

    /**
     * Builds database
     */
//    private fun <T : RoomDatabase> buildDatabase(
//        context: Context,
//        roomDatabaseClass: Class<T>
//    ): T {
//        val instance = Room.databaseBuilder(
//            context.applicationContext,
//            roomDatabaseClass,
//            DATABASE_NAME
//        )
//            .allowMainThreadQueries()
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                }
//            })
//            .build()
//        INSTANCES[roomDatabaseClass] = instance
//        return instance
//    }

    /**
     * Destroys given database
     */
//    fun <T : RoomDatabase> destroyDatabase(roomDatabaseClass: Class<T>) {
//        INSTANCES.remove(roomDatabaseClass)
//    }

    /**
     * Destroys all databases
     */
//    fun destroyDatabases() {
//        INSTANCES.clear()
//    }

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
                    Timber.i("No embedded database")
                }
                builder = builder.addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }
                )
                db = builder.build()
                // Alternatively, this worked too
//                if (!context.getDatabasePath(DATABASE_NAME).exists()) {
//                    // Read static database
//                    val source = context.applicationContext.assets.open("static.db").use {
//                        it.readBytes()
//                    }
//                    // Write to Room database
//                    with(context.getDatabasePath(DATABASE_NAME)) {
//                        val folder = path.substringBeforeLast(File.separator)
//                        File(folder).mkdirs()
//                        writeBytes(source)
//                    }
//                }
//                db = Room.databaseBuilder(context.applicationContext,
//                    roomDatabaseClass, DATABASE_NAME)
//                    .build()
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
