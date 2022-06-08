package com.egor.memes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egor.memes.data.entity.MemeEntity
import com.egor.memes.data.repository.MemesRepository
import com.egor.memes.util.DataResult
import com.egor.memes.util.ProgressStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val memesRepository: MemesRepository) : ViewModel() {

    private val _memeLiveData = MutableLiveData<ProgressStatus<List<MemeEntity>>>()
    val memeLiveData: LiveData<ProgressStatus<List<MemeEntity>>>
        get() = _memeLiveData

    fun fetchMemesList() {
        _memeLiveData.value = ProgressStatus.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = memesRepository.getMemesData()) {
                is DataResult.DataSuccess -> {
                    _memeLiveData.postValue(ProgressStatus.Success(response.data))
                }
                is DataResult.DataError -> {
                    _memeLiveData.postValue(ProgressStatus.Error(response.errorMessage))
                }
            }
        }
    }
}