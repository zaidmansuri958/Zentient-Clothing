package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.db.LikeDao
import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.repository.datasource.LikeLocalDataSource
import kotlinx.coroutines.flow.Flow

class LikeLocalDataSourceImpl(private val likeDao: LikeDao) : LikeLocalDataSource {
    override fun getLike(): Flow<List<LikeRequest>> {
        return likeDao.getLikes()
    }

    override suspend fun insertLike(product: LikeRequest) {
        likeDao.insertLike(product)
    }

    override suspend fun likedOrNot(productId: String): Boolean {
        return likeDao.likedOrNot(productId)
    }

    override suspend fun removeLike(productId: String) {
        likeDao.removeLike(productId)
    }


}