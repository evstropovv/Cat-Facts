package com.catfacts.presentation.main

import androidx.lifecycle.viewModelScope
import com.catfacts.domain.model.CatFactDomainModel
import com.catfacts.domain.usecase.GetCatFactsUseCase
import com.catfacts.library_base.presentation.viewmodel.BaseAction
import com.catfacts.library_base.presentation.viewmodel.BaseViewModel
import com.catfacts.library_base.presentation.viewmodel.BaseViewState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCatFactsUseCase: GetCatFactsUseCase
) : BaseViewModel<MainViewModel.ViewState, MainViewModel.Action>(ViewState()) {


    override fun onLoadData() {
        loadNextFact()
    }

    fun loadNextFact() {
        viewModelScope.launch {
            getCatFactsUseCase.execute().also {
                sendAction(Action.CatFactLoadSuccess(it))
            }
        }
    }

    override fun onReduceState(viewAction: Action): ViewState = when (viewAction) {
        is Action.CatFactLoadSuccess -> state.copy(
            isLoading = false,
            isError = false,
            catFact = viewAction.catFactModel
        )
        is Action.CatFactLoadFailure -> state.copy(
            isLoading = false,
            isError = true,
            catFact = CatFactDomainModel()
        )
    }


    data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val catFact: CatFactDomainModel = CatFactDomainModel()
    ) : BaseViewState

    sealed class Action : BaseAction {
        class CatFactLoadSuccess(val catFactModel: CatFactDomainModel) : Action()
        object CatFactLoadFailure : Action()
    }

}