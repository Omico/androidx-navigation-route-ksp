package me.omico.lux.androidx.navigation.processor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class AndroidxNavigationRouteProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        AndroidxNavigationRouteProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger,
        )
}
