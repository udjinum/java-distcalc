package distillercalc.models;

public class Alcohol {
    private int volume;
    private int strengthBefore;
    private int strengthAfter;

    public int getVolumeAlcohol() {
        return volume;
    }

    public Alcohol useVolumeAlcohol(int volume) {
        this.volume = volume;
        return this;
    }

    public int getStrengthAlcoholBefore() {
        return strengthBefore;
    }

    public Alcohol useStrengthAlcoholBefore(int strengthBefore) {
        this.strengthBefore = strengthBefore;
        return this;
    }

    public int getStrengthAlcoholAfter() {
        return strengthAfter;
    }

    public Alcohol useStrengthAlcoholAfter(int strengthAfter) {
        this.strengthAfter = strengthAfter;
        return this;
    }
}
