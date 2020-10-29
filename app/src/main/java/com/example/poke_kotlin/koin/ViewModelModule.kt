package com.example.poke_kotlin.koin

import com.example.poke_kotlin.presentation.detail.DetailViewModel
import com.example.poke_kotlin.presentation.detail.about.AboutViewModel
import com.example.poke_kotlin.presentation.list.PokeListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PokeListViewModel(
            get()
        )
    }

    viewModel {
        DetailViewModel(
            get()
        )
    }

    viewModel {
        AboutViewModel(
            get()
        )
    }
}