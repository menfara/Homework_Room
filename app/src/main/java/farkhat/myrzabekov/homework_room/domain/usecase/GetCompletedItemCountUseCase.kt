package farkhat.myrzabekov.homework_room.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetCompletedItemCountUseCase {
    fun execute(listId: Long): Flow<Int>
}