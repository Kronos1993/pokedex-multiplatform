package com.kronos.mutliplatform.pokedex.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.core.ui.components.button.Button
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonStyle
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingRadioOptions(
    title: String,
    subtitle: String,
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    options: List<Pair<String, String>>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface
    val radioColor = MaterialTheme.colorScheme.primary

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TitleText(text = title, textColor = textColor)
            }
            BodyText(
                text = subtitle,
                size = ComponentSize.LARGE,
                textColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOptionSelected(option.second) }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BodyText(text = option.first, size = ComponentSize.LARGE, textColor = textColor)
                    RadioButton(
                        selected = selectedOption == option.second,
                        onClick = { onOptionSelected(option.second) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = radioColor,
                            unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingRadioOption(
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    option: Pair<String, String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface
    val radioColor = MaterialTheme.colorScheme.primary

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOptionSelected(option.second) }
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                BodyText(text = option.first, size = ComponentSize.LARGE, textColor = textColor)
                Spacer(modifier = Modifier.weight(1f))
                RadioButton(
                    selected = selectedOption == option.second,
                    onClick = { onOptionSelected(option.second) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = radioColor,
                        unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingRadioOptions(
    title: String,
    subtitle: String,
    textColor: Color = Color.Unspecified,
    icon: ImageVector? = null,
    iconDesc: String? = null,
    iconTint: Color = Color.Unspecified,
    options: List<Pair<String, String>>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val resolvedTextColor =
        if (textColor == Color.Unspecified) MaterialTheme.colorScheme.onSurface else textColor
    val resolvedIconTint =
        if (iconTint == Color.Unspecified) MaterialTheme.colorScheme.onSurface else iconTint
    val radioColor = MaterialTheme.colorScheme.primary

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        tint = resolvedIconTint,
                        contentDescription = iconDesc,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TitleText(text = title, textColor = resolvedTextColor)
            }
            BodyText(
                text = subtitle,
                size = ComponentSize.LARGE,
                textColor = if (textColor == Color.Unspecified) MaterialTheme.colorScheme.onSurfaceVariant else textColor
            )
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOptionSelected(option.second) }
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BodyText(
                        text = option.first,
                        size = ComponentSize.LARGE,
                        textColor = resolvedTextColor
                    )
                    RadioButton(
                        selected = selectedOption == option.second,
                        onClick = { onOptionSelected(option.second) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = radioColor,
                            unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingSwitchOptions(
    title: StringResource,
    subtitle: StringResource?,
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    options: List<Pair<String, String>>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TitleText(text = stringResource(title), textColor = textColor)
            }
            if (subtitle != null)
                BodyText(
                    text = stringResource(subtitle),
                    size = ComponentSize.LARGE,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOptionSelected(option.second) }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BodyText(text = option.first, size = ComponentSize.LARGE, textColor = textColor)
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = selectedOption == option.second,
                        onCheckedChange = { onOptionSelected(option.second) }
                    )
                }
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingSwitchOption(
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    option: Pair<String, String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                BodyText(text = option.first, size = ComponentSize.LARGE, textColor = textColor)
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = selectedOption == option.second,
                    onCheckedChange = { onOptionSelected(option.second) }
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingClickableOptions(
    title: String,
    subtitle: String?,
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    options: List<Pair<String, String>>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TitleText(text = title, textColor = textColor)
            }
            if (subtitle != null)
                BodyText(
                    text = subtitle,
                    size = ComponentSize.LARGE,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOptionSelected(option.second) }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BodyText(text = option.first, size = ComponentSize.LARGE, textColor = textColor)
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = selectedOption == option.second,
                        onCheckedChange = { onOptionSelected(option.second) }
                    )
                }
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingClickableOption(
    title: String,
    icon: DrawableResource? = null,
    iconDesc: String? = null,
    onOptionSelected: () -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOptionSelected() }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                BodyText(text = title, size = ComponentSize.LARGE, textColor = textColor)
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}

@Composable
fun SettingButtonOptions(
    title: String,
    subtitle: String?,
    icon: ImageVector? = null,
    iconDesc: String? = null,
    buttonText: String,
    buttonIcon: ImageVector? = null,
    buttonStyle: ButtonStyle,
    buttonType: ButtonType,
    onClick: () -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onSurface

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = iconDesc,
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                TitleText(text = title, textColor = textColor)
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (subtitle != null)
                BodyText(
                    text = subtitle,
                    size = ComponentSize.LARGE,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick,
                text = buttonText,
                icon = buttonIcon,
                type = buttonType,
                style = buttonStyle,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        }
    }
}