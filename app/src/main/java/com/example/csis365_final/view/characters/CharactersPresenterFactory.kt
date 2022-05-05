package com.example.csis365_final.view.characters

import android.content.Context
import com.example.csis365_final.service.TheOneService

class CharactersPresenterFactory {

    companion object {
        fun createPresenter(view: CharactersView, context: Context): CharactersPresenter {
            return CharactersPresenter(
                view,
                TheOneService(),
                context.getSharedPreferences("key", Context.MODE_PRIVATE))
        }
    }
}
