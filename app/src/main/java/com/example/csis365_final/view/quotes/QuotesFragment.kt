package com.example.csis365_final.view.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.Quotes
import com.google.android.material.snackbar.Snackbar

class QuotesFragment : Fragment(), QuotesView {

    lateinit var container: View
    lateinit var rvQuotes: RecyclerView

    lateinit var presenter: QuotesPresenter

    companion object {
        @JvmStatic
        fun newInstance() = QuotesFragment().apply {
            arguments = Bundle().apply {
                // If you have any arguments to pass into the fragment, you may do so in here like this:
//                putString(ARG_PARAM1, param1)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // if you have any arguments, pull them out here
//            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = QuotesPresenterFactory.createPresenter(this, requireContext())

        bindViews()
        presenter.start()
    }

    override fun bindQuotes(quotes: Quotes) {
        rvQuotes.layoutManager = LinearLayoutManager(requireContext())
        rvQuotes.adapter =  QuotesAdapter(quotes.docs.orEmpty())
    }


    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private fun bindViews() {
        container = requireView().findViewById(R.id.container)
        rvQuotes = requireView().findViewById(R.id.rv_quotes)
    }
}