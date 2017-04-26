public class Planet {
    public static double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet other) {
        double dx = other.xxPos - this.xxPos;
        double dy = other.yyPos - this.yyPos;
        double r_sq = dx * dx + dy * dy;
        return Math.sqrt(r_sq);
    }

    public double calcForceExertedByX(Planet other) {
        double dx = other.xxPos - this.xxPos;
        double distance = this.calcDistance(other);
        double force = calcForceExertedBy(other);
        return force * dx / distance;
    }

    public double calcForceExertedByY(Planet other) {
        double dy = other.yyPos - this.yyPos;
        double distance = this.calcDistance(other);
        double force = calcForceExertedBy(other);
        return force * dy / distance;
    }

    public double calcForceExertedBy(Planet other) {
        return G * this.mass * other.mass / Math.pow(this.calcDistance(other), 2);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceByX = 0;
        for(Planet planet : allPlanets) {
            if(this == planet) {
                continue;
            }
            netForceByX += this.calcForceExertedByX(planet);
        }
        return netForceByX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceByY = 0;
        for(Planet planet : allPlanets) {
            if(this == planet) {
                continue;
            }
            netForceByY += this.calcForceExertedByY(planet);
        }
        return netForceByY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }
}
