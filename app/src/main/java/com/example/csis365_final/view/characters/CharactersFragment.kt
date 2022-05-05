package com.example.csis365_final.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.Characters
import com.google.android.material.snackbar.Snackbar

class CharactersFragment : Fragment(), CharactersView {

    lateinit var container: View
    lateinit var rvCharacters: RecyclerView

    lateinit var presenter: CharactersPresenter

    companion object {
        @JvmStatic
        fun newInstance() = CharactersFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CharactersPresenterFactory.createPresenter(this, requireContext())

        bindViews()
        presenter.start()
    }

    override fun bindCharacters(characters: Characters) {
        rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        rvCharacters.adapter =  CharactersAdapter(characters.docs.orEmpty())
    }


    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private fun bindViews() {
        container = requireView().findViewById(R.id.container)
        rvCharacters = requireView().findViewById(R.id.rv_characters)
    }
}