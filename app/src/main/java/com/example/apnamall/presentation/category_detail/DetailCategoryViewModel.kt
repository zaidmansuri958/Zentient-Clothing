package com.example.apnamall.presentation.category_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailCategoryViewModel(
    private val getMaleShirtsUseCase: GetMaleShirtsUseCase,
    private val getMaleTshirtsUseCase: GetMaleTshirtsUseCase,
    private val getMaleShoesUseCase: GetMaleShoesUseCase,
    private val getMalePantsUseCase: GetMalePantsUseCase,
    private val getFemalePartyUseCase: GetFemalePartyUseCase,
    private val getFemaleTraditionalUseCase: GetFemaleTraditionalUseCase,
    private val getFemalePantsUseCase: GetFemalePantsUseCase,
    private val getFemaleShoesUseCase: GetFemaleShoesUseCase,

) : ViewModel() {
    val maleShirts: MutableLiveData<Resource<Product>> = MutableLiveData()
    val maleTShirts: MutableLiveData<Resource<Product>> = MutableLiveData()
    val malePants: MutableLiveData<Resource<Product>> = MutableLiveData()
    val maleShoes: MutableLiveData<Resource<Product>> = MutableLiveData()
    val femaleShoes: MutableLiveData<Resource<Product>> = MutableLiveData()
    val femalePants: MutableLiveData<Resource<Product>> = MutableLiveData()
    val femaleTraditionals: MutableLiveData<Resource<Product>> = MutableLiveData()
    val femaleParty: MutableLiveData<Resource<Product>> = MutableLiveData()


    fun getMaleShirts() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getMaleShirtsUseCase.execute()
        maleShirts.postValue(apiResult)
    }


    fun getMalePants() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getMalePantsUseCase.execute()
        malePants.postValue(apiResult)
    }


    fun getMaleShoes() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getMaleShoesUseCase.execute()
        maleShoes.postValue(apiResult)
    }


    fun getMaleTShirts() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getMaleTshirtsUseCase.execute()
        maleTShirts.postValue(apiResult)
    }


    fun getFemalePants() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getFemalePantsUseCase.execute()
        femalePants.postValue(apiResult)
    }


    fun getFemaleParty() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getFemalePartyUseCase.execute()
        femaleParty.postValue(apiResult)
    }


    fun getFemaleTraditional() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getFemaleTraditionalUseCase.execute()
        femaleTraditionals.postValue(apiResult)
    }

    fun getFemaleShoes() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getFemaleShoesUseCase.execute()
        femaleShoes.postValue(apiResult)
    }
}