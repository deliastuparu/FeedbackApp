package com.pub.feedbackapp.di

import android.app.Application
import androidx.room.Room
import com.pub.feedbackapp.network.MainApi
import com.pub.feedbackapp.persistance.AppDatabase
import com.pub.feedbackapp.persistance.dao.FeedbackDao
import com.pub.feedbackapp.persistance.dao.UserDao
import com.pub.feedbackapp.repositories.AuthRepository
import com.pub.feedbackapp.repositories.AuthRepositoryImpl
import com.pub.feedbackapp.repositories.MainRepository
import com.pub.feedbackapp.repositories.MainRepositoryImpl
import com.pub.feedbackapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    //region Apis

    @Singleton
    @Provides
    fun providesMainApi(
        retrofit: Retrofit.Builder
    ): MainApi {
        return retrofit
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MainApi::class.java)
    }

    //endregion

    //region Database

    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao

    @Singleton
    @Provides
    fun provideFeedbackDao(db: AppDatabase): FeedbackDao = db.feedbackDao

    //endregion

    //region Repositories

    @Singleton
    @Provides
    fun provideAuthRepository(
        mainApi: MainApi,
        userDao: UserDao
    ): AuthRepository {
        return AuthRepositoryImpl(
            mainApi = mainApi,
            userDao = userDao
        )
    }

    @Singleton
    @Provides
    fun provideMainRepository(userDao: UserDao): MainRepository {
        return MainRepositoryImpl(
            userDao = userDao
        )
    }


    //endregion
}