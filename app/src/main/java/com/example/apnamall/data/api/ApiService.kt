package com.example.apnamall.data.api

import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.model.video.Video
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/maleShirts")
    suspend fun getMaleShirts(): Response<Product>

    @GET("/maleTshirts")
    suspend fun getMaleTShirts(): Response<Product>

    @GET("/maleShoes")
    suspend fun getMaleShoes(): Response<Product>

    @GET("/malePants")
    suspend fun getMalePants(): Response<Product>

    @GET("/femalePants")
    suspend fun getFemalePants(): Response<Product>

    @GET("/femaleParty")
    suspend fun getFemaleParty(): Response<Product>

    @GET("/femaleTraditional")
    suspend fun getFemaleTraditional(): Response<Product>

    @GET("/femaleShoes")
    suspend fun getFemaleShoes(): Response<Product>

    @GET("/bestSeller")
    suspend fun getBestSeller(): Response<Product>

    @GET("/topDiscount")
    suspend fun getTopDiscount(): Response<Product>

    @GET("/maleTop")
    suspend fun getTopMale(): Response<Product>

    @GET("/femaleTop")
    suspend fun getTopFemale(): Response<Product>

    @GET("/sliders")
    suspend fun getSliders(): Response<Slider>

    @GET("/categories")
    suspend fun getCategories(): Response<Category>

    @GET("/video")
    suspend fun getVideos(): Response<Video>

    @POST("/user/signUp")
    suspend fun singUp(@Body userRequest: UserRequest): Response<UserResponse>


    @POST("/user/signIn")
    suspend fun singIn(@Body loginRequest: LoginRequest): Response<UserResponse>

}