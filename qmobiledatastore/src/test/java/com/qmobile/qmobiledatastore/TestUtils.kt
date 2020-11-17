/*
 * Created by Quentin Marciset on 17/11/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

package com.qmobile.qmobiledatastore

data class CustomEmployee(
    val serviceProperty: Service? = null,
    val employeesProperty: Entities<Employee>? = null,
    override val __KEY: String,
    override val __STAMP: Int? = null,
    override val __GlobalStamp: Int? = null,
    override val __TIMESTAMP: String? = null
) : EntityModel

interface EntityModel {
    val __GlobalStamp: Int?
    val __KEY: String?
    val __STAMP: Int?
    val __TIMESTAMP: String?
}

data class Entities<T : EntityModel>(
    val __COUNT: Int?,
    val __GlobalStamp: Int?,
    val __ENTITIES: List<T>?,
    val __FIRST: Int?,
    val __SENT: Int?,
    val __DATACLASS: String?,
    val __entityModel: String?, // filled in Entities response
    val __ENTITYSET: String? // filled in one-to-many relations
)

data class Employee(
    override val __KEY: String,
    override val __STAMP: Int? = null,
    override val __GlobalStamp: Int? = null,
    override val __TIMESTAMP: String? = null
) : EntityModel

data class Service(
    override val __KEY: String,
    override val __STAMP: Int? = null,
    override val __GlobalStamp: Int? = null,
    override val __TIMESTAMP: String? = null
) : EntityModel
