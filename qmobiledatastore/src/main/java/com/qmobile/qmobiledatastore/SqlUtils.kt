/*
 * Created by qmarciset on 3/11/2022.
 * 4D SAS
 * Copyright (c) 2022 qmarciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore

import androidx.sqlite.db.SimpleSQLiteQuery

object SqlUtils {

    fun String.toSql(): SimpleSQLiteQuery = SimpleSQLiteQuery(this)

    fun StringBuilder.toSql(): SimpleSQLiteQuery = SimpleSQLiteQuery(this.toString())
}
