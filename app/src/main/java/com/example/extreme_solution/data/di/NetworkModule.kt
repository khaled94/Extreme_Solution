package com.example.extreme_solution.data.di

import com.example.extreme_solution.data.apiservice.ApiService
import com.example.extreme_solution.data.datasource.LocalDataSource
import com.example.extreme_solution.data.datasource.RemoteDataSource
import com.example.extreme_solution.data.repository.RepositoryImplementer
import com.example.extreme_solution.domain.repository.Repository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class NetworkModule {


    @Provides
    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor;
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS) // write timeout
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
                //.addInterceptor(AuthInterceptor(BuildConfig.API_KEY))
                .build()
    }


    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
    }

    @Provides
    fun provideServiceApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
        ): Repository =
        RepositoryImplementer(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )

   // @Provides
   // fun provideDataStore(@ApplicationContext context: Context): DataStore = DataStore(context)


}