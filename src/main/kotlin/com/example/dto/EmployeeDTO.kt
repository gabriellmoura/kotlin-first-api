package com.example.dto

import com.example.domain.EmployeeEntity
import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class EmployeeDTO(@NotBlank(message = "name can't be null")
                  var name: String,
                  @NotNull(message = "age can't be null")
                  var age: Int,
                  @NotNull(message = "admitionDate can't be null")
                  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
                  var admitionDate: Date,
                  @NotBlank(message = "gender can't be nil")
                  var gender: String
) {
    fun toEntity(): EmployeeEntity {
        val entity = EmployeeEntity();
        entity.name = name;
        entity.age = age;
        entity.admitionDate = admitionDate;
        entity.gender = gender;
        return entity;
    }
    fun toEntity(id: Long): EmployeeEntity {
        var entity = toEntity();
        entity.id = id;
        return entity;
    }
};
