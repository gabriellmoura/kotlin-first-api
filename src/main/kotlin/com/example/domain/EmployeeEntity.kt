package com.example.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity(name="profile")
data class EmployeeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,
    @Column
    var name: String? = null,
    @Column
    var  age: Int? = null,
    @Column
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    var  admitionDate: Date? = null,
    @Column
    var  gender: String? = null)