package com.afiq.artspaceapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Content(
    @DrawableRes val imageResourceId: Int,
    @StringRes val artworkResourceId: Int,
    @StringRes val yearResourceId: Int,
    @StringRes val authorResourceId: Int
)