package farkhat.myrzabekov.homework_room.presentation.ui

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import farkhat.myrzabekov.homework_room.databinding.FragmentListsBinding
import farkhat.myrzabekov.homework_room.presentation.adapter.ShoppingListsAdapter
import farkhat.myrzabekov.homework_room.presentation.viewmodel.ShoppingListViewModel
import androidx.navigation.fragment.findNavController
import farkhat.myrzabekov.homework_room.R
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingItemEntity
import farkhat.myrzabekov.homework_room.data.local.entity.ShoppingListEntity

@AndroidEntryPoint
class ListsFragment : Fragment() {
    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingListViewModel by viewModels()
    private lateinit var shoppingListsAdapter: ShoppingListsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeShoppingLists()
        setupAddListButton()
    }

    private fun setupRecyclerView() {
        shoppingListsAdapter = ShoppingListsAdapter(
            onItemClick = { selectedList ->
                navigateToShoppingListDetails(selectedList.id)
            },
            onDuplicateClick = { selectedList ->
                // Handle duplicate action
            },
            onHideClick = { selectedList ->
                // Handle hide action
            },
            getCompletedItemCount = { listId ->
                viewModel.getCompletedItemCount(listId)
            },
            getTotalItemCount = { listId ->
                viewModel.getShoppingItems(listId).map { it.size }
            },
            getItemTitles = { listId ->
                viewModel.getShoppingItems(listId).map { shoppingItems ->
                    val maxTitlesToShow = 3
                    val displayedTitles = shoppingItems.take(maxTitlesToShow).joinToString { it.title }
                    val remainingCount = shoppingItems.size - maxTitlesToShow

                    if (remainingCount > 0) {
                        "$displayedTitles +$remainingCount more"
                    } else {
                        displayedTitles
                    }
                }
            }

        )

        binding.shoppingListsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = shoppingListsAdapter
        }
    }

    private fun observeShoppingLists() {
        // Observe the shopping lists LiveData from the ViewModel
        viewModel.shoppingLists.observe(viewLifecycleOwner) { shoppingLists ->
            shoppingListsAdapter.submitList(shoppingLists)
        }

    }


    private fun setupAddListButton() {
        binding.addItemButton.setOnClickListener {
            showAddListDialog()
        }
    }

    private fun showAddListDialog() {
        // Logic to show the add list dialog
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_custom_add_item, null)
        val editTextListName = dialogView.findViewById<EditText>(R.id.editTextItemName)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogView.findViewById<Button>(R.id.cancelButton).setOnClickListener {
            dialog.dismiss()
        }
        dialogView.findViewById<Button>(R.id.createButton).setOnClickListener {
            val listTitle = editTextListName.text.toString().trim()
            if (listTitle.isNotEmpty()) {
                val newList = ShoppingListEntity(title = listTitle)
                viewModel.addShoppingList(newList)
                dialog.dismiss()
            } else {
                editTextListName.error = "Please enter a name"
            }
        }
        dialog.show()
    }

    private fun navigateToShoppingListDetails(listId: Long) {
        // Navigate to the shopping list details
        val action = ListsFragmentDirections.actionListsFragmentToShoppingListFragment(listId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
