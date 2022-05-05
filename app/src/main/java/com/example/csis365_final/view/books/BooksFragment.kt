package com.example.csis365_final.view.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.BookReturn
import com.example.csis365_final.view.quotes.QuotesView
import com.google.android.material.snackbar.Snackbar

class BooksFragment : Fragment(), BooksView {

    lateinit var container: View
    lateinit var rvBooks: RecyclerView

    lateinit var presenter: BooksPresenter

    companion object {
        @JvmStatic
        fun newInstance() = BooksFragment().apply {
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
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = BooksPresenterFactory.createPresenter(this, requireContext())

        bindViews()
        presenter.start()
    }

    override fun bindBookReturn(books: BookReturn) {
        rvBooks.layoutManager = LinearLayoutManager(requireContext())
        rvBooks.adapter =  BooksAdapter(books.docs.orEmpty())
    }


    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private fun bindViews() {
        container = requireView().findViewById(R.id.container)
        rvBooks = requireView().findViewById(R.id.rv_books)
    }
}