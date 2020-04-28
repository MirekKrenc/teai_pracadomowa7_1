package krenc.mirek.teaipracadomowatydzien71.controller;

public class Years {

    private int fromYear;
    private int toYear;

    public Years(int fromYear, int toYear) {
        this.fromYear = fromYear;
        this.toYear = toYear;
    }

    public Years() {
    }

    public int getFromYear() {
        return fromYear;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }
}
