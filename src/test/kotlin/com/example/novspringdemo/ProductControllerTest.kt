package com.example.novspringdemo

import io.kotest.core.spec.style.FunSpec
import io.mockk.mockk

class ProductControllerTest : FunSpec({

    val productRepository = mockk<ProductRepository>()
    val productController = ProductController(productRepository )

    test("get products") {


    }

})