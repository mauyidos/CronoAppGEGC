package com.mexiti.cronoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.cronoapp.model.Cronos
import com.mexiti.cronoapp.repository.CronosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class DataViewModel @Inject constructor(
    private val repository: CronosRepository
): ViewModel() {
    private val _cronosList = MutableStateFlow<List<Cronos>>(emptyList())
    val cronolist = _cronosList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllcronos().collect() {
                item ->
                if(item.isNullOrEmpty()) {
                    _cronosList.value = emptyList()
                } else {
                    _cronosList.value = item
                }
            }
        }
    }

    fun addCrono(crono: Cronos) = viewModelScope.launch {repository.addCrono(crono)}
    fun updateCrono(crono: Cronos) = viewModelScope.launch {repository.updateCrono(crono)}
    fun deleteCrono(crono: Cronos) = viewModelScope.launch {repository.deleteCrono(crono)}
}