package com.loc.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.loc.newsapp.presentation.Dimens.IndicatorSize
import com.loc.newsapp.ui.theme.BlueGray

/**
 * Composable function to display a page indicator for onboarding or other paginated content.
 *
 * @param modifier Modifier for styling and positioning the page indicator.
 * @param pageSize The total number of pages or items to indicate.
 * @param selectedPage The currently selected page or item (0-based index).
 * @param selectedColor The color to indicate the selected page.
 * @param unselectedColor The color to indicate unselected pages.
 */
@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor : Color = BlueGray
){

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        // Repeat for each page
        repeat(pageSize){page ->
            // Create a box representing each page
            Box(
                modifier = Modifier.size(IndicatorSize).clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )

        }

    }

}