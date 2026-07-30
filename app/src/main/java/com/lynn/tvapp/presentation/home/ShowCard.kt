package com.lynn.tvapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.lynn.tvapp.data.model.Show

@Composable
fun ShowCard(
    show: Show,
    modifier: Modifier = Modifier,
    onClick: (Show) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            onClick = { onClick(show) },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            SubcomposeAsyncImage(
                model = show.image,
                contentDescription = show.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                loading = {
                    CircularProgressIndicator()
                },
                error = {
                    Text("Image Error")
                },
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = show.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = "Ratings = " + show.rating,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
