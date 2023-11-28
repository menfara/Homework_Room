package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity

interface AddShoppingListUseCase {
    suspend fun execute(shoppingList: ShoppingListEntity)
}