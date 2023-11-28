package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import javax.inject.Inject

class MarkItemAsCompletedUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) :
    MarkItemAsCompletedUseCase {
    override suspend fun execute(item: ShoppingItemEntity) {
        repository.updateShoppingItemCompletion(item)
    }
}
