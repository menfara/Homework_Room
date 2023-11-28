package farkhat.myrzabekov.homework_room.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {
    @Query("SELECT * FROM ShoppingListEntity")
    fun getShoppingLists(): Flow<List<ShoppingListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingList: ShoppingListEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItemEntity)

    @Query("SELECT * FROM ShoppingItemEntity WHERE listId = :listId")
    fun getShoppingItems(listId: Long): Flow<List<ShoppingItemEntity>>

    @Update
    suspend fun updateShoppingItemCompletion(item: ShoppingItemEntity)

    @Query("SELECT COUNT(*) FROM ShoppingItemEntity WHERE listId = :listId AND isCompleted = 1")
    fun getCompletedItemCount(listId: Long): Flow<Int>
}
