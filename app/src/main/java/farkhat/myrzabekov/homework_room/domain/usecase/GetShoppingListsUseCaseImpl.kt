package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShoppingListsUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) : GetShoppingListsUseCase {
    override fun execute(): Flow<List<ShoppingListEntity>> {
        return repository.getShoppingLists()
    }
}
