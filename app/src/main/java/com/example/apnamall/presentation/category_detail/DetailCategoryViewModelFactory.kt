package com.example.apnamall.presentation.category_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.*

class DetailCategoryViewModelFactory(
    private val getMaleShirtsUseCase: GetMaleShirtsUseCase,
    private val getMaleTshirtsUseCase: GetMaleTshirtsUseCase,
    private val getMaleShoesUseCase: GetMaleShoesUseCase,
    private val getMalePantsUseCase: GetMalePantsUseCase,
    private val getFemalePartyUseCase: GetFemalePartyUseCase,
    private val getFemaleTraditionalUseCase: GetFemaleTraditionalUseCase,
    private val getFemalePantsUseCase: GetFemalePantsUseCase,
    private val getFemaleShoesUseCase: GetFemaleShoesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailCategoryViewModel(
            getMaleShirtsUseCase,
            getMaleTshirtsUseCase,
            getMaleShoesUseCase,
            getMalePantsUseCase,
            getFemalePartyUseCase,
            getFemaleTraditionalUseCase,
            getFemalePantsUseCase,
            getFemaleShoesUseCase
        ) as T
    }
}