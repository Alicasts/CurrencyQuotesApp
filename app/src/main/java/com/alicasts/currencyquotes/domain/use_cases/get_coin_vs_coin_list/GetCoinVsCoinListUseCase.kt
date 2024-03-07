package com.alicasts.currencyquotes.domain.use_cases.get_coin_vs_coin_list

import com.alicasts.currencyquotes.common.Resource
import com.alicasts.currencyquotes.data.remote.dto.toCoinVsCoinListItem
import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItemModel
import com.alicasts.currencyquotes.domain.repository.CoinVsCoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinVsCoinListUseCase @Inject constructor(
    private val repository: CoinVsCoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinVsCoinListItemModel>>> = flow {
        try {
            emit(Resource.Loading<List<CoinVsCoinListItemModel>>())
            val coinVsCoinList = repository.getCoinVsCoinList().map { it.toCoinVsCoinListItem() }
            emit(Resource.Success<List<CoinVsCoinListItemModel>>(coinVsCoinList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CoinVsCoinListItemModel>>(e.localizedMessage ?: "An expected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinVsCoinListItemModel>>(e.localizedMessage ?: "Couldn't reach server."))
        }
    }

}