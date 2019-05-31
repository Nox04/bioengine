package kim.nox.bioengine.biometrics;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class Matcher {

    private double score = 0.0;
    private FingerprintTemplate probeTemplate;
    private FingerprintTemplate candidateTemplate;

    public Matcher(String probe, String candidate) {
        probeTemplate = Extractor.extractTemplate(probe);
        candidateTemplate = Extractor.extractTemplate(candidate);
    }

    public double match() {
        score = new FingerprintMatcher().index(probeTemplate).match(candidateTemplate);
        return score;
    }

    public double getScore() {
        return score;
    }
}
