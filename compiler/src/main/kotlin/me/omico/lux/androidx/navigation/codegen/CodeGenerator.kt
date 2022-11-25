package me.omico.lux.androidx.navigation.codegen

import com.google.devtools.ksp.symbol.KSFile
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.ksp.addOriginatingKSFile
import me.omico.lux.androidx.navigation.NavigationRoute

internal fun createRouteFileSpec(navigationRouteMap: Map<KSFile, Sequence<NavigationRoute>>): FileSpec =
    FileSpec.builder("me.omico.lux.androidx.navigation", "Route")
        .addType(TypeSpec.objectBuilder("Route").build())
        .apply {
            navigationRouteMap.forEach { (ksFile, navigationRoutes) ->
                navigationRoutes.forEach { addRouteProperty(ksFile, it.route) }
            }
        }
        .build()

private fun FileSpec.Builder.addRouteProperty(ksFile: KSFile, route: String) =
    PropertySpec.builder(route, String::class)
        .addOriginatingKSFile(ksFile)
        .receiver(ClassName("me.omico.lux.androidx.navigation", "Route"))
        .apply {
            FunSpec.getterBuilder()
                .addModifiers(KModifier.INLINE)
                .addStatement("return %S", route)
                .build()
                .also(::getter)
        }
        .build()
        .let(::addProperty)
