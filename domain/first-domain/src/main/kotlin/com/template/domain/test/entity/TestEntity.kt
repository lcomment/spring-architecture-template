package com.template.domain.test.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "test_entity")
data class TestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    
    @Column(name = "name", nullable = false)
    val name: String,
    
    @Column(name = "description")
    val description: String? = null,
    
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)