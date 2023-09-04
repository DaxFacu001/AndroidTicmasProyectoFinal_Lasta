package com.example.comparadorticmas.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comparadorticmas.model.Compare
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val compare: LiveData<Compare> get() = _comparator

    private var _comparator = MutableLiveData<Compare>(Compare("¿Son iguales?"))


    fun compareText(text1 : String, text2: String){
        val compare = text1 == text2;
        updateResult(compare)
    }

    private fun updateResult(resultCompare: Boolean){
        if(resultCompare){
            viewModelScope.launch {
                _comparator.value = Compare("Son iguales")
            }
        }
        else{
            viewModelScope.launch {
                _comparator.value = Compare("Son diferentes")
            }
        }

    }
}