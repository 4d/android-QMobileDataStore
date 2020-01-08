package com.qmarciset.androidmobiledatastore.db

import com.qmarciset.androidmobiledatastore.dao.BaseDao

interface AppDatabaseInterface {

    fun <T> getDao(tableName: String): BaseDao<T>
}
