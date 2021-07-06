package ru.vdv.myapp.beautifulpictureseveryday.domain

import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.BasicNasaRepository
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.LocalRepository

class TestNasaRepository : BasicNasaRepository, LocalRepository {
    // Здесь будут готовиться данные для передачи во viewModel
}