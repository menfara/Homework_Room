package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import javax.inject.Inject

class DuplicateShoppingListUseCaseImpl @Inject constructor(private val shoppingRepository: ShoppingRepository) :
    DuplicateShoppingListUseCase {

    override suspend fun invoke(listId: Long) {
        shoppingRepository.duplicateShoppingList(listId)
    }
}