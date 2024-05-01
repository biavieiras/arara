package com.example.arara.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.arara.R

@Composable
fun InputField(
  value: String,
  onValueChange: (String) -> Unit,
  onClick: () -> Unit = {},
  aboutIcon: @Composable (() -> Unit)? = {},
  label: String,
  visualTransformation: VisualTransformation? = null,
  keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
  errorMessage: String,
  modifier: Modifier
) {
  Column {
    TextField(
      value = value,
      onValueChange = onValueChange,
      label = {
        Text(
          text = label,
          fontFamily = FontFamily(Font(R.font.quicksand)),
          fontWeight = FontWeight.W700,
          fontSize = 12.sp
        )
      },
      visualTransformation =  visualTransformation ?: VisualTransformation.None,
      keyboardOptions = keyboardOptions,
      isError = errorMessage.isNotEmpty(),
      singleLine = true,
      shape = MaterialTheme.shapes.small,
      colors = TextFieldDefaults.colors(
        cursorColor = Color.Black,
        disabledLabelColor = Color.LightGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        unfocusedContainerColor = Color(0xFFCBCBCB).copy(alpha = "7A".toInt(16) / 255f)
      ),
      trailingIcon = aboutIcon?.let { { aboutIcon() } },
      modifier = modifier.onFocusEvent {if (it.isFocused) onClick() }
    )
    if(errorMessage.isNotEmpty()) {
      Text(
        text = errorMessage,
        color = Color.Red,
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
      )
    }
  }
}
