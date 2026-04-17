package com.mexiti.cronoapp.di

import android.content.Context
import androidx.room.Room
import com.mexiti.cronoapp.room.CronosDataBase
import com.mexiti.cronoapp.room.CronosDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesCronosDao(cronosDataBase: CronosDataBase): CronosDataBaseDao {
        return cronosDataBase.cronosDao()
    }

    @Singleton
    @Provides
    fun providesCronosDataBase(@ApplicationContext context: Context): CronosDataBase {
        return Room.databaseBuilder(
            context = context,
            CronosDataBase::class.java,
            name = "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}