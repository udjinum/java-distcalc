package distillercalc;

import java.math.BigDecimal;

public class Sugar {
    private double density;
    private double concentration;

    public double getDensitySugar() {
        return density;
    }

    public Sugar useDensitySugar(double density) {
        this.density = density;
        return this;
    }

    public double getConcentrationSugar() {
        return concentration;
    }

    public Sugar useConcentrationSugar(double concentration) {
        this.concentration = concentration;
        return this;
    }
}
