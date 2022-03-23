/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.db

import com.qmobile.qmobiledatastore.dao.ActionTaskDao
import com.qmobile.qmobiledatastore.dao.BaseDao
import com.qmobile.qmobiledatastore.dao.RelationBaseDao
import com.qmobile.qmobiledatastore.data.RoomRelation

interface DaoProvider {

    // Returns the correct DAO object of specific type
    fun <T : Any> getDao(tableName: String): BaseDao<T>
    fun getActionTaskDao(): ActionTaskDao

    // Offers the possibility to populate the database for test purposes
//    fun populateDatabase()

    fun getRelationDao(tableName: String, relatedTableName: String, relationName: String): RelationBaseDao<RoomRelation>
}
