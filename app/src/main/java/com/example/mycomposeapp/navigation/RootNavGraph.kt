package com.example.mycomposeapp.navigation

import com.example.first.FirstNavGraph
import com.example.second.SecondNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph : NavGraphSpec {

    override val destinationsByRoute: Map<String, DestinationSpec<*>>
        get() = emptyMap()

    override val route: String
        get() = "root"

    override val startRoute: Route
        get() = FirstNavGraph

    override val nestedNavGraphs: List<NavGraphSpec>
        get() = listOf(
            FirstNavGraph,
            SecondNavGraph
        )
}