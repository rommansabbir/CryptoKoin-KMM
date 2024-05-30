package com.codefylabs.www.spider.home

import com.codefylabs.www.spider.home.data.local.HomePersistanceImpl
import com.codefylabs.www.spider.home.data.local.HomePersistence
import com.codefylabs.www.spider.home.data.remote.api.HomeApi
import com.codefylabs.www.spider.home.data.remote.api.HomeApiImpl
import com.codefylabs.www.spider.home.data.repo.HomeRepositoryImpl
import com.codefylabs.www.spider.home.domain.repo.HomeRepository
import com.codefylabs.www.spider.home.domain.usecases.CoinDetailUseCase
import com.codefylabs.www.spider.home.domain.usecases.CoinDetailUseCaseImpl
import com.codefylabs.www.spider.home.domain.usecases.CoinsUseCase
import com.codefylabs.www.spider.home.domain.usecases.CoinsUseCaseImpl
import com.codefylabs.www.spider.home.domain.usecases.MarketDataUseCase
import com.codefylabs.www.spider.home.domain.usecases.MarketDataUseCaseImpl
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module


val homeModule = module {

    single<HomeApi> {
        HomeApiImpl(get())
    }

    single<HomeRepository> {
        HomeRepositoryImpl(
            get(),
            get(),
            get()
        )
    }

    single<HomePersistence> {
        HomePersistanceImpl(
            Realm.open(
                RealmConfiguration.Builder(
                    schema = setOf()
                ).build()
            )
        )
    }

    single<CoinDetailUseCase> {
        CoinDetailUseCaseImpl(get())
    }

    single<MarketDataUseCase> {
        MarketDataUseCaseImpl(get())
    }

    single<CoinsUseCase> {
        CoinsUseCaseImpl(get())
    }

}