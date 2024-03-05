package com.alicasts.currencyquotes.domain.use_cases.get_coin_vs_coin_details

import com.alicasts.currencyquotes.common.Resource
import com.alicasts.currencyquotes.data.remote.dto.toCoinVsCoin
import com.alicasts.currencyquotes.domain.model.CoinVsCoin
import com.alicasts.currencyquotes.domain.repository.CoinVsCoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinVsCoinDetailsUseCase @Inject constructor(
    private val repository: CoinVsCoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinVsCoin>> = flow {
        try {
            emit(Resource.Loading())
            val coinVsCoin = repository.getCoinVsCoinById(coinId).toCoinVsCoin()
            emit(Resource.Success(coinVsCoin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server."))
        }
    }

}