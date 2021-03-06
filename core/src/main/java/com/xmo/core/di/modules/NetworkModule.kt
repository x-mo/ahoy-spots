package com.xmo.core.di.modules

import com.xmo.core.BuildConfig
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.core.network.services.OCMService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.OCM_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideOCMService(retrofit: Retrofit): OCMService = retrofit.create(OCMService::class.java)

    @Singleton
    @Provides
    fun provideOCMRepository(service: OCMService) = OCMRepository(service)
}
