import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

enum class LayoutType {
    COMPACT, // Phones/small tablets portrait
    MEDIUM,  // Tablets portrait/phones landscape
    EXPANDED  // Tablets landscape/desktops
}

@Composable
fun ResponsiveLayout(content: @Composable () -> Unit = {}) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val layoutType = when {
        screenWidth < 600 -> LayoutType.COMPACT
        screenWidth in 600..840 -> LayoutType.MEDIUM
        else -> LayoutType.EXPANDED
    }

    when(layoutType) {
        LayoutType.COMPACT -> CompactLayout(content)
        LayoutType.MEDIUM -> MediumLayout(content)
        LayoutType.EXPANDED -> ExpandedLayout(content)
    }
}

@Composable
private fun CompactLayout(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Vertical layout optimized for narrow screens
        content()
    }
}

@Composable
private fun MediumLayout(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Basic two-column layout with spacing
        content()
    }
}

@Composable
private fun ExpandedLayout(content: @Composable () -> Unit) { 
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Full-width three-column layout with generous spacing
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ResponsiveLayoutPrev(){
    ResponsiveLayout{Text("Test")}
}