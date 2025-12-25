package com.template.domain.test.repository

import com.template.domain.test.entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestEntityRepository : JpaRepository<TestEntity, Long> {
    fun findByName(name: String): TestEntity?
    fun findByNameContaining(name: String): List<TestEntity>
}