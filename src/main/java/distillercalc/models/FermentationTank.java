package distillercalc.models;

public class FermentationTank {
    private int volume;
    private int percentUsefulVolume;

    public int getVolumeFermentationTank() {
        return volume;
    }

    public FermentationTank useVolumeFermentationTank(int volume) {
        this.volume = volume;
        return this;
    }

    public int getPercentUsefulVolumeFermentationTank() {
        return percentUsefulVolume;
    }

    public FermentationTank usePercentUsefulVolumeFermentationTank(int percentUsefulVolume) {
        this.percentUsefulVolume = percentUsefulVolume;
        return this;
    }

    public int getFinalUsefulVolumeFermentationTank(int volume, int percentUsefulVolume) {
        int emptyVolume = volume * percentUsefulVolume / 100;
        return volume - emptyVolume;
    }
}
