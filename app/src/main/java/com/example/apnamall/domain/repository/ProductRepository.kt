package com.example.apnamall.domain.repository


import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.model.video.Video
import com.example.apnamall.data.util.Resource

interface ProductRepository {
    suspend fun getMaleShirts(): Resource<Product>
    suspend fun getMaleTShirts(): Resource<Product>
    suspend fun getMaleShoes(): Resource<Product>
    suspend fun getMalePants(): Resource<Product>
    suspend fun getFemaleShoes(): Resource<Product>
    suspend fun getFemaleParty(): Resource<Product>
    suspend fun getFemaleTraditional(): Resource<Product>
    suspend fun getFemalePants(): Resource<Product>
    suspend fun getBestSeller():Resource<Product>
    suspend fun getTopDiscount():Resource<Product>
    suspend fun getTopMale():Resource<Product>
    suspend fun getTopFemale():Resource<Product>
    suspend fun getVideo():Resource<Video>
    suspend fun getSliders():Resource<Slider>
}