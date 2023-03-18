package com.example.apnamall.presentation.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetCategoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val getCategoryUseCase: GetCategoryUseCase) : ViewModel() {
    val categoryList: MutableLiveData<Resource<Category>> = MutableLiveData()

    fun getCategory() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getCategoryUseCase.execute()
        categoryList.postValue(apiResult)
    }

}