package com.example.apnamall.data.repository

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.repository.datasource.LikeLocalDataSource
import com.example.apnamall.domain.repository.LikeRepository
import kotlinx.coroutines.flow.Flow

class LikeRepositoryImpl(private val likeLocalDataSource: LikeLocalDataSource) : LikeRepository {
    override fun getLike(): Flow<List<LikeRequest>> {
        return likeLocalDataSource.getLike()
    }


    override suspend fun like(product: LikeRequest) {
        likeLocalDataSource.insertLike(product)
    }

    override suspend fun likedOrNot(productId: String): Boolean {
        return likeLocalDataSource.likedOrNot(productId)
    }

    override suspend fun removeLike(productId: String) {
        likeLocalDataSource.removeLike(productId)
    }


//    private fun responseToResourceOrderResponseItem(response: Response<LikeResponseItem>): Resource<LikeResponseItem> {
//        if (response.isSuccessful) {
//            response.body()?.let { result ->
//                return Resource.Success(result)
//            }
//        } else if (response.errorBody() != null) {
//            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
//            return Resource.Error(errorObj.getString("message"))
//        }
//        return Resource.Error("Something went wronggg")
//    }
//
//    private fun responseToResource(response: Response<LikeResponse>): Resource<LikeResponse> {
//        if (response.isSuccessful) {
//            response.body()?.let { result ->
//                return Resource.Success(result)
//            }
//        } else if (response.errorBody() != null) {
//            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
//            return Resource.Error(errorObj.getString("message"))
//        }
//        return Resource.Error("Something went wrong")
//    }
}