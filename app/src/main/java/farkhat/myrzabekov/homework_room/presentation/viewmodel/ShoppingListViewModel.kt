package farkhat.myrzabekov.homework_room.presentation.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity
import farkhat.myrzabekov.homework_room.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val addShoppingListUseCase: AddShoppingListUseCase,
    private val getCompletedItemCountUseCase: GetCompletedItemCountUseCase,
    private val getShoppingItemsUseCase: GetShoppingItemsUseCase,
    private val getShoppingListsUseCase: GetShoppingListsUseCase,
    private val insertShoppingItemUseCase: InsertShoppingItemUseCase,
    private val markItemAsCompletedUseCase: MarkItemAsCompletedUseCase,
    private val deleteShoppingListUseCase: DeleteShoppingListUseCase,
    private val duplicateShoppingListUseCase: DuplicateShoppingListUseCase,
) : ViewModel() {

    val shoppingLists: LiveData<List<ShoppingListEntity>> = getShoppingListsUseCase.execute()
        .asLiveData(viewModelScope.coroutineContext)

    private val _shoppingItems = MutableLiveData<Long>()
    val shoppingItems: LiveData<List<ShoppingItemEntity>> = _shoppingItems.switchMap { listId ->
        getShoppingItemsUseCase.execute(listId).asLiveData(viewModelScope.coroutineContext)
    }

    fun loadShoppingItems(listId: Long) {
        _shoppingItems.value = listId
    }

    fun addShoppingList(shoppingList: ShoppingListEntity) {
        viewModelScope.launch {
            addShoppingListUseCase.execute(shoppingList)
        }
    }

    fun getShoppingItems(listId: Long): LiveData<List<ShoppingItemEntity>> {
        return getShoppingItemsUseCase.execute(listId).asLiveData(viewModelScope.coroutineContext)
    }

    fun insertShoppingItem(shoppingItem: ShoppingItemEntity) {
        viewModelScope.launch {
            insertShoppingItemUseCase.execute(shoppingItem)
        }
    }

    fun markItemAsCompleted(item: ShoppingItemEntity) {
        viewModelScope.launch {
            markItemAsCompletedUseCase.execute(item)
        }
    }

    fun getCompletedItemCount(listId: Long): LiveData<Int> {
        return getCompletedItemCountUseCase.execute(listId).asLiveData(viewModelScope.coroutineContext)
    }

    fun deleteShoppingList(shoppingList: ShoppingListEntity) {
        viewModelScope.launch {
            deleteShoppingListUseCase.execute(shoppingList)
        }
    }

    fun duplicateShoppingList(listId: Long) {
        viewModelScope.launch {
            duplicateShoppingListUseCase(listId)
        }
    }

}
