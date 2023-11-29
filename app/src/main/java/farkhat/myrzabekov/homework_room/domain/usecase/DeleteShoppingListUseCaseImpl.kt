package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import javax.inject.Inject

class DeleteShoppingListUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) : DeleteShoppingListUseCase {
    override suspend fun execute(shoppingList: ShoppingListEntity) {
        repository.deleteShoppingList(shoppingList)
    }
}