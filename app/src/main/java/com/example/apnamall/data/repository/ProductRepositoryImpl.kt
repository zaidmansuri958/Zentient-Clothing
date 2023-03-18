package com.example.apnamall.data.repository

import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.model.video.Video
import com.example.apnamall.data.repository.datasource.ProductRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.ProductRepository
import retrofit2.Response

class ProductRepositoryImpl(private val productRemoteDataSource: ProductRemoteDataSource) :
    ProductRepository {
    override suspend fun getMaleShirts(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getMaleShirts())
    }

    override suspend fun getMaleTShirts(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getMaleTShirts())
    }

    override suspend fun getMaleShoes(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getMaleShoes())
    }

    override suspend fun getMalePants(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getMalePants())
    }

    override suspend fun getFemaleShoes(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getFemaleShoes())
    }

    override suspend fun getFemaleParty(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getFemaleParty())
    }

    override suspend fun getFemaleTraditional(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getFemaleTraditional())
    }

    override suspend fun getFemalePants(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getFemalePants())
    }

    override suspend fun getBestSeller(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getBestSeller())
    }

    override suspend fun getTopDiscount(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getTopDiscount())
    }

    override suspend fun getTopMale(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getTopMale())
    }

    override suspend fun getTopFemale(): Resource<Product> {
        return responseToResource(productRemoteDataSource.getTopFemale())
    }

    override suspend fun getSliders(): Resource<Slider> {
        return responseToResourceSlider(productRemoteDataSource.getSliders())
    }

    override suspend fun getVideo(): Resource<Video> {
        return responseToResourceVideo(productRemoteDataSource.getVideo())
    }


    private fun responseToResource(response: Response<Product>): Resource<Product> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourceVideo(response: Response<Video>): Resource<Video> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
    private fun responseToResourceSlider(response: Response<Slider>): Resource<Slider> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}