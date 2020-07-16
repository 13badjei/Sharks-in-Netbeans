/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg1;

/**
 *
 * @author cocopops2016
 */
public class Shark {
    private String commonName;
    private String latinName;
    private int maxLengthInCm;
    private int maxDepthInMetres;
    private int maxYoungInLifetime;
    private int roamRange;
    private String[] oceanicRegionSharkSightings;

    /** Construct a Shark object with the specified fields */
    public Shark(String commonName, String latinName, int maxLengthInCm) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.maxLengthInCm = maxLengthInCm;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getMaxLengthInCm() {
        return maxLengthInCm;
    }

    @Override
    public String toString() {
        return "Shark " + this.commonName + ", Length = " + this.maxLengthInCm + "\n";
    }   
}