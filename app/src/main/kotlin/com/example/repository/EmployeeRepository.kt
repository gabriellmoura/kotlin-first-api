package com.example.repository

import com.example.domain.EmployeeEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface EmployeeRepository: CrudRepository<EmployeeEntity, Long> {
}