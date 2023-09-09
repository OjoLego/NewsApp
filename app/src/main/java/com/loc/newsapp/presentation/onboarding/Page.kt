package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

/**
 * Represents a page in the onboarding process.
 *
 * @param title The title of the onboarding page.
 * @param description The description or content of the onboarding page.
 * @param image The image resource ID for the onboarding page.
 */
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

/**
 * List of onboarding pages.
 *
 * Each item in this list represents a page in the onboarding process, containing a title, description,
 * and an associated image resource.
 */
val pages = listOf(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding3
    )
)
