package com.example.novspringdemo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@SpringBootApplication
class NovSpringDemoApplication

fun main(args: Array<String>) {
    runApplication<NovSpringDemoApplication>(*args)
}

@Entity
class Product(@Id @GeneratedValue var id: Long? = null, val description: String)

interface ProductRepository : JpaRepository<Product,Long>


@RestController
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok().body(productRepository.findAll())
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.ok().body(productRepository.save(product))
    }
}