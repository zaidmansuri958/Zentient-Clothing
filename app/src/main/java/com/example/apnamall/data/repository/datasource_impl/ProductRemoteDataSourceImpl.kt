package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.model.video.Video
import com.example.apnamall.data.repository.datasource.ProductRemoteDataSource
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val apiService: ApiService) : ProductRemoteDataSource {
    override suspend fun getMaleShirts(): Response<Product> {
        return apiService.getMaleShirts()
    }

    override suspend fun getMaleTShirts(): Response<Product> {
        return apiService.getMaleTShirts()
    }

    override suspend fun getMaleShoes(): Response<Product> {
        return apiService.getMaleShoes()
    }

    override suspend fun getMalePants(): Response<Product> {
        return apiService.getMalePants()
    }

    override suspend fun getFemaleShoes(): Response<Product> {
        return apiService.getFemaleShoes()
    }

    override suspend fun getFemaleParty(): Response<Product> {
        return apiService.getFemaleParty()
    }

    override suspend fun getFemaleTraditional(): Response<Product> {
        return apiService.getFemaleTraditional()
    }

    override suspend fun getFemalePants(): Response<Product> {
        return apiService.getFemalePants()
    }

    override suspend fun getBestSeller(): Response<Product> {
        return apiService.getBestSeller()
    }

    override suspend fun getTopDiscount(): Response<Product> {
        return apiService.getTopDiscount()
    }

    override suspend fun getTopMale(): Response<Product> {
        return apiService.getTopMale()
    }

    override suspend fun getTopFemale(): Response<Product> {
        return apiService.getTopFemale()
    }

    override suspend fun getSliders():Response<Slider> {
        return apiService.getSliders()
    }

    override suspend fun getVideo(): Response<Video> {
        return apiService.getVideos()
    }

}