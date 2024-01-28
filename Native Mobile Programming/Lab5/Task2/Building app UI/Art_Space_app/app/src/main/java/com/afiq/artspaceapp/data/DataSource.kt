package com.afiq.artspaceapp.data

import com.afiq.artspaceapp.R
import com.afiq.artspaceapp.model.Content

/**
 * [Datasource] generates a list of [Content]
 */
class DataSource() {
    fun loadAffirmations(): List<Content> {
        return listOf<Content>(
            Content(
                R.drawable.image1,
                R.string.ArtworkTitle1,
                R.string.Year1,
                R.string.Author1
            ),
            Content(
                R.drawable.image2,
                R.string.ArtworkTitle2,
                R.string.Year2,
                R.string.Author2
            ),
            Content(
                R.drawable.image3,
                R.string.ArtworkTitle3,
                R.string.Year3,
                R.string.Author3
            ),
            Content(
                R.drawable.image4,
                R.string.ArtworkTitle4,
                R.string.Year4,
                R.string.Author4
            ),
            Content(
                R.drawable.image5,
                R.string.ArtworkTitle5,
                R.string.Year5,
                R.string.Author5
            ),
            Content(
                R.drawable.image6,
                R.string.ArtworkTitle6,
                R.string.Year6,
                R.string.Author6
            )
        )

    }
}