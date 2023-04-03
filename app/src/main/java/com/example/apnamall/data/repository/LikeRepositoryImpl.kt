package com.example.apnamall.data.repository

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.repository.datasource.LikeRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository
import org.json.JSONObject
import retrofit2.Response

class LikeRepositoryImpl(private val likeRemoteDataSource: LikeRemoteDataSource) : LikeRepository {
    override suspend fun getLike(): Resource<LikeResponse> {
        return responseToResource(likeRemoteDataSource.getLike())
    }

    override suspend fun like(product: LikeRequest): Resource<LikeResponseItem> {
        return responseToResourceOrderResponseItem(likeRemoteDataSource.like(product))
    }

    override suspend fun deleteLike(likeId: String): Resource<LikeResponseItem> {
        return responseToResourceOrderResponseItem(likeRemoteDataSource.deleteLike(likeId))
    }

    private fun responseToResourceOrderResponseItem(response: Response<LikeResponseItem>): Resource<LikeResponseItem> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            return Resource.Error(errorObj.getString("message"))
        }
        return Resource.Error("Something went wronggg")
    }

    private fun responseToResource(response: Response<LikeResponse>): Resource<LikeResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            return Resource.Error(errorObj.getString("message"))
        }
        return Resource.Error("Something went wrong")
    }
}