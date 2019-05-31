package kim.nox.bioengine;

import kim.nox.bioengine.biometrics.Matcher;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Matcher("probe.bmp", "candidate.bmp").match());
    }
}