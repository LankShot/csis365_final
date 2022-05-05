package com.example.csis365_final.view.characters

import android.content.SharedPreferences
import com.example.csis365_final.service.TheOneService


class CharactersPresenter(
    val view: CharactersView,
    val theOneService: TheOneService
) {

    fun start() {

        getCharacters()
    }


    fun getCharacters() {
        theOneService.getCharacters(

            successCallback = { characters ->
                view.bindCharacters(characters)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

}
