package hes.wallis.mark;

import android.util.Log;

public class CalculateAverageMarks {

    private static Double average(Double n1, Double n2){
        Double average;
        if(n1*n2 == 0.0){
            average = n1 + n2;
        } else {
            average = (n1 + n2)/2.0;
        }
        return average;
    }

    //Language
    public static Double German(){
        Double markGermanS1Exam1 = Marks.getFromMemorize("S1GermanExam_1");
        Double markGermanS1Semester = Marks.getFromMemorize("S1GermanSemester");
        return Marks.aroundDixie(average(markGermanS1Exam1, markGermanS1Semester));
    }

    //Science
    public static Double Mathematics(){
        Double markMathematicsS1Exam1 = Marks.getFromMemorize("S1MathematicsExam_1");
        Double markMathematicsS1Exam2 = Marks.getFromMemorize("S1MathematicsExam_2");
        Double markMathematicsS1semester = Marks.getFromMemorize("S1MathematicsSemester");

        Double averageS1 = Marks.aroundDixie(average(markMathematicsS1Exam1, markMathematicsS1Exam2));

        return Marks.aroundDixie(average(averageS1, markMathematicsS1semester));
    }
    public static Double ITbonus(){
        Double markItS1Bonus1 = Marks.getFromMemorize("S1ITBonus_1");
        Double markItS1Bonus2 = Marks.getFromMemorize("S1ITBonus_2");
        Double markItS1Project = Marks.getFromMemorize("S1ITProject");

        Double BonusS1 = 0.0;
        BonusS1 += markItS1Bonus1/43;
        BonusS1 += markItS1Bonus2/16.0;
        BonusS1 += 3*(markItS1Project/12.0);
        BonusS1 /= 5;
        BonusS1 *= 0.25;
        BonusS1 = Marks.around2Dixie(BonusS1);

        return BonusS1;
    }
    public static Double IT(){
        Double markItS1Exam1 = Marks.getFromMemorize("S1ITExam_1");
        Double markItS1semester = Marks.getFromMemorize("S1ITSemester");
        double BonusS1 = ITbonus();

        double average;
        if(markItS1Exam1 != 0.0 && markItS1semester != 0.0){
            average = (markItS1Exam1 + 2 * (markItS1semester+BonusS1))/3;
        } else {
            average = markItS1Exam1 + markItS1semester;
        }
        average = Marks.aroundDixie(average);
        if(average > 6.0) average = 6.0;

        return average;
    }
    public static Double Physic(){
        Double average = 0.0;
        return average;
    }
    public static Double Science(){
        Double math = Mathematics();
        Double it = IT();
        Double phys = Physic();

        Double average = 0.0;
        if(math != 0.0 && it != 0.0 && phys != 0.0){
            average += 16 * math;
            average += 7 * it;
            average += 3 * phys;
            average /= 26;
        } else if(math != 0.0 && it != 0.0){
            average += 16 * math;
            average += 7 * it;
            average /= 23;
        } else if(math != 0.0){
            average += math;
        } else if(it != 0.0){
            average += it;
        } else {
            average = 0.0;
        }
        average = Marks.aroundDemi(average);
        return average;
    }

    //Business
    public static Double TeMrapports(){
        Double markTeMS1Rapport1 = Marks.getFromMemorize("S1TeMRapport_1");
        Double markTeMS1Rapport2 = Marks.getFromMemorize("S1TeMRapport_2");
        Double markTeMS1Rapport3 = Marks.getFromMemorize("S1TeMRapport_3");

        Double averageRapport = 0.0;
        if(markTeMS1Rapport1 != 0.0 && markTeMS1Rapport2 != 0.0 && markTeMS1Rapport3 != 0.0){
            averageRapport += markTeMS1Rapport1;
            averageRapport += markTeMS1Rapport2;
            averageRapport += markTeMS1Rapport3;
            averageRapport /= 3;
        } else {
            averageRapport = average(markTeMS1Rapport2, markTeMS1Rapport3);
        }

        return Marks.aroundDixie(averageRapport);
    }
    public static Double TeM(){
        Double averageRapport = TeMrapports();
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");

        Double average;
        if(markTeMS1Semester == 0.0){
            average = (averageRapport + markTeMS1Exam1)/2.0;
        } else if( (averageRapport != 0.0) && (markTeMS1Exam1 != 0.0) && (markTeMS1Semester != 0.0) ){
            average = (averageRapport + markTeMS1Exam1)/2.0;
            average = (average + markTeMS1Semester)/2.0;
        } else if(averageRapport*markTeMS1Exam1*markTeMS1Semester == 0.0) {
            average = averageRapport + markTeMS1Exam1 + markTeMS1Semester;
        } else {
            average = 0.0;
        }
        average = Marks.aroundDixie(average);

        return average;
    }
    public static Double CCo(){
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Project = Marks.getFromMemorize("S1CCoProject");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");

        Double averageS1 = Marks.aroundDixie(average(markCCoS1Exam1, markCCoS1Project));


        return Marks.aroundDixie(average(averageS1, markCCoS1Semester));
    }
    public static Double Mechanic(){
        Double markTeMS1Rapport1 = Marks.getFromMemorize("S1TeMRapport_1");
        Double markTeMS1Rapport2 = Marks.getFromMemorize("S1TeMRapport_2");
        Double markTeMS1Rapport3 = Marks.getFromMemorize("S1TeMRapport_3");
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Project = Marks.getFromMemorize("S1CCoProject");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");

        //Rapport TeM
        Double averageRapport;
        if(markTeMS1Rapport1*markTeMS1Rapport2 == 0.0){
            averageRapport = markTeMS1Rapport1 + markTeMS1Rapport2;
        } else {
            averageRapport = (markTeMS1Rapport1 + markTeMS1Rapport2)/2.0;
        }
        averageRapport = Marks.aroundDixie(averageRapport);

        //Note semestre
        Double averageSemester1 = 0.0;

        boolean S1TeMEx1 = false;
        if (markTeMS1Exam1 != 0.0) S1TeMEx1 = true;
        boolean S1rapportsTeM = false;
        if (averageRapport != 0.0) S1rapportsTeM = true;
        boolean S1projet = false;
        if (markCCoS1Project != 0.0) S1projet = true;
        boolean S1CCoEx1 = false;
        if (markCCoS1Exam1 != 0.0) S1CCoEx1 = true;

        if(S1TeMEx1 && S1rapportsTeM && S1CCoEx1 && S1projet){
            averageSemester1 += 3 * markTeMS1Exam1;
            averageSemester1 += 3 * averageRapport;
            averageSemester1 += 2 * markCCoS1Exam1;
            averageSemester1 += 2 * markCCoS1Project;
            averageSemester1 /= 10.0;
        } else if(S1TeMEx1 && S1rapportsTeM && S1CCoEx1) {
            averageSemester1 += 3 * markTeMS1Exam1;
            averageSemester1 += 3 * averageRapport;
            averageSemester1 += 2 * markCCoS1Exam1;
            averageSemester1 /= 8.0;
        } else {
            averageSemester1 = 0.0;
        }
        averageSemester1 = Marks.aroundDixie(averageSemester1);

        Double averageExamSemester1;
        if(markTeMS1Semester*markCCoS1Semester == 0.0){
            averageExamSemester1 = markTeMS1Semester + markCCoS1Semester;
        } else {
            averageExamSemester1 = (markTeMS1Semester + markCCoS1Semester)/2.0;
        }
        averageExamSemester1 = Marks.aroundDixie(averageExamSemester1);


        Double average;
        if(averageExamSemester1 != 0.0){
            average = (averageSemester1+averageExamSemester1)/2.0;
        } else {
            average = averageSemester1;
        }
        average = Marks.aroundDixie(average);
        return average;
    }
    public static Double EIN(){
        Double markEINS1Exam1 = Marks.getFromMemorize("S1EINExam_1");
        Double markEINS1Exam2 = Marks.getFromMemorize("S1EINExam_2");
        Double markEINS1Project = Marks.getFromMemorize("S1EINProject");
        Double markEINS1semester = Marks.getFromMemorize("S1EINSemester");

        Double averageSemester1 = 0.0;
        if(markEINS1Exam1 != 0.0 && markEINS1Exam2 != 0.0 && markEINS1Project != 0.0){
            averageSemester1 += 3.0 * markEINS1Exam1;
            averageSemester1 += 3.0 * markEINS1Exam2;
            averageSemester1 += 4.0 * markEINS1Project;
            averageSemester1 /= 10.0;
        } else if (markEINS1Exam1 != 0.0 && markEINS1Exam2 != 0.0){
            averageSemester1 += 3.0 * markEINS1Exam1;
            averageSemester1 += 3.0 * markEINS1Exam2;
            averageSemester1 /= 6.0;
        } else if (markEINS1Exam1 != 0.0){
            averageSemester1 += markEINS1Exam1;
        } else {
            averageSemester1 = 0.0;
        }
        averageSemester1 = Marks.aroundDixie(averageSemester1);

        Double average;
        if(averageSemester1 != 0 && markEINS1semester != 0){
            average = (averageSemester1+markEINS1semester)/2.0;
        } else {
            average = averageSemester1+markEINS1semester;
        }
        average = Marks.aroundDixie(average);
        return average;
    }
    public static Double EIA(){
        Double average = 0.0;
        return average;
    }
    public static Double Electricity(){
        Double ein = Marks.aroundDixie(EIN());
        Double eia = Marks.aroundDixie(EIA());
        return Marks.aroundDixie(average(ein, eia));
    }
    public static Double Business(){
        Double mechanic = Mechanic();
        Double electricity = Electricity();
        return Marks.aroundDemi(average(mechanic, electricity));
    }
}
