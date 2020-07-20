import synthesizer.GuitarString;

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static GuitarString[] guitarStrings;
    public static void main(String[] args) {
        guitarStrings = new GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i ++){
            guitarStrings[i] = new GuitarString(440.0 * Math.pow(2,(i - 24)/12.0));
        }
        while (true) {
            GuitarString s = null;
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                s = guitarStrings[keyboard.indexOf(key)];
                s.pluck();
            }

            /* compute the superposition of samples */
            if (s != null){
                double sample = s.sample();
                StdAudio.play(sample);
                s.tic();
            }

            /* play the sample on standard audio */

            /* advance the simulation of each guitar string by one step */
        }
    }
}
