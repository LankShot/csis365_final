package com.example.csis365_final.view

import com.example.csis365_final.dto.Characters
import com.example.csis365_final.dto.Character
import com.example.csis365_final.service.TheOneService
import com.example.csis365_final.view.characters.CharactersPresenter
import com.example.csis365_final.view.characters.CharactersView
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class CharactersPresenterTest {
    val theOneService: TheOneService = mockk(relaxed = true)
    val view: CharactersView = mockk(relaxed = true)

    val presenter = CharactersPresenter(view, theOneService)

    @Test
    fun `On start, call getCharacters`(){
        presenter.start()

        verify {theOneService.getCharacters(any(), any())}
    }

    @Test
    fun `When get characters, response is successful, bind characters to view`(){
        val characters = buildCharacters()

        every { theOneService.getCharacters(any(), any())} answers {
            firstArg<(Characters) -> Unit>().invoke(characters)
        }

        presenter.start()

        verify { view.bindCharacters(characters) }
    }

    private fun buildCharacters(): Characters {
        return Characters(
            docs = listOf(
                Character(
                    id = "5cd99d4bde30eff6ebccfe9e",
                    height = "",
                    race = "Hobbit",
                    gender = "Male",
                    birth = "TA 2430",
                    spouse = "",
                    death = "March 25, 3019",
                    realm = "",
                    hair = "",
                    name = "Gollum",
                    wikiUrl = "http://lotr.wikia.com//wiki/Gollum"
                )
            ),
            total =1,
            limit =  1000,
            offset= 0,
            page = 1,
            pages = 1
        )
    }


}