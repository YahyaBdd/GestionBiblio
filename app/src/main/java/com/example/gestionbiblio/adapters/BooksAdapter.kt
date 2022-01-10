package com.example.gestionbiblio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestionbiblio.R
import com.example.gestionbiblio.models.jsonResponse.JsonResponse


class BooksAdapter(val jsonResponse:JsonResponse) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val BookCover=view.findViewById<ImageView>(R.id.BookCover)
        val BookTitle=view.findViewById<TextView>(R.id.BookTitle)
        val BookAuthor=view.findViewById<TextView>(R.id.BookAuthor)
        val BookDesc=view.findViewById<TextView>(R.id.BookDesc)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.books_rv, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.BookCover.setImageResource(R.drawable.ic_launcher_background)
        var author:String = ""
        if (jsonResponse.items[position].volumeInfo != null) {
            for (auth in jsonResponse.items[position].volumeInfo?.authors!!){
                if(author == ""){author = author + "$auth"}
                else{author = author +" / $auth"}
            }}
        viewHolder.BookTitle.text = jsonResponse.items[position].volumeInfo?.title
        viewHolder.BookAuthor.text = author
        viewHolder.BookDesc.text = jsonResponse.items[position].volumeInfo?.description

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = jsonResponse.items.count()

}
