package com.mexiti.cronoapp.repository

import com.mexiti.cronoapp.model.Cronos
import com.mexiti.cronoapp.room.CronosDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronosRepository@Inject constructor(private val cronoDataBaseDao: CronosDataBaseDao) {
    suspend fun addCrono(crono: Cronos) = cronoDataBaseDao.insert(crono)

    suspend fun updateCrono(crono: Cronos) = cronoDataBaseDao.update(crono)

    suspend fun deleteCrono(crono: Cronos) = cronoDataBaseDao.delete(crono)

    fun getAllcronos(): Flow<List<Cronos>> = cronoDataBaseDao
        .getCronos()
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getCronById(id: Long): Flow<Cronos> = cronoDataBaseDao
        .getCronosById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}