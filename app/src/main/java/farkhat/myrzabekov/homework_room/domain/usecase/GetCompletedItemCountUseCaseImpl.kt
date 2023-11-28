package farkhat.myrzabekov.homework_room.domain.usecase

import farkhat.myrzabekov.homework_room.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCompletedItemCountUseCaseImpl @Inject constructor(private val repository: ShoppingRepository) :
    GetCompletedItemCountUseCase {
    override fun execute(listId: Long): Flow<Int> {
        return repository.getCompletedItemCount(listId)
    }
}
