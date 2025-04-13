package com.furkanmulayim.golden.core.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun HorizontalListWheelPicker(
    items: List<String>,
    modifier: Modifier = Modifier,
    itemWidth: Dp = 75.dp,
    height: Dp = 60.dp,
    unfocusedCount: Int = 1,
    state: FWheelPickerState = rememberFWheelPickerState(),
    onItemSelected: (String) -> Unit,
) {
    val totalWidth = itemWidth * (unfocusedCount * 2 + 1)

    Box(
        modifier = modifier
            .height(height)
            .width(totalWidth), contentAlignment = Alignment.Center
    ) {
        val scrollConnection = remember(state) {
            WheelPickerNestedScrollConnection(state)
        }.apply {
            isVertical = false
            itemSizePx = with(LocalDensity.current) { itemWidth.roundToPx() }
            reverseLayout = false
        }

        LazyRow(
            state = state.lazyListState,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .matchParentSize()
                .nestedScroll(scrollConnection),
        ) {
            items(
                items = items, key = { it }) { item ->
                Box(
                    modifier = Modifier
                        .width(itemWidth)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    val isSelected = state.currentIndexSnapshot == items.indexOf(item)
                    val scale by animateFloatAsState(if (isSelected) 1f else 0.8f, label = "")
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.graphicsLayer {
                            this.alpha = if (isSelected) 1f else 0.3f
                            this.scaleX = scale
                            this.scaleY = scale
                        })
                }
            }
        }

        // Focus overlay
        Box(
            modifier = Modifier
                .width(itemWidth)
                .fillMaxHeight()
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .width(1.dp)
                    .fillMaxHeight()
                    .align(Alignment.CenterStart)
            )
            Box(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .width(1.dp)
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
            )
        }
    }

    LaunchedEffect(state.currentIndexSnapshot) {
        val index = state.currentIndexSnapshot
        if (index in items.indices) {
            onItemSelected(items[index])
        }
    }
}

@Composable
fun rememberFWheelPickerState(initialIndex: Int = 0): FWheelPickerState {
    return remember {
        FWheelPickerState(initialIndex = initialIndex)
    }
}

class FWheelPickerState(initialIndex: Int = 0) {
    internal val lazyListState = LazyListState()
    private var _currentIndexSnapshot by mutableIntStateOf(initialIndex)
    val currentIndexSnapshot: Int get() = _currentIndexSnapshot

    internal fun synchronizeCurrentIndexSnapshot(): Int {
        return (lazyListState.layoutInfo.visibleItemsInfo.minByOrNull { it.offset.absoluteValue })?.index?.also {
            _currentIndexSnapshot = it
        } ?: _currentIndexSnapshot
    }
}

private class WheelPickerNestedScrollConnection(
    private val state: FWheelPickerState,
) : NestedScrollConnection {
    var isVertical: Boolean = false
    var itemSizePx: Int = 0
    var reverseLayout: Boolean = false

    override fun onPostScroll(
        consumed: Offset, available: Offset, source: NestedScrollSource
    ): Offset {
        state.synchronizeCurrentIndexSnapshot()
        return Offset.Zero
    }

    override suspend fun onPreFling(available: Velocity): Velocity {
        state.synchronizeCurrentIndexSnapshot()
        return super.onPreFling(available)
    }
}
