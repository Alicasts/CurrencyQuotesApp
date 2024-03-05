package com.alicasts.currencyquotes.presentation.coin_vs_coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alicasts.currencyquotes.common.Resource
import com.alicasts.currencyquotes.domain.use_cases.get_coin_vs_coin_list.GetCoinVsCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinVsCoinListViewModel @Inject constructor(
    private val getCoinVsCoinListUseCase: GetCoinVsCoinListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinVsCoinListState())
    val state: State<CoinVsCoinListState> = _state

    init {
        getCoinVsCoinList()
    }

    private fun getCoinVsCoinList() {
        getCoinVsCoinListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinVsCoinListState(coinVsCoinList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinVsCoinListState(
                        error = result.message ?:
                        "An unexpected error occurred..")
                }
                is Resource.Loading -> {
                    _state.value = CoinVsCoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}