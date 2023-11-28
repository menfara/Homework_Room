package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.ShoppingDao
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import javax.inject.Inject

class InsertShoppingItemUseCaseImpl @Inject constructor(private val shoppingDao: ShoppingDao) :
    InsertShoppingItemUseCase {
    override suspend fun execute(shoppingItem: ShoppingItemEntity) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }
}