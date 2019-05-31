package kim.nox.bioengine

import kim.nox.bioengine.biometrics.Matcher

fun main() {
    println(Matcher("probe.bmp", "candidate.bmp").match())
}