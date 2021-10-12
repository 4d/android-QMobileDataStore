/*
 * Created by Quentin Marciset on 17/11/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.Assert
import org.junit.Test
import java.util.UUID

class ConverterTest {

    @Test
    fun customTableObjectToString() {
        val key = UUID.randomUUID().toString()
        var obj = CustomEmployee(__KEY = key)

        val mapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerKotlinModule()

        var string = mapper.writeValueAsString(obj)

        Assert.assertEquals(
            "{\"serviceProperty\":null,\"employeesProperty\":null,\"__KEY\":\"$key\",\"__STAMP\":null,\"__GlobalStamp\":null,\"__TIMESTAMP\":null}",
            string
        )

        val anotherKey = UUID.randomUUID().toString()
        obj = CustomEmployee(__KEY = key, serviceProperty = Service(__KEY = anotherKey))
        string = mapper.writeValueAsString(obj)

        Assert.assertEquals(
            "{\"serviceProperty\":{\"__KEY\":\"$anotherKey\",\"__STAMP\":null,\"__GlobalStamp\":null,\"__TIMESTAMP\":null},\"employeesProperty\":null,\"__KEY\":\"$key\",\"__STAMP\":null,\"__GlobalStamp\":null,\"__TIMESTAMP\":null}",
            string
        )
    }

    @Test
    fun customTableStringToObject() {
        val key = UUID.randomUUID().toString()
        var string = "{\"__KEY\":\"$key\"}"

        val mapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerKotlinModule()
        var obj: CustomEmployee? = mapper.readValue(string)

        Assert.assertNotNull(obj)
        Assert.assertEquals(key, obj?.__KEY)
        Assert.assertNull(obj?.__TIMESTAMP)

        val anotherKey = UUID.randomUUID().toString()
        string = "{\"serviceProperty\":{\"__KEY\":\"$anotherKey\"},\"__KEY\":\"$key\"}"

        obj = mapper.readValue(string)

        Assert.assertNotNull(obj)
        Assert.assertEquals(key, obj?.__KEY)

        Assert.assertNotNull(obj?.serviceProperty)

        val subObj = obj?.serviceProperty

        Assert.assertNotNull(subObj)
        Assert.assertEquals(anotherKey, subObj?.__KEY)
    }
}
