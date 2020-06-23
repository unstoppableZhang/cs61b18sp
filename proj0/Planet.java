public class Planet {
    private static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Planet b) {
        double rSquare = Math.pow(b.yyPos - yyPos, 2) + Math.pow(b.xxPos - xxPos, 2);
        return Math.sqrt(rSquare);
    }

    public double calcForceExertedBy(Planet b) {
        return G * mass * b.mass / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Planet b) {
        return calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);
    }

    public double calcForceExertedByY(Planet b) {
        return calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] bs) {
        double netForceX = 0.0;
        for (Planet b : bs) {
            if (!b.equals(this)) {
                netForceX += calcForceExertedByX(b);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] bs) {
        double netForceY = 0.0;
        for (Planet b : bs) {
            if (!b.equals(this)) {
                netForceY += calcForceExertedByY(b);
            }
        }
        return netForceY;
    }

    public void update(double dt, double Fx, double Fy) {
        double aX = Fx / mass;
        xxVel += aX * dt;
        xxPos += xxVel * dt;
        double aY = Fy / mass;
        yyVel = yyVel + aY * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
