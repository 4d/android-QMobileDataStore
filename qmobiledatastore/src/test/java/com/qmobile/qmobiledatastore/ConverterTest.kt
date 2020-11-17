/*
 * Created by Quentin Marciset on 17/11/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore

import com.google.gson.Gson
import com.qmobile.qmobiledatastore.utils.ConverterUtils
import org.junit.Assert
import org.junit.Test
import java.util.UUID

class ConverterTest {

    @Test
    fun customTableObjectToString() {
        val key = UUID.randomUUID().toString()
        var obj = CustomEmployee(__KEY = key)

        var string = ConverterUtils.customTableObjectToString(Gson(), obj)

        Assert.assertEquals("{\"__KEY\":\"$key\"}", string)

        val anotherKey = UUID.randomUUID().toString()
        obj = CustomEmployee(__KEY = key, serviceProperty = Service(__KEY = anotherKey))
        string = ConverterUtils.customTableObjectToString(Gson(), obj)

        Assert.assertEquals(
            "{\"serviceProperty\":{\"__KEY\":\"$anotherKey\"},\"__KEY\":\"$key\"}",
            string
        )
    }

    @Test
    fun customTableStringToObject() {
        val key = UUID.randomUUID().toString()
        var string = "{\"__KEY\":\"$key\"}"

        var obj: CustomEmployee? = ConverterUtils.customTableStringToObject(Gson(), string)

        Assert.assertNotNull(obj)
        Assert.assertEquals(key, obj?.__KEY)
        Assert.assertNull(obj?.__TIMESTAMP)

        val anotherKey = UUID.randomUUID().toString()
        string = "{\"serviceProperty\":{\"__KEY\":\"$anotherKey\"},\"__KEY\":\"$key\"}"

        obj = ConverterUtils.customTableStringToObject(Gson(), string)

        Assert.assertNotNull(obj)
        Assert.assertEquals(key, obj?.__KEY)

        Assert.assertNotNull(obj?.serviceProperty)

        val subObj = obj?.serviceProperty as Service?

        Assert.assertNotNull(subObj)
        Assert.assertEquals(anotherKey, subObj?.__KEY)
    }
}
