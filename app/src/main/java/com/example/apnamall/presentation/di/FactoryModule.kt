package com.example.apnamall.presentation.di

import com.example.apnamall.domain.use_case.*
import com.example.apnamall.presentation.bottom_sheet.BottomSheetViewModelFactory
import com.example.apnamall.presentation.cart.CartViewModelFactory
import com.example.apnamall.presentation.cart_item.CartItemViewModelFactory
import com.example.apnamall.presentation.category.CategoryViewModelFactory
import com.example.apnamall.presentation.category_detail.DetailCategoryViewModelFactory
import com.example.apnamall.presentation.home.HomeViewModelFactory
import com.example.apnamall.presentation.like.LikeViewModelFactory
import com.example.apnamall.presentation.product_detail.ProductDetailViewModelFactory
import com.example.apnamall.presentation.profile.ProfileFragmentViewModelFactory
import com.example.apnamall.presentation.signin.SignInViewModelFactory
import com.example.apnamall.presentation.signup.SignUpViewModelFactory
import com.example.apnamall.presentation.video.VideoViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Provides
    @Singleton
    fun provideHomeViewModelFactory(
        getBestSellersUseCase: GetBestSellersUseCase,
        getTopDiscountUseCase: GetTopDiscountUseCase,
        getTopMaleUseCase: GetTopMaleUseCase,
        getTopFemaleUseCase: GetTopFemaleUseCase,
        getSliderUseCase: GetSliderUseCase,

        ): HomeViewModelFactory {
        return HomeViewModelFactory(

            getBestSellersUseCase,
            getTopDiscountUseCase,
            getTopMaleUseCase,
            getTopFemaleUseCase,
            getSliderUseCase,

            )
    }

    @Provides
    @Singleton
    fun provideCategoryViewModelFactory(
        getCategoryUseCase: GetCategoryUseCase
    ): CategoryViewModelFactory {
        return CategoryViewModelFactory(getCategoryUseCase)
    }

    @Provides
    @Singleton
    fun provideCategoryDetailViewModelFactory(
        getMaleShirtsUseCase: GetMaleShirtsUseCase,
        getMaleTshirtsUseCase: GetMaleTshirtsUseCase,
        getMaleShoesUseCase: GetMaleShoesUseCase,
        getMalePantsUseCase: GetMalePantsUseCase,
        getFemalePartyUseCase: GetFemalePartyUseCase,
        getFemaleTraditionalUseCase: GetFemaleTraditionalUseCase,
        getFemalePantsUseCase: GetFemalePantsUseCase,
        getFemaleShoesUseCase: GetFemaleShoesUseCase
    ): DetailCategoryViewModelFactory {
        return DetailCategoryViewModelFactory(
            getMaleShirtsUseCase,
            getMaleTshirtsUseCase,
            getMaleShoesUseCase,
            getMalePantsUseCase,
            getFemalePartyUseCase,
            getFemaleTraditionalUseCase,
            getFemalePantsUseCase,
            getFemaleShoesUseCase
        )
    }

    @Provides
    @Singleton
    fun provideSignUpViewModelFactory(userSignUpUseCase: UserSignUpUseCase): SignUpViewModelFactory {
        return SignUpViewModelFactory(userSignUpUseCase)
    }

    @Provides
    @Singleton
    fun provideSignInViewModelFactory(userSignInUseCase: UserSignInUseCase): SignInViewModelFactory {
        return SignInViewModelFactory(userSignInUseCase)
    }

    @Provides
    @Singleton
    fun provideProductDetailViewModelFactory(
        submitOrderUseCase: AddToCartUseCase,
        submitLikeUseCase: SubmitLikeUseCase
    ): ProductDetailViewModelFactory {
        return ProductDetailViewModelFactory(submitOrderUseCase, submitLikeUseCase)
    }

    @Provides
    @Singleton
    fun provideCartViewModelFactory(getOrderUseCase: GetCartUseCase): CartViewModelFactory {
        return CartViewModelFactory(getOrderUseCase)
    }

    @Provides
    @Singleton
    fun provideProfileViewModelFactory(getUserDetailUseCase: GetUserDetailUseCase): ProfileFragmentViewModelFactory {
        return ProfileFragmentViewModelFactory(getUserDetailUseCase)
    }

    @Provides
    @Singleton
    fun provideCartItemViewModelFactory(deleteOrderUseCase: DeleteCartItemUseCase): CartItemViewModelFactory {
        return CartItemViewModelFactory(deleteOrderUseCase)
    }

    @Provides
    @Singleton
    fun provideVideoViewModelFactory(getVideoUseCase: GetVideoUseCase): VideoViewModelFactory {
        return VideoViewModelFactory(getVideoUseCase)
    }

    @Provides
    @Singleton
    fun provideLikeViewModelFactory(getLikeUseCase: GetLikeUseCase): LikeViewModelFactory {
        return LikeViewModelFactory(getLikeUseCase)
    }

    @Provides
    @Singleton
    fun provideBottomSheetViewModelFactory(submitOrderUseCase: SubmitOrderUseCase): BottomSheetViewModelFactory {
        return BottomSheetViewModelFactory(submitOrderUseCase)
    }


}