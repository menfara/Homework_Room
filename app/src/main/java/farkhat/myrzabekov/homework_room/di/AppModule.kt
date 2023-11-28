package farkhat.myrzabekov.homework_room.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import farkhat.myrzabekov.homework_room.data.local.ShoppingDao
import farkhat.myrzabekov.homework_room.data.local.ShoppingDatabase
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import farkhat.myrzabekov.homework_room.data.repository.ShoppingRepositoryImpl
import farkhat.myrzabekov.homework_room.domain.usecase.AddShoppingListUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.AddShoppingListUseCaseImpl
import farkhat.myrzabekov.homework_room.domain.usecase.GetCompletedItemCountUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.GetCompletedItemCountUseCaseImpl
import farkhat.myrzabekov.homework_room.domain.usecase.GetShoppingItemsUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.GetShoppingItemsUseCaseImpl
import farkhat.myrzabekov.homework_room.domain.usecase.GetShoppingListsUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.GetShoppingListsUseCaseImpl
import farkhat.myrzabekov.homework_room.domain.usecase.InsertShoppingItemUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.InsertShoppingItemUseCaseImpl
import farkhat.myrzabekov.homework_room.domain.usecase.MarkItemAsCompletedUseCase
import farkhat.myrzabekov.homework_room.domain.usecase.MarkItemAsCompletedUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoppingRepository(shoppingDao: ShoppingDao): ShoppingRepository {
        return ShoppingRepositoryImpl(shoppingDao)
    }

    @Provides
    @Singleton
    fun provideShoppingDao(@ApplicationContext context: Context): ShoppingDao {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            "shopping_database"
        ).build().shoppingDao()
    }

    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext context: Context): Application {
        return context.applicationContext as Application
    }

    @Provides
    @Singleton
    fun provideAddShoppingListUseCase(shoppingRepository: ShoppingRepository): AddShoppingListUseCase {
        return AddShoppingListUseCaseImpl(shoppingRepository)
    }

    @Provides
    @Singleton
    fun provideGetCompletedItemCountUseCase(shoppingRepository: ShoppingRepository): GetCompletedItemCountUseCase {
        return GetCompletedItemCountUseCaseImpl(shoppingRepository)
    }

    @Provides
    @Singleton
    fun provideGetShoppingItemsUseCase(shoppingRepository: ShoppingRepository): GetShoppingItemsUseCase {
        return GetShoppingItemsUseCaseImpl(shoppingRepository)
    }

    @Provides
    @Singleton
    fun provideGetShoppingListsUseCase(shoppingRepository: ShoppingRepository): GetShoppingListsUseCase {
        return GetShoppingListsUseCaseImpl(shoppingRepository)
    }

    @Provides
    @Singleton
    fun provideInsertShoppingItemUseCase(shoppingDao: ShoppingDao): InsertShoppingItemUseCase {
        return InsertShoppingItemUseCaseImpl(shoppingDao)
    }

    @Provides
    @Singleton
    fun provideMarkItemAsCompletedUseCase(shoppingRepository: ShoppingRepository): MarkItemAsCompletedUseCase {
        return MarkItemAsCompletedUseCaseImpl(shoppingRepository)
    }
}