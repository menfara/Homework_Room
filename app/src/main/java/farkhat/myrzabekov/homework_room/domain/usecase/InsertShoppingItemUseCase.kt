package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity

interface InsertShoppingItemUseCase {
    suspend fun execute(shoppingItem: ShoppingItemEntity)
}