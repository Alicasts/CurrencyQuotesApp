package com.alicasts.currencyquotes.presentation.coin_vs_coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alicasts.currencyquotes.common.Constants.PARAM_COIN_VS_COIN_ID
import com.alicasts.currencyquotes.common.Resource
import com.alicasts.currencyquotes.domain.use_cases.get_coin_vs_coin_details.GetCoinVsCoinDetailsUseCase
import com.alicasts.currencyquotes.domain.use_cases.get_coin_vs_coin_list.GetCoinVsCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinVsCoinDetailViewModel @Inject constructor(
    private val getCoinVsCoinDetailsUseCase: GetCoinVsCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinVsCoinDetailState())
    val state: State<CoinVsCoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_VS_COIN_ID)?.let {coinVsCoinId ->
            getCoinVsCoin(coinVsCoinId)
        }
    }

    private fun getCoinVsCoin(coinId: String) {
        getCoinVsCoinDetailsUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinVsCoinDetailState(coinVsCoin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinVsCoinDetailState(
                        error = result.message ?:
                        "An unexpected error occurred..")
                }
                is Resource.Loading -> {
                    _state.value = CoinVsCoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}