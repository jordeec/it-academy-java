package java.itinerari.variables;

public  class Fase3 {
    public static void main(String[] args) {
        final int TRASPAS = 1948;
        final int NEIXEMENT = 1973;
        StringBuilder sb = new StringBuilder();

        System.out.println("Ensenyant els anys de traspàs entre " + TRASPAS + " i " + NEIXEMENT + ":");

        for (int any = TRASPAS; any <= NEIXEMENT; any++) {
            if(Fase2.isLeap(any)){
                System.out.println(any);                    
            }
        }

        boolean esTraspasNeixement = Fase2.isLeap(NEIXEMENT);
        String afirmatiu = sb.append("L'any ").append(NEIXEMENT).append(" és de traspàs").toString();
        sb = new StringBuilder();
        String negatiu = sb.append("L'any ").append(NEIXEMENT).append(" NO és de traspàs").toString();

        System.out.println(esTraspasNeixement ? afirmatiu : negatiu);

        /*
        També es pot fer així? 

        System.out.println("L'any " + NEIXEMENT + (!esTraspasNeixement ? " no " : "") + "és de traspàs." );
        */
    }
}