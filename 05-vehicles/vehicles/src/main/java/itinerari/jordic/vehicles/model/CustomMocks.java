package itinerari.jordic.vehicles.model;

import java.util.ArrayList;
import java.util.List;

/* Easy way to add mocks of ArrayList<String> in the system */
public class CustomMocks {

    public static final String CAR = "Car";
    public static final String BIKE = "Bike";
    public static final String PLATE_REGEXP = "^[0-9]{4}-([B-D]|[F-H]|[J-N]|[P-T]|[V-Z]){2,}$";
    public static final String DIAMETER_REGEXP = "^([0-4]{1})(([,.]{1})([0-9]{1,2}))?$";

    public static List<String> getWheels() {

        final ArrayList<String> a = new ArrayList<>();

        a.add("APlus");
        a.add("AUSTONE");
        a.add("Accelera");
        a.add("Achilles");
        a.add("American Classic");
        a.add("Antares");
        a.add("Aoteli");
        a.add("Apollo");
        a.add("Aptany");
        a.add("Ardent");
        a.add("Arivo");
        a.add("Atlas");
        a.add("Atturo");
        a.add("Avon");
        a.add("Avon Vintage");
        a.add("BF Goodrich");
        a.add("Barum");
        a.add("Blockley");
        a.add("Bridgestone");
        a.add("CST");
        a.add("Camac");
        a.add("Classic Street Tires");
        a.add("Coker");
        a.add("Comforser");
        a.add("Compass");
        a.add("Continental");
        a.add("Cooper");
        a.add("Davanti");
        a.add("Debica");
        a.add("Double Coin");
        a.add("Double Star");
        a.add("Dunlop");
        a.add("Duraturn");
        a.add("Evergreen");
        a.add("Excelsior");
        a.add("Falken");
        a.add("Federal");
        a.add("Firemax");
        a.add("Firestone");
        a.add("Fortuna");
        a.add("Fulda");
        a.add("Fullrun");
        a.add("GT Radial");
        a.add("General");
        a.add("Gislaved");
        a.add("Goform");
        a.add("Goodride");
        a.add("Goodyear");
        a.add("Gremax");
        a.add("Grenlander");
        a.add("Gripmax");
        a.add("HI FLY");
        a.add("Habilead");
        a.add("Haida");
        a.add("Hankook");
        a.add("Headway");
        a.add("Heidenau");
        a.add("Hilo");
        a.add("Imperial");
        a.add("Infinity");
        a.add("Insa Turbo");
        a.add("Jinyu");
        a.add("Kenda");
        a.add("Keter");
        a.add("Kinforest");
        a.add("King Meiler");
        a.add("Kingstar");
        a.add("Kleber");
        a.add("Kontio");
        a.add("Kormoran");
        a.add("Kumho");
        a.add("Landsail");
        a.add("Lanvigator");
        a.add("Lassa");
        a.add("Laufenn");
        a.add("Lexani");
        a.add("Linglong");
        a.add("Malatesta");
        a.add("Mastersteel");
        a.add("Matador");
        a.add("Maxtrek");
        a.add("Maxxis");
        a.add("Mazzini");
        a.add("Michelin");
        a.add("Michelin Collection");
        a.add("Milestone");
        a.add("Minerva");
        a.add("Minnell");
        a.add("Nankang");
        a.add("Neolin");
        a.add("Nexen");
        a.add("Nitto");
        a.add("Nokian");
        a.add("Nordexx");
        a.add("Nortenha");
        a.add("Orium");
        a.add("Ovation");
        a.add("Pace");
        a.add("Petlas");
        a.add("Phoenix");
        a.add("Pirelli");
        a.add("Platin");
        a.add("Pneumant");
        a.add("PointS");
        a.add("PowerTrac");
        a.add("Powertrac");
        a.add("Premiorri");
        a.add("Profil");
        a.add("Radar");
        a.add("Retro");
        a.add("Riken");
        a.add("RoadX");
        a.add("Roadcruza");
        a.add("Roadmarch");
        a.add("Roadstone");
        a.add("Roadx");
        a.add("Rotalla");
        a.add("Royal");
        a.add("Saetta");
        a.add("Sailun");
        a.add("Sava");
        a.add("Seiberling");
        a.add("Semperit");
        a.add("Silverstone");
        a.add("Sonar");
        a.add("Star");
        a.add("Star Performer");
        a.add("Sunny");
        a.add("Superia");
        a.add("Syron");
        a.add("THREE-A");
        a.add("Taurus");
        a.add("Tigar");
        a.add("Tomket");
        a.add("Torque");
        a.add("Toyo");
        a.add("Tracmax");
        a.add("Trazano");
        a.add("Triangle");
        a.add("Tristar");
        a.add("Unigrip");
        a.add("Uniroyal");
        a.add("Viking");
        a.add("Vitour");
        a.add("Vredestein");
        a.add("Wanli");
        a.add("Waymaster");
        a.add("Westlake");
        a.add("Windforce");
        a.add("Winrun");
        a.add("Winter Tact");
        a.add("Wolf Tyres");
        a.add("Yokohama");
        a.add("Zeetex");
        a.add("Zenises");
        a.add("Ziarelli");

        return a;

    }

    public static List<String> getColors() {

        final ArrayList<String> a = new ArrayList<>();
        a.add("Pink");
        a.add("Mauv");
        a.add("Violet");
        a.add("Orange");
        a.add("Blue");
        a.add("Teal");
        a.add("Khaki");
        a.add("Aquamarine");
        a.add("Turquoise");
        a.add("Yellow");
        a.add("Puce");
        a.add("Red");
        a.add("Indigo");
        a.add("Crimson");
        a.add("Fuscia");
        a.add("Maroon");

        return a;
    }

    public static List<String> getCarBrands() {
        final ArrayList<String> a = new ArrayList<>();

        a.add("Acura");
        a.add("AlfaRomeo");
        a.add("Aston_Martin");
        a.add("Bentley");
        a.add("BMW");
        a.add("Buick");
        a.add("Cadillac");
        a.add("Chevrolet");
        a.add("Corbin");
        a.add("Dodge");
        a.add("Eagle");
        a.add("Ferrari");
        a.add("Fillmore");
        a.add("Ford");
        a.add("Geo");
        a.add("Holden");
        a.add("Honda");
        a.add("Hummer");
        a.add("Isuzu");
        a.add("Jeep");
        a.add("Jensen");
        a.add("Kia");
        a.add("Lamborghini");
        a.add("Lexus");
        a.add("Lotus");
        a.add("Maserati");
        a.add("Mazda");
        a.add("Mercedes_Benz");
        a.add("Mitsubishi");
        a.add("Nissan");
        a.add("Panoz");
        a.add("Pontiac");
        a.add("Rolls_Royce");
        a.add("Saab");
        a.add("Saturn");
        a.add("Subaru");
        a.add("Suzuki");
        a.add("Toyota");

        return a;
    }

    public static List<String> getBikeBrands() {
        final ArrayList<String> a = new ArrayList<>();

        a.add("Aprilia");
        a.add("Beta Motor");
        a.add("Bimota");
        a.add("Bultaco");
        a.add("Cagiva");
        a.add("Derbi");
        a.add("Ducati");
        a.add("Energica Motor Company");
        a.add("Erik Buell Racing");
        a.add("Fantic Motor");
        a.add("Gas Gas");
        a.add("Ghezzi & Brian");
        a.add("Gilera");
        a.add("Harley-Davidson");
        a.add("Honda");
        a.add("Indian Motorcycle Manufacturing Company");
        a.add("Italjet");
        a.add("Janus Motorcycles");
        a.add("Kawasaki");
        a.add("Lightning Motorcycle");
        a.add("MV Agusta");
        a.add("Malaguti");
        a.add("Minarelli (engines only)");
        a.add("Montesa");
        a.add("Moto Guzzi");
        a.add("Moto Morini");
        a.add("Ossa");
        a.add("Paton");
        a.add("Piaggio");
        a.add("Rieju");
        a.add("SWM");
        a.add("Sanglas");
        a.add("Suzuki");
        a.add("Terra Modena");
        a.add("Vespa");
        a.add("Vyrus");
        a.add("Yamaha");

        return a;
    }

}
