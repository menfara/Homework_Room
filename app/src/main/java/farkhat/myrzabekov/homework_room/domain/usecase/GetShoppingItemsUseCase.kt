package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import kotlinx.coroutines.flow.Flow

interface GetShoppingItemsUseCase {
    fun execute(listId: Long): Flow<List<ShoppingItemEntity>>
}
