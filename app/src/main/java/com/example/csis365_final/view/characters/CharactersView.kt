package com.example.csis365_final.view.characters

import com.example.csis365_final.dto.Characters

interface CharactersView {
    fun bindCharacters(characters: Characters)
    fun showError(errorMessage: String)
}