package kim.nox.bioengine.biometrics

import com.machinezoo.sourceafis.FingerprintMatcher
import com.machinezoo.sourceafis.FingerprintTemplate
import kim.nox.bioengine.io.extractTemplate

class Matcher(probe: String, candidate: String) {
    var score: Number = 0
        private set
    var probeTemplate: FingerprintTemplate = extractTemplate(probe)
    var candidateTemplate: FingerprintTemplate = extractTemplate(candidate)

    fun match(): Number {
        score = FingerprintMatcher().index(probeTemplate).match(candidateTemplate)
        return score
    }
}