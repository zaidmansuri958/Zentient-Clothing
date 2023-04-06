package com.example.apnamall.presentation.di

import androidx.room.Index
import com.example.apnamall.domain.repository.*
import com.example.apnamall.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetMalePantsUseCase(productRepository: ProductRepository): GetMalePantsUseCase {
        return GetMalePantsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetMaleShirtsUseCase(productRepository: ProductRepository): GetMaleShirtsUseCase {
        return GetMaleShirtsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetMaleShoesUseCase(productRepository: ProductRepository): GetMaleShoesUseCase {
        return GetMaleShoesUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetMaleTshirtsUseCase(productRepository: ProductRepository): GetMaleTshirtsUseCase {
        return GetMaleTshirtsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetFemalePantsUseCase(productRepository: ProductRepository): GetFemalePantsUseCase {
        return GetFemalePantsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetFemaleShoesUseCase(productRepository: ProductRepository): GetFemaleShoesUseCase {
        return GetFemaleShoesUseCase(productRepository)
    }


    @Provides
    @Singleton
    fun provideGetFemaleTraditionalUseCase(productRepository: ProductRepository): GetFemaleTraditionalUseCase {
        return GetFemaleTraditionalUseCase(productRepository)
    }


    @Provides
    @Singleton
    fun provideGetFemalePartyUseCase(productRepository: ProductRepository): GetFemalePartyUseCase {
        return GetFemalePartyUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetTopFemaleUseCase(productRepository: ProductRepository): GetTopFemaleUseCase {
        return GetTopFemaleUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetTopMaleUseCase(productRepository: ProductRepository): GetTopMaleUseCase {
        return GetTopMaleUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetTopDiscountUseCase(productRepository: ProductRepository): GetTopDiscountUseCase {
        return GetTopDiscountUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetBestSellerUseCase(productRepository: ProductRepository): GetBestSellersUseCase {
        return GetBestSellersUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideSliderUseCase(productRepository: ProductRepository): GetSliderUseCase {
        return GetSliderUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideCategoryUseCase(categoryRepository: CategoryRepository): GetCategoryUseCase {
        return GetCategoryUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideUserSignUpUseCase(userRepository: UserRepository): UserSignUpUseCase {
        return UserSignUpUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideUserInUpUseCase(userRepository: UserRepository): UserSignInUseCase {
        return UserSignInUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetCartUseCase(cartRepository: CartRepository): GetCartUseCase {
        return GetCartUseCase(cartRepository)
    }

    @Provides
    @Singleton
    fun provideAddToCartUseCase(cartRepository: CartRepository): AddToCartUseCase {
        return AddToCartUseCase(cartRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteCartItemUseCase(cartRepository: CartRepository): DeleteCartItemUseCase {
        return DeleteCartItemUseCase(cartRepository)
    }

    @Provides
    @Singleton
    fun provideVideoUseCase(productRepository: ProductRepository): GetVideoUseCase {
        return GetVideoUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserUseCase(cartRepository: CartRepository): GetUserDetailUseCase {
        return GetUserDetailUseCase(cartRepository)
    }

    @Provides
    @Singleton
    fun provideSubmitOrderUseCase(orderRepository: OrderRepository): SubmitOrderUseCase {
        return SubmitOrderUseCase(orderRepository)
    }

    @Provides
    @Singleton
    fun provideGetOrderUseCase(orderRepository: OrderRepository): GetOrderUseCase {
        return GetOrderUseCase(orderRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteOrderUseCase(orderRepository: OrderRepository): DeleteOrderUseCase {
        return DeleteOrderUseCase(orderRepository)
    }

    @Provides
    @Singleton
    fun provideGetLikeUseCase(likeRepository: LikeRepository): GetLikeUseCase {
        return GetLikeUseCase(likeRepository)
    }

    @Provides
    @Singleton
    fun provideSubmitLikeUseCase(likeRepository: LikeRepository): SubmitLikeUseCase {
        return SubmitLikeUseCase(likeRepository)
    }

    @Provides
    @Singleton
    fun provideLikedOrNotUseCase(likeRepository: LikeRepository): LikedOrNotUseCase {
        return LikedOrNotUseCase(likeRepository)
    }

    @Provides
    @Singleton
    fun provideRemoveLikeUseCase(likeRepository: LikeRepository):RemoveLikeUseCase{
        return RemoveLikeUseCase(likeRepository)
    }



}