package com.template.test.controller

import com.template.domain.test.entity.TestEntity
import com.template.domain.test.repository.TestEntityRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/test")
class TestController(
    private val testEntityRepository: TestEntityRepository
) {
    
    @GetMapping("/connection")
    fun testDatabaseConnection(): Map<String, Any> {
        return try {
            val count = testEntityRepository.count()
            mapOf(
                "status" to "success",
                "message" to "Database connection successful",
                "entityCount" to count,
                "timestamp" to LocalDateTime.now()
            )
        } catch (e: Exception) {
            mapOf(
                "status" to "error",
                "message" to "Database connection failed: ${e.message}",
                "timestamp" to LocalDateTime.now()
            )
        }
    }
    
    @PostMapping("/create")
    fun createTestEntity(@RequestBody request: CreateTestEntityRequest): TestEntity {
        val entity = TestEntity(
            name = request.name,
            description = request.description
        )
        return testEntityRepository.save(entity)
    }
    
    @GetMapping("/list")
    fun getAllTestEntities(): List<TestEntity> {
        return testEntityRepository.findAll()
    }
    
    @GetMapping("/search")
    fun searchByName(@RequestParam name: String): List<TestEntity> {
        return testEntityRepository.findByNameContaining(name)
    }
}

data class CreateTestEntityRequest(
    val name: String,
    val description: String? = null
)