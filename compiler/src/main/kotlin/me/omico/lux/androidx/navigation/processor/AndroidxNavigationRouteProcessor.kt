package me.omico.lux.androidx.navigation.processor

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.ksp.writeTo
import me.omico.lux.androidx.navigation.NavigationRoute
import me.omico.lux.androidx.navigation.codegen.createRouteFileSpec

class AndroidxNavigationRouteProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : SymbolProcessor {

    private var resolved = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("Processing AndroidxNavigationRoute")
        if (resolved) return emptyList()
        resolver.generateRoute()
        resolved = true
        return emptyList()
    }

    @OptIn(KspExperimental::class)
    private fun Resolver.generateRoute() {
        logger.info("Generating route")
        val navigationRouteMap = getNewFiles()
            .associateWith { ksFile ->
                ksFile.declarations.flatMap { ksDeclaration -> ksDeclaration.getAnnotationsByType(NavigationRoute::class) }
            }
        if (navigationRouteMap.isEmpty()) return
        createRouteFileSpec(navigationRouteMap).writeTo(codeGenerator, aggregating = false)
    }
}
