package com.qmarciset.androidmobiledatastore

import android.content.Context
import com.qmarciset.androidmobiledatastore.dao.BaseDao

interface AppDatabaseInterface {

    fun getAppDatabase(context: Context): AppDatabaseInterface

    fun <T> getDao(tableName: String): BaseDao<T>
}
