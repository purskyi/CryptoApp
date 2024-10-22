package com.plcoding.cryptotracker.crypto.presentation.models.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PersonSearch
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.greenBackground

@Composable
fun PriceChange(
    change: DisplayableNumber,
    modifier: Modifier = Modifier
){
    val contentColor = if(change.value < 0.0)MaterialTheme.colorScheme.onErrorContainer else Color.Green
    val backGroundColor = if(change.value < 0.0)MaterialTheme.colorScheme.errorContainer else greenBackground

    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
        .clip(RoundedCornerShape(100f))
        .background(backGroundColor)
        .padding(horizontal = 4.dp)) {
        Icon(
            imageVector = if(change.value < 0.0) Icons.Default.KeyboardArrowDown
            else Icons.Default.KeyboardArrowUp,
            contentDescription =  if(change.value < 0.0) Icons.Default.KeyboardArrowDown.name
            else Icons.Default.KeyboardArrowUp.name,
            modifier = Modifier.size(20.dp),
            tint = contentColor
            )
        Text(
            text = "${change.formatted} %",
            fontWeight = FontWeight.Medium,
            color = contentColor)
    }


}

@Preview
@Composable
private fun priceChangePreview (){

    PriceChange(
        change = DisplayableNumber(value = 2.89, formatted = "2.89")
    )
}