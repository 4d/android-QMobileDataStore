/*
 * Created by Quentin Marciset on 18/6/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmarciset.androidmobiledatastore.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ConverterUtils {

    fun <T> customTableObjectToString(gson: Gson, entity: T): String =
        if (entity == null) "" else gson.toJson(entity)

    inline fun <reified T : Any> customTableStringToObject(gson: Gson, str: String?): T? {
        if (str.isNullOrEmpty())
            return null
        val entitiesType = object : TypeToken<T>() {}.type
        return gson.fromJson(str, entitiesType)
    }
}
