package com.aniruddha81.hiltretrofitnavigationmvvm.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aniruddha81.hiltretrofitnavigationmvvm.R
import com.aniruddha81.hiltretrofitnavigationmvvm.viewmodels.CategoriesViewModel

@Composable
fun CategoryScreen(onClick: (String) -> Unit) {
    val categoriesViewModel: CategoriesViewModel = hiltViewModel()
    val category: State<List<String>> = categoriesViewModel.categories.collectAsState()

    Column(Modifier.fillMaxSize()) {
        if (category.value.isEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(category.value) {
                    CategoryItem(it, onClick)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: String, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .size(120.dp)
            .border(BorderStroke(2.dp, Color.DarkGray), shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .paint(painter = painterResource(id = R.drawable.layered_waves_haikei))
            .clickable { onClick(category) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}