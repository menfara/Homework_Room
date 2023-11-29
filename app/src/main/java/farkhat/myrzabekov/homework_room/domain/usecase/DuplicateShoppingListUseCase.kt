package farkhat.myrzabekov.homework_room.domain.usecase

interface DuplicateShoppingListUseCase {
    suspend operator fun invoke(listId: Long)
}