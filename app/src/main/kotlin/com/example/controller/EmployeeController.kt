package com.example.controller

import com.example.domain.EmployeeEntity
import com.example.dto.EmployeeDTO
import com.example.repository.EmployeeRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/employee")
class EmployeeController(val employeeRepository: EmployeeRepository) {

    @Post
    fun save(@Body employee: EmployeeDTO) : HttpResponse<EmployeeEntity> {
        log.info("Saving Employee :{}", employee);
        return HttpResponse.created(employeeRepository.save(employee.toEntity()));
    }

    @Put("/{id}")
    fun update(id: Long, @Body employee: EmployeeDTO): HttpResponse<EmployeeEntity> {
        log.info("Updating Employee :{}", employee);
        val employeeEntity = findById(id);
        if (checkNullableEmployeeEntity(employeeEntity)) return HttpResponse.notFound();
        return HttpResponse.ok(employeeRepository.update(employee.toEntity(id)));
    }

    @Get("/findAll")
    fun getAll(): HttpResponse<Iterable<EmployeeEntity>> {
        log.info("findAll");
        return HttpResponse.ok(employeeRepository.findAll());
    }

    @Get("/{id}")
    fun getById(id: Long): HttpResponse<EmployeeEntity> {
        log.info("Find by id: {}", id);
        val employeeEntity = findById(id);
        if (checkNullableEmployeeEntity(employeeEntity)) return HttpResponse.notFound()
        return HttpResponse.ok(employeeEntity.get());
    }

    @Delete("/{id}")
    fun deleteById(id: Long): HttpResponse<EmployeeEntity> {
        log.info("Delete by id: {}", id);
        val employeeEntity = findById(id);
        if (checkNullableEmployeeEntity(employeeEntity)) return HttpResponse.notFound()
        employeeRepository.delete(employeeEntity.get());
        return HttpResponse.ok();
    }

    private fun checkNullableEmployeeEntity(employeeEntity: Optional<EmployeeEntity>): Boolean {
        return employeeEntity.isEmpty
    }

    private fun findById(id: Long) = employeeRepository.findById(id)

    companion object {
        val log: Logger = LoggerFactory.getLogger(EmployeeController::class.java)
    }
}