public class Birth {

    private char gender;
    private byte plural;
    private byte age;
    private String race;
    private byte parity;
    private boolean married;
    private short bwt;
    private byte smokeN;
    private byte drinkN;
    private boolean firstep;
    private boolean welfare;
    private boolean smoker;
    private boolean drinker;
    private short wpre;
    private short wgain;
    private byte education;
    private byte gestation;

    public Birth(char gender, byte plural, byte age, String race, byte parity, boolean married, short bwt, byte smokeN,
                 byte drinkN, boolean firstep, boolean welfare, boolean smoker, boolean drinker, short wpre, short wgain,
                 byte education, byte gestation) {
        this.gender = gender;
        this.plural = plural;
        this.age = age;
        this.race = race;
        this.parity = parity;
        this.married = married;
        this.bwt = bwt;
        this.smokeN = smokeN;
        this.drinkN = drinkN;
        this.firstep = firstep;
        this.welfare = welfare;
        this.smoker = smoker;
        this.drinker = drinker;
        this.wpre = wpre;
        this.wgain = wgain;
        this.education = education;
        this.gestation = gestation;
    }

    public char getGender() {
        return gender;
    }

    public byte getPlural() {
        return plural;
    }

    public byte getAge() {
        return age;
    }

    public String getRace() {
        return race;
    }

    public byte getParity() {
        return parity;
    }

    public boolean isMarried() {
        return married;
    }

    public short getBwt() {
        return bwt;
    }

    public byte getSmokeN() {
        return smokeN;
    }

    public byte getDrinkN() {
        return drinkN;
    }

    public boolean isFirstep() {
        return firstep;
    }

    public boolean isWelfare() {
        return welfare;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public boolean isDrinker() {
        return drinker;
    }

    public short getWpre() {
        return wpre;
    }

    public short getWgain() {
        return wgain;
    }

    public byte getEducation() {
        return education;
    }

    public byte getGestation() {
        return gestation;
    }
}
