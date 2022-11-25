import androidx.compose.runtime.Composable
import me.omico.lux.androidx.navigation.NavigationRoute
import me.omico.lux.androidx.navigation.Route
import me.omico.lux.androidx.navigation.main

@NavigationRoute(
    route = "main",
)
@Composable
fun MainUi() {
    Route.main
}
