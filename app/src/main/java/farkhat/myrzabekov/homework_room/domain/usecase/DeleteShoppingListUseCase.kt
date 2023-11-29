package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity

interface DeleteShoppingListUseCase {
    suspend fun execute(shoppingList: ShoppingListEntity)
}