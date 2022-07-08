package com.example.fiftymsecondhmloveapp.di

import android.content.Context
import androidx.room.Room
import com.example.fiftymsecondhmloveapp.App
import com.example.fiftymsecondhmloveapp.Prefs
import com.example.fiftymsecondhmloveapp.network.LoveApi
import com.example.fiftymsecondhmloveapp.room.AppDataBase
import com.example.fiftymsecondhmloveapp.room.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePrefs(): Prefs{
        return Prefs()
    }

}