package farkhat.myrzabekov.homework_room.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity


@Database(entities = [ShoppingItemEntity::class, ShoppingListEntity::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}
