public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        in.readDouble();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int num = in.readInt();
        Planet[] planets = new Planet[num];
        in.readDouble();
        for(int i = 0; i < num; ++i) {
            double xp = in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xp, yp, xv, yv, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        String folder = "./images/";
        Planet[] allPlanets = readPlanets(filename);

        double time = 0;
        double xForces[] = new double[allPlanets.length];
        double yForces[] = new double[allPlanets.length];

        int waitTimeMilliseconds = 10;
        StdAudio.play("./audio/2001.mid");
        while(time <= T) {
            for(int i = 0; i < allPlanets.length; ++i) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            for(int i = 0; i < allPlanets.length; ++i) {
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, folder + "starfield.jpg", 2 * radius, 2 * radius);
            for(Planet planet : allPlanets) {
                StdDraw.picture(planet.xxPos, planet.yyPos, folder + planet.imgFileName);
            }
            StdDraw.show(waitTimeMilliseconds);
            time += dt;
        }

    }
}
