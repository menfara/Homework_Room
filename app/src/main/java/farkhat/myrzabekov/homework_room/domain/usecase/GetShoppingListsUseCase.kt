package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

// В пакете domain.usecase
interface GetShoppingListsUseCase {
    fun execute(): Flow<List<ShoppingListEntity>>
}
