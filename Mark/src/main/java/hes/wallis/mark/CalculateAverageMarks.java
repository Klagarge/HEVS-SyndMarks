package hes.wallis.mark;

import java.util.Vector;

public class CalculateAverageMarks {

    private static void add(Vector<Double> v, Double mark, int pond){
        for (int i = 0; i < pond; i++) {
            if (mark >= 1.0) v.add(mark);
        }
    }
    private static void add(Vector<Double> v, Double mark){
        add(v, mark, 1);
    }
    private static Double average(Vector<Double> v){
        Double average = 0.0;
        for (Double m : v) {
            average += m;
        }
        return v.size() == 0 ? 0.0 : average / v.size();
    }
    private static Double average11(Double n1, Double n2){
        Vector<Double> v = new Vector<>();
        add(v, n1);
        add(v, n2);
        return average(v);
    }
    private static Double average21(Double n1, Double n2){
        Vector<Double> v = new Vector<>();
        add(v, n1, 2);
        add(v, n2, 1);
        return average(v);
    }
    private static Double average1111(Double n1, Double n2, Double n3, Double n4){
        Vector<Double> v = new Vector<>();
        add(v, n1);
        add(v, n2);
        add(v, n3);
        add(v, n4);
        return average(v);
    }

    //Language
    public static Double GermanS1(){
        Double markGermanS1Exam1 = Marks.getFromMemorize("S1GermanExam_1");
        Double markGermanS1Semester = Marks.getFromMemorize("S1GermanSemester");
        return Marks.aroundDixie(average11(markGermanS1Exam1, markGermanS1Semester));
    }
    public static Double GermanS2(){
        Double markGermanS2Exam1 = Marks.getFromMemorize("S2GermanExam_1");
        Double markGermanS2Project = Marks.getFromMemorize("S2GermanProject");
        Double markGermanS2Semester = Marks.getFromMemorize("S2GermanSemester");
        Double semester2 = average21(markGermanS2Exam1, markGermanS2Project);
        return Marks.aroundDixie(average11(semester2, markGermanS2Semester));
    }
    public static Double German(){
        Double markGermanS1Exam1 = Marks.getFromMemorize("S1GermanExam_1");
        Double markGermanS1Semester = Marks.getFromMemorize("S1GermanSemester");
        Double markGermanS2Exam1 = Marks.getFromMemorize("S2GermanExam_1");
        Double markGermanS2Project = Marks.getFromMemorize("S2GermanProject");
        Double semester2 = average21(markGermanS2Exam1, markGermanS2Project);
        Double markGermanS2Semester = Marks.getFromMemorize("S2GermanSemester");
        return Marks.aroundDemi(average1111(markGermanS1Exam1, markGermanS1Semester, semester2, markGermanS2Semester));
    }

    //Science
    public static Double MathematicsS1(){
        Double markMathematicsS1Exam1 = Marks.getFromMemorize("S1MathematicsExam_1");
        Double markMathematicsS1Exam2 = Marks.getFromMemorize("S1MathematicsExam_2");
        Double averageS1 = Marks.aroundDixie(average11(markMathematicsS1Exam1, markMathematicsS1Exam2));
        Double markMathematicsS1semester = Marks.getFromMemorize("S1MathematicsSemester");
        return Marks.aroundDixie(average11(averageS1, markMathematicsS1semester));
    }
    public static Double MathematicsS2(){
        Double markMathematicsS2Exam1 = Marks.getFromMemorize("S2MathematicsExam_1");
        Double markMathematicsS2Exam2 = Marks.getFromMemorize("S2MathematicsExam_2");
        Double averageS2 = Marks.aroundDixie(average11(markMathematicsS2Exam1, markMathematicsS2Exam2));
        Double markMathematicsS2semester = Marks.getFromMemorize("S2MathematicsSemester");
        return Marks.aroundDixie(average11(averageS2, markMathematicsS2semester));
    }
    public static Double Mathematics(){
        Double markMathematicsS1Exam1 = Marks.getFromMemorize("S1MathematicsExam_1");
        Double markMathematicsS1Exam2 = Marks.getFromMemorize("S1MathematicsExam_2");
        Double averageS1 = Marks.aroundDixie(average11(markMathematicsS1Exam1, markMathematicsS1Exam2));
        Double markMathematicsS1semester = Marks.getFromMemorize("S1MathematicsSemester");
        Double markMathematicsS2Exam1 = Marks.getFromMemorize("S2MathematicsExam_1");
        Double markMathematicsS2Exam2 = Marks.getFromMemorize("S2MathematicsExam_2");
        Double averageS2 = Marks.aroundDixie(average11(markMathematicsS2Exam1, markMathematicsS2Exam2));
        Double markMathematicsS2semester = Marks.getFromMemorize("S2MathematicsSemester");
        return Marks.aroundDixie(average1111(averageS1, markMathematicsS1semester, averageS2, markMathematicsS2semester));
    }
    public static Double ITS1(){
        Double markItS1Exam1 = Marks.getFromMemorize("S1ITExam_1");
        Double markItS1semester = Marks.getFromMemorize("S1ITSemester");
        Double bonusItS1 = Marks.getFromMemorize("S1ITBonus");

        double average = Marks.aroundDixie(average21(markItS1semester + bonusItS1, markItS1Exam1));
        if(average > 6.0) average = 6.0;

        return average;
    }
    public static Double ITS2(){
        Double markItS2Exam1 = Marks.getFromMemorize("S2ITExam_1");
        Double markItS2Project = Marks.getFromMemorize("S2ITProject");
        Double bonusItS2 = Marks.getFromMemorize("S2ITBonus");

        double average = Marks.aroundDixie(average21(markItS2Exam1 + bonusItS2, markItS2Project));
        if(average > 6.0) average = 6.0;
        return average;
    }
    public static Double IT(){
        Double markItS1Exam1 = Marks.getFromMemorize("S1ITExam_1");
        Double markItS1semester = Marks.getFromMemorize("S1ITSemester");
        Double bonusItS1 = Marks.getFromMemorize("S1ITBonus");
        Double itS2 = ITS2();

        Vector<Double> v = new Vector<>();
        add(v, markItS1Exam1);
        add(v, markItS1semester + bonusItS1, 2);
        add(v, itS2, 3);
        Double average = Marks.aroundDixie(average(v));
        if(average > 6.0) average = 6.0;

        return average;
    }
    public static Double Physics(){
        Double markPhysicsS2Exam1 = Marks.getFromMemorize("S2PhysicsExam_1");
        Double markPhysicsS2semester = Marks.getFromMemorize("S2PhysicsSemester");
        return Marks.aroundDixie(average11(markPhysicsS2Exam1, markPhysicsS2semester));
    }
    public static Double Science(){
        Double mathematics = Mathematics();
        Double it = IT();
        Double phys = Physics();

        Vector<Double> v = new Vector<>();
        add(v, mathematics, 16);
        add(v, it, 7);
        add(v, phys, 3);

        return Marks.aroundDemi(average(v));
    }

    //Business
    private static Double ElNS1Sem(){
        Double markEINS1Exam1 = Marks.getFromMemorize("S1EINExam_1");
        Double markEINS1Exam2 = Marks.getFromMemorize("S1EINExam_2");
        Double markEINS1Project = Marks.getFromMemorize("S1EINProject");

        Vector<Double> v = new Vector<>();
        add(v, markEINS1Exam1, 3);
        add(v, markEINS1Exam2, 3);
        add(v, markEINS1Project, 4);
        return average(v);
    }
    public static Double ElN(){
        Double markElNS1Sem = ElNS1Sem();
        Double markEINS1semester = Marks.getFromMemorize("S1EINSemester");

        return Marks.aroundDixie(average11(markElNS1Sem, markEINS1semester));
    }
    public static Double ElALabs(){
        Double markElAS2Lab1 = Marks.getFromMemorize("S2ElALab_1");
        Double markElAS2Lab2 = Marks.getFromMemorize("S2ElALab_2");
        Double markElAS2Lab3 = Marks.getFromMemorize("S2ElALab_3");
        Double markElAS2Lab4 = Marks.getFromMemorize("S2ElALab_4");
        Double markElAS2Lab5 = Marks.getFromMemorize("S2ElALab_5");
        Double markElAS2Lab6 = Marks.getFromMemorize("S2ElALab_6");
        Double markElAS2Lab7 = Marks.getFromMemorize("S2ElALab_7");
        Double markElAS2Rapport = Marks.getFromMemorize("S2ElARapport");

        Vector<Double> v = new Vector<>();
        add(v, markElAS2Lab1);
        add(v, markElAS2Lab2);
        add(v, markElAS2Lab3);
        add(v, markElAS2Lab4);
        add(v, markElAS2Lab5);
        add(v, markElAS2Lab6);
        add(v, markElAS2Lab7);
        add(v, markElAS2Rapport);
        return  average(v);
    }
    private static Double ElAS2Sem(){
        Double markElALabs = ElALabs();
        Double markElAS2Exam1 = Marks.getFromMemorize("S2ElAExam_1");
        Double markElAS2Exam2 = Marks.getFromMemorize("S2ElAExam_2");

        Vector<Double> v = new Vector<>();
        add(v, markElALabs, 1);
        add(v, markElAS2Exam1, 2);
        add(v, markElAS2Exam2, 2);
        return  average(v);
    }
    public static Double ElA(){
        Double markElAS2Sem = ElAS2Sem();
        Double markElAS2semester = Marks.getFromMemorize("S2ElASemester");
        return Marks.aroundDixie(average11(markElAS2Sem, markElAS2semester));
    }
    public static Double Electricity(){
        Double eln = Marks.aroundDixie(ElN());
        Double ela = Marks.aroundDixie(ElA());
        return Marks.aroundDixie(average11(eln, ela));
    }

    public static Double TeMrapports(){
        Double markTeMS1Rapport1 = Marks.getFromMemorize("S1TeMRapport_1");
        Double markTeMS1Rapport2 = Marks.getFromMemorize("S1TeMRapport_2");
        Double markTeMS1Rapport3 = Marks.getFromMemorize("S1TeMRapport_3");

        Vector<Double> v = new Vector<>();
        add(v, markTeMS1Rapport1);
        add(v, markTeMS1Rapport2);
        add(v, markTeMS1Rapport3);
        return Marks.aroundDixie(average(v));
    }
    public static Double TeM(){
        Double averageRapport = TeMrapports();
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");

        Double averageS1Sem = average11(averageRapport, markTeMS1Exam1);
        return Marks.aroundDixie(average11(averageS1Sem, markTeMS1Semester));
    }
    public static Double Static(){
        Double markStaticS2Exam1 = Marks.getFromMemorize("S2StaticExam_1");
        Double markStaticS2Semester = Marks.getFromMemorize("S2StaticSemester");
        return Marks.aroundDixie(average11(markStaticS2Exam1, markStaticS2Semester));
    }
    public static Double CCoS1(){
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Project = Marks.getFromMemorize("S1CCoProject");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");

        Double averageS1 = Marks.aroundDixie(average11(markCCoS1Exam1, markCCoS1Project));
        return Marks.aroundDixie(average11(averageS1, markCCoS1Semester));
    }
    public static Double CCoS2(){
        Double markCCoS2Project = Marks.getFromMemorize("S2CCoProject");
        Double markCCoS2Semester = Marks.getFromMemorize("S2CCoSemester");

        return Marks.aroundDixie(average11(markCCoS2Project, markCCoS2Semester));
    }
    private static Double MecS1Sem(){
        Double averageTeMS1Rapport = TeMrapports();
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Project = Marks.getFromMemorize("S1CCoProject");

        Vector<Double> v = new Vector<>();
        add(v, markTeMS1Exam1, 3);
        add(v, averageTeMS1Rapport, 3);
        add(v, markCCoS1Exam1, 2);
        add(v, markCCoS1Project, 2);
        return Marks.aroundDixie(average(v));
    }
    private static Double MecS2Sem(){
        Double markStaticS2Exam1 = Marks.getFromMemorize("S2StaticExam_1");
        Double markStaticS2Semester = Marks.getFromMemorize("S2StaticSemester");
        Double markCCoS2Project = Marks.getFromMemorize("S2CCoProject");
        Double markCCoS2Semester = Marks.getFromMemorize("S2CCoSemester");

        return Marks.aroundDixie(average1111(markStaticS2Exam1, markStaticS2Semester, markCCoS2Project, markCCoS2Semester));
    }
    public static Double Mechanic(){
        Double averageSemester1 = MecS1Sem();
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");
        Double averageExamSemester1 = Marks.aroundDixie(average11(markTeMS1Semester, markCCoS1Semester));
        Double averageSemester2 = MecS2Sem();
        Double markStaticS2Semester = Marks.getFromMemorize("S2StaticSemester");
        Double markCCoS2Semester = Marks.getFromMemorize("S2CCoSemester");
        Double averageExamSemester2 = Marks.aroundDixie(average11(markStaticS2Semester, markCCoS2Semester));

        return Marks.aroundDixie(average1111(averageSemester1, averageExamSemester1, averageSemester2, averageExamSemester2));
    }

    public static Double Business(){
        Double ElNS1Sem = ElNS1Sem();
        Double ElNS1Exa = Marks.getFromMemorize("S1EINSemester");

        Double ElAS2Sem = ElAS2Sem();
        Double ElAS2Exa = Marks.getFromMemorize("S2ElASemester");

        Double MecS1Sem = MecS1Sem();
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");
        Double MecS1Exa = Marks.aroundDixie(average11(markTeMS1Semester, markCCoS1Semester));

        Double MecS2Sem = MecS2Sem();
        Double markStaticS2Semester = Marks.getFromMemorize("S2StaticSemester");
        Double markCCoS2Semester = Marks.getFromMemorize("S2CCoSemester");
        Double MecS2Exa = Marks.aroundDixie(average11(markStaticS2Semester, markCCoS2Semester));


        Double mechanic = average1111(MecS1Sem, MecS1Exa, MecS2Sem, MecS2Exa);
        Double electricity = average1111(ElNS1Sem, ElNS1Exa, ElAS2Sem, ElAS2Exa);
        return Marks.aroundDemi(average11(mechanic, electricity));
    }
}
