package farkhat.myrzabekov.homework_room.data.repository

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import farkhat.myrzabekov.homework_room.data.local.ShoppingDao
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShoppingRepositoryImpl @Inject constructor(private val shoppingDao: ShoppingDao) : ShoppingRepository {
    override fun getShoppingLists(): Flow<List<ShoppingListEntity>> =
        shoppingDao.getShoppingLists()

    override suspend fun insertShoppingList(shoppingList: ShoppingListEntity) {
        shoppingDao.insertShoppingList(shoppingList)
    }

    override fun getShoppingItems(listId: Long): Flow<List<ShoppingItemEntity>> =
        shoppingDao.getShoppingItems(listId)

    override suspend fun updateShoppingItemCompletion(item: ShoppingItemEntity) {
        shoppingDao.updateShoppingItemCompletion(item)
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItemEntity) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override fun getCompletedItemCount(listId: Long): Flow<Int> =
        shoppingDao.getCompletedItemCount(listId)
}
