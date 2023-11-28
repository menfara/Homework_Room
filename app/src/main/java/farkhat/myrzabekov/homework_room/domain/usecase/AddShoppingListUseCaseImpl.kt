package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import javax.inject.Inject

class AddShoppingListUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) : AddShoppingListUseCase {
    override suspend fun execute(shoppingList: ShoppingListEntity) {
        repository.insertShoppingList(shoppingList)
    }
}