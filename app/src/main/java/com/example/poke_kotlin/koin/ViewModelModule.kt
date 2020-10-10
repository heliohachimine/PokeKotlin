package com.example.poke_kotlin.koin

import com.example.poke_kotlin.presentation.PokeLisViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PokeLisViewModel(
            get()
        )
    }
}