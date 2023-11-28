package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity

interface MarkItemAsCompletedUseCase {
    suspend fun execute(item: ShoppingItemEntity)
}