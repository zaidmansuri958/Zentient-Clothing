package com.example.apnamall.data.repository.datasource


import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.model.video.Video
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getMaleShirts(): Response<Product>
    suspend fun getMaleTShirts(): Response<Product>
    suspend fun getMaleShoes(): Response<Product>
    suspend fun getMalePants(): Response<Product>
    suspend fun getFemaleShoes(): Response<Product>
    suspend fun getFemaleParty(): Response<Product>
    suspend fun getFemaleTraditional(): Response<Product>
    suspend fun getFemalePants(): Response<Product>
    suspend fun getBestSeller(): Response<Product>
    suspend fun getTopDiscount(): Response<Product>
    suspend fun getTopMale(): Response<Product>
    suspend fun getTopFemale(): Response<Product>
    suspend fun getSliders(): Response<Slider>
    suspend fun getVideo(): Response<Video>
}