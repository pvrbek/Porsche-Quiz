package com.porscheinterauto.porchequiz;

/**
 * Created by Predsjednik on 08-Jan-18.
 */

public class Questions {

    public String mQuestions[]={
            "Koja je generacija modela Cayenne 2018",
            "Kolika je snaga modela Panamera 4 Hybrid?",
            "Koja je zapremina i snaga početnog benzinskog modela Macan?",
            "Koju snagu i zapremninu ima model Boxster S?",
            "Ima li u serijskoj opremi model Cayenne 2018 prednje i stražnje parking senzore?",
            "Koji je skraćeni naziv automatskog mjenjača u modelu Macan?",
            "Dolazi li Porsche Panamera 4 Hybrid u serijskoj opremi sa Sport Chrono Paketom?",
            "U kojem modu vožnje se može aktivirati Launch Control (racing start)?",
            "Koliko vremenski traje SPORT Response gumb?",
            "Dolazi li Cayenne 2018 s različitom dimenzijom pneumatika naprijed i odostraga?"
    };

    private String mChoices[][]={
        {"1","2","3"},
        {"440ks","462ks","330ks"},
        {"2997 cm3 – 340 ks","2967 cm3 – 258 ks","1984 cm3 – 252 ks"},
        {"1998 cm3 -300 ks","2497 cm3 -350 ks","2981 cm3 – 370 ks"},
        {"Da","Ne","Samo stražnje parking-senzore"},
        {"DSG","Tiptronic","PDK"},
        {"Da","Ne","Sport Chrono Paket ne postoji u ponudi"},
        {"Normal","Sport Plus","Sport"},
        {"18 sec","20 sec","10 sec"},
        {"Da","Ne","Različita dimenzija pneumatika ne postoji u ponudi"}
    };
    private String mCorrectAnswers[]={"3","462ks","1984 cm3 – 252 ks","2497 cm3 -350 ks","Da","PDK","Da","Sport Plus","20 sec","Da"};

    public String getQuestion(int a){
        String question=mQuestions[a];
        return question;
    }
    public String getChoice2(int a){
        String choice= mChoices[a][0];
        return choice;
    }
    public String getChoice3(int a){
        String choice= mChoices[a][1];
        return choice;
    }
    public String getChoice4(int a){
        String choice= mChoices[a][2];
        return choice;
    }
    public String getCorrect(int a){
        String answer=mCorrectAnswers[a];
        return answer;
    }
}

