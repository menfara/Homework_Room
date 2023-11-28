package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShoppingItemsUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) : GetShoppingItemsUseCase {
    override fun execute(listId: Long): Flow<List<ShoppingItemEntity>> {
        return repository.getShoppingItems(listId)
    }
}
