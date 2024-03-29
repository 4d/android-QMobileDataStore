/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore.db

import com.qmobile.qmobiledatastore.dao.ActionTaskDao
import com.qmobile.qmobiledatastore.dao.BaseDao
import com.qmobile.qmobiledatastore.data.RoomData
import com.qmobile.qmobiledatastore.data.RoomEntity

interface DaoProvider {

    fun getDao(source: String): BaseDao<RoomEntity, RoomData>

    fun getActionTaskDao(): ActionTaskDao
}
