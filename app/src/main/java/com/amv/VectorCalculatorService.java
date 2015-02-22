package com.amv;

// Haisin Yip - 260480026
// Eric Liou -
public class VectorCalculatorService {

    public static boolean polar = false;

    public static double[] crossProduct(String in1, String in2, String in3, String in4) throws IllegalArgumentException, NumberFormatException {

        double[] result = {0,0,0};

        if (in1==null || in2==null || in3==null || in4==null)
            throw new IllegalArgumentException();

        double x1 = Double.parseDouble(in1);
        double y1 = Double.parseDouble(in2);
        double x2 = Double.parseDouble(in3);
        double y2 = Double.parseDouble(in4);

        if (polar) {
            double r1 = Double.parseDouble(in1);
            double t1 = Double.parseDouble(in2);
            t1 = Math.toRadians(t1);
            double r2 = Double.parseDouble(in3);
            double t2 = Double.parseDouble(in4);
            t2 = Math.toRadians(t2);

            // convert polar to cartesian
            x1 = r1*Math.cos(t1);
            y1 = r1*Math.sin(t1);
            x2 = r2*Math.cos(t2);
            y2 = r2*Math.sin(t2);
        }

        result[2] = (x1*y2)-(x2*y1);
        return result;
    }

    public static double scalarProduct(String in1, String in2, String in3, String in4) throws IllegalArgumentException, NumberFormatException {
        if (in1==null || in2==null || in3==null || in4==null)
            throw new IllegalArgumentException();

        double x1 = Double.parseDouble(in1);
        double y1 = Double.parseDouble(in2);
        double x2 = Double.parseDouble(in3);
        double y2 = Double.parseDouble(in4);

        if (polar) {
            double r1 = Double.parseDouble(in1);
            double t1 = Double.parseDouble(in2);
            t1 = Math.toRadians(t1);
            double r2 = Double.parseDouble(in3);
            double t2 = Double.parseDouble(in4);
            t2 = Math.toRadians(t2);

            // convert polar to cartesian
            x1 = r1*Math.cos(t1);
            y1 = r1*Math.sin(t1);
            x2 = r2*Math.cos(t2);
            y2 = r2*Math.sin(t2);
        }

        return (x1*x2)+(y1*y2);
    }

    public static double[] vectorAddition(String in1, String in2, String in3, String in4, String in5, String in6) throws IllegalArgumentException {

        double result[] = {0.0, 0.0};

        if ((in1==null || in2==null || in3==null || in4==null))
            throw new IllegalArgumentException();

        else if ((in5==null || in6==null) && !(in5==null && in6==null))
            throw  new IllegalArgumentException();

        else {
            double x1 = Double.parseDouble(in1);
            double y1 = Double.parseDouble(in2);
            double x2 = Double.parseDouble(in3);
            double y2 = Double.parseDouble(in4);
            double x3 = 0.0;
            double y3 = 0.0;

            if (in5!=null && in6!=null) {
                try {
                    x3 = Double.parseDouble(in5);
                    y3 = Double.parseDouble(in6);

                    if (polar) {
                        double r3 = Double.parseDouble(in5);
                        double t3 = Double.parseDouble(in6);
                        t3 = Math.toRadians(t3);

                        x3 = r3 * Math.cos(t3);
                        y3 = r3 * Math.sin(t3);
                    }
                } catch (NumberFormatException nfe) {
                    x3 = 0.0;
                    y3 = 0.0;
                }
            }

            if (polar) {
                double r1 = Double.parseDouble(in1);
                double t1 = Double.parseDouble(in2);
                t1 = Math.toRadians(t1);
                double r2 = Double.parseDouble(in3);
                double t2 = Double.parseDouble(in4);
                t2 = Math.toRadians(t2);

                // convert polar to cartesian
                x1 = r1*Math.cos(t1);
                y1 = r1*Math.sin(t1);
                x2 = r2*Math.cos(t2);
                y2 = r2*Math.sin(t2);

            }

            result[0] = x1+x2+x3;
            result[1] = y1+y2+y3;
        }

        return result;
    }
}
