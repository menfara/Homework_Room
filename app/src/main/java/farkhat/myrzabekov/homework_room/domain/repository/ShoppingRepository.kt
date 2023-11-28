package farkhat.myrzabekov.homework_room.domain.repository

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {
    fun getShoppingLists(): Flow<List<ShoppingListEntity>>
    suspend fun insertShoppingList(shoppingList: ShoppingListEntity)
    fun getShoppingItems(listId: Long): Flow<List<ShoppingItemEntity>>
    suspend fun updateShoppingItemCompletion(item: ShoppingItemEntity)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItemEntity)
    fun getCompletedItemCount(listId: Long): Flow<Int>
}
